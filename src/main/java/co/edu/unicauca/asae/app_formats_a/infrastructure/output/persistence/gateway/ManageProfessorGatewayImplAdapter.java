package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
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

    @Override
    @Transactional
    public boolean existsProfessorByEmail(String email) {
        return professorRepository.existsByEmail(email);
    }

    @Override
    // @Transactional
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
    public Optional<Professor> findById(Long id) {
        Optional<ProfessorEntity> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            return Optional.of(professorOutputMapper.toDomainIgnoringRecordsAndFormats(professor.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Professor> getAllProfessorsById(List<Long> ids) {
        List<ProfessorEntity> professors = professorRepository.findAllById(ids);
        return professorOutputMapper.toDomainList(professors);
    }

    @Override
    public boolean existsById(Long id) {
        return professorRepository.existsById(id);
    }
   
   
}
