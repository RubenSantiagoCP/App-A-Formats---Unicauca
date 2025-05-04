package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;

import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.AFormatOutputMapperWithoutDependencies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageAFormatGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.AFormat;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.AFormatRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManageAFormatGatewayImplAdapter implements ManageAFormatGatewayIntPort {

    private final AFormatRepositoryInt aFormatRepository;
    private final AFormatOutputMapper aFormatMapper;
    private final ProfessorRepositoryInt professorRepository;
    private final AFormatOutputMapperWithoutDependencies aFormatOutputMapperWithoutDependencies;
    
    @Override
    @Transactional
    public AFormat save(AFormat aFormat) {
        AFormatEntity aFormatEntity = aFormatMapper.toEntity(aFormat);
        aFormatEntity.getState().setObjAformat(aFormatEntity);
        aFormatEntity.getEvaluations().get(0).setObjAFormat(aFormatEntity);
        // Si nos mandan id
        if(aFormat.getObjProfessor().getId()!=null){
            //Buscamos el profesor
            ProfessorEntity professorEntity = professorRepository.getReferenceById(aFormat.getObjProfessor().getId());
            // Si existe lo asignamos
            if(professorEntity != null){
                aFormatEntity.setObjProfessor(professorEntity);
            }
            // Si no esiste, se crea solito

        }

        aFormatEntity = aFormatRepository.save(aFormatEntity);
        return aFormatMapper.toDomainCreate(aFormatEntity);
    } 

    @Override
    @Transactional(readOnly = true)
    public boolean existsAFormatByTitle(String title) {
        Long result = aFormatRepository.existsByTitle(title);
        if(result>0) return true;
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public AFormat findById(Long id) {
        AFormatEntity aFormat = aFormatRepository.findById(id).orElse(null);
        return aFormatMapper.toDomainCreate(aFormat);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return aFormatRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<AFormat>> findAllByProffesorBetween(Long id, LocalDate startDate, LocalDate endDate) {
        Optional<List<AFormatEntity>> dbFormats = aFormatRepository.findByTitleDatesAndProfessor(null, startDate, endDate, id);
        return dbFormats.flatMap(entities ->
                Optional.of(aFormatOutputMapperWithoutDependencies.toDomainList(entities)));

    }

}
