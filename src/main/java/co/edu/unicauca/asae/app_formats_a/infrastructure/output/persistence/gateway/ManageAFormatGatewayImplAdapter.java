package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.AFormatRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
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
        aFormatEntity.getState().setObjAformat(aFormatEntity);
        aFormatEntity.getEvaluations().get(0).setObjAFormat(aFormatEntity);
        ProfessorEntity professorEntity = professorRepository.getReferenceById(aFormat.getObjProfessor().getId());
        if(professorEntity != null){
            aFormatEntity.setObjProfessor(professorEntity);
        }
        aFormatEntity = aFormatRepository.save(aFormatEntity);
        return aFormatMapper.toDomain(aFormatEntity);
    } 

    @Override
    public boolean existsAFormatByTitle(String title) {
        return aFormatRepository.existsByTitle(title);
    }

    @Override
    public AFormat findById(Long id) {
        AFormatEntity aFormat = aFormatRepository.findById(id).orElse(null);
        return aFormatMapper.toDomain(aFormat);
    }

    @Override
    public boolean existsById(Long id) {
        return aFormatRepository.existsById(id);
    }
    
}
