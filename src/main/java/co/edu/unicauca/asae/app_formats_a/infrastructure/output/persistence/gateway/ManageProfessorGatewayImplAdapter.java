package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageProfessorGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.ProfessorOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageProfessorGatewayImplAdapter implements ManageProfessorGatewayIntPort {

    private  final ProfessorRepositoryInt professorRepository;
    private final ProfessorOutputMapper professorOutputMapper;
    @Override
    public Optional<Professor> existsProfessorByEmail(String email){
        ProfessorEntity professor = professorRepository.findByEmail(email);
        if(professor != null){
            return Optional.of(professorOutputMapper.toDomain(professor));
        }
        return Optional.empty();
    }
}
