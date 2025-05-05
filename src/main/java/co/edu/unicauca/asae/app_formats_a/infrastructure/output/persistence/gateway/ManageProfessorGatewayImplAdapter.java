package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;
import co.edu.unicauca.asae.app_formats_a.commons.utils.PrintUtils;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.CycleAvoidingMappingContext;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.ProfessorOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ManageProfessorGatewayImplAdapter implements ManageProfessorGatewayIntPort {

    private final ProfessorRepositoryInt professorRepository;
    private final ProfessorOutputMapper professorOutputMapper;
    private final AFormatOutputMapper aFormatOutputMapper;

    @Override
    @Transactional(readOnly = true)
    public boolean existsProfessorByEmail(String email) {
        return professorRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existById(Long id){
        return professorRepository.existsById(id);
    }

    @Override
    @Transactional
    public Professor save(Professor professor) {
        ProfessorEntity professorEntity = professorOutputMapper.toEntity(professor);
        professorEntity = professorRepository.save(professorEntity);
        return professorOutputMapper.toDomainIgnoringRecordsAndFormats(professorEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern) {
        List<ProfessorEntity> professors = professorRepository.findByGroupNameAndLastNameStartingWithIgnoreCaseOrderByLastNameAsc(groupName, pattern);
        return professorOutputMapper.toDomainList(professors);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Professor> findById(Long id) {
        Optional<ProfessorEntity> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return Optional.of(professorOutputMapper.toDomainIgnoringRecordsAndFormats(professor.get()));
        }
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> getAllProfessorsById(List<Long> ids) {
        List<ProfessorEntity> professors = professorRepository.findAllById(ids);
        return professorOutputMapper.toDomainList(professors);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return professorRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Professor>> getCommiteeMembers() {
        PrintUtils.writeSubHeader("Before Fetching Committee Members from the database...");
        Optional<List<ProfessorEntity>> dbProffesors = professorRepository.findAllByHistoricalRecord_ObjRole_AssignedRole(RoleEnum.COMMITTEE_MEMBER);
        PrintUtils.writeSubHeader("After Fetching Committee Members from the database...");
        return dbProffesors.flatMap(entities -> Optional.of(professorOutputMapper.toDomainListWithRecords(entities, new CycleAvoidingMappingContext())));
    }


    @Override
    @Transactional(readOnly = true)
    public List<AFormat> getAllAFormatsById(Long id) {
        PrintUtils.writeSubHeader("Before Fetching AFormats By Professor Id from the database...");
        //System.err.flush();
        Optional<ProfessorEntity> professorEntity = this.professorRepository.findById(id);
        PrintUtils.writeSubHeader("After Fetching AFormats By Professor Id from the database...");
        //System.err.flush();
        if (professorEntity.isPresent()) {
            List<AFormatEntity> aFormatEntities = professorEntity.get().getAFormats();
            return this.aFormatOutputMapper.toDomainList(aFormatEntities);
        }

        return null;

    }


}
