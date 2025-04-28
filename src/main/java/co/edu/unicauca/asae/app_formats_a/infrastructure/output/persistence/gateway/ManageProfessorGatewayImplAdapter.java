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
public class ManageProfessorGatewayImplAdapter implements ManageProfessorGatewayIntPort {

    private final ProfessorRepositoryInt professorRepository;
    private final ProfessorOutputMapper professorOutputMapper;

    @Override
    @Transactional
    public Optional<Professor> existsProfessorByEmail(String email) {
        ProfessorEntity professor = professorRepository.findByEmail(email);
        if (professor != null) {
            return Optional.of(professorOutputMapper.toDomain(professor));
        }
        return Optional.empty();
    }

    @Override
    // @Transactional
    public Professor save(Professor professor) {
        ProfessorEntity professorEntity = professorOutputMapper.toEntity(professor);
        professorEntity = professorRepository.save(professorEntity);
        return professorOutputMapper.toDomain(professorEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> getByGroupAndStartWithPattern(String groupName, String pattern) {
        List<ProfessorEntity> professors = professorRepository.findByGroupNameAndLastNameStartingWithIgnoreCaseOrderByLastNameAsc(groupName, pattern);
        return professorOutputMapper.toDomainList(professors);
    }

   
}
