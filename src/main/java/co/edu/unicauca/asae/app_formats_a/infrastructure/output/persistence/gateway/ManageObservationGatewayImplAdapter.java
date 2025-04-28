package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageObservationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.AFormatEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ObservationEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.ProfessorEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.ObservationOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.AFormatRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.EvaluationRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ObservationRepositoryInt;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.ProfessorRepositoryInt;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManageObservationGatewayImplAdapter implements ManageObservationGatewayIntPort {

    private final ObservationOutputMapper observationMapper;
    private final EvaluationRepositoryInt evaluationRepository;
    private final ProfessorRepositoryInt professorRepository;
    private final ObservationRepositoryInt observationRepository;
    private final AFormatRepositoryInt aFormatRepository;

    @Override
    public Observation save(Observation observation, Long formatId) {
        ObservationEntity observationEntity = observationMapper.toEntity(observation);
        EvaluationEntity evaluationEntity = evaluationRepository.lastEvaluationByFormat(observation.getObjEvaluation().getId());
        AFormatEntity aFormatEntity = aFormatRepository.getReferenceById(formatId);
        evaluationEntity.setObjAFormat(aFormatEntity);
        observationEntity.setObjEvaluation(evaluationEntity);


        List<ProfessorEntity> professors = new ArrayList<>();
        for (ProfessorEntity professor : observationEntity.getProfessors()) {
           ProfessorEntity professorEntity = professorRepository.getReferenceById(professor.getId());
           if(professorEntity != null){
               professors.add(professorEntity);
           }
        }

        observationEntity.setProfessors(professors);
        
        observationEntity = observationRepository.save(observationEntity);
        return observationMapper.toDomain(observationEntity);

    }
    
}
