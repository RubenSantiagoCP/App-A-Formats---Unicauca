package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.domain.models.Professor;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.AFormatRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManageAFormatGatewayImplAdapter implements ManageAFormatGatewayIntPort {

    private final AFormatRepositoryInt aFormatRepository;
    private final AFormatOutputMapper aFormatMapper;
    private final ProfessorRepositoryInt professorRepository;

    @Override
    @Transactional
    public AFormat save(AFormat aFormat) {
        AFormatEntity aFormatEntity = aFormatMapper.toEntity(aFormat);
        String email = aFormat.getObjProfessor().getEmail();
    
        // Verifica si el profesor ya existe
        ProfessorEntity existingProfessor = this.professorRepository.findByEmail(email);
    
        if (existingProfessor!=null) {
            aFormatEntity.setObjProfessor(existingProfessor);
            existingProfessor.getAFormats().add(aFormatEntity); // mantiene bidireccional
        } else {
            ProfessorEntity newProfessor = aFormatEntity.getObjProfessor();
            newProfessor.setAFormats(new ArrayList<>());
            newProfessor.getAFormats().add(aFormatEntity); // mantiene bidireccional
            // 💡 No hace falta persistir aquí: el cascade lo hará
        }
    
        System.out.println("AFormatEntity: " + aFormatEntity.toString());
        System.out.println("AFormatEntity.getObjProfessor(): " + aFormatEntity.getObjProfessor().toString());
        aFormatEntity = aFormatRepository.save(aFormatEntity);
        return aFormatMapper.toDomain(aFormatEntity);
    } 

    @Override
    public boolean existsAFormatByTitle(String title) {
        return aFormatRepository.existsByTitle(title);
    }
    
}
