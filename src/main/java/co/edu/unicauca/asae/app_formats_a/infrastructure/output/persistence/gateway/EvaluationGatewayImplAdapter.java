package co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.gateway;


import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.app_formats_a.application.output.ManageEvaluationGatewayIntPort;
import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.entities.EvaluationEntity;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.mappers.EvaluationOutputMapper;
import co.edu.unicauca.asae.app_formats_a.infrastructure.output.persistence.repositories.EvaluationRepositoryInt;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EvaluationGatewayImplAdapter implements ManageEvaluationGatewayIntPort {
    
    private final EvaluationRepositoryInt evaluationRepository;
    private final EvaluationOutputMapper evaluationOutputMapper;

    @Override
    @Transactional(readOnly = true)
    public Evaluation getLastEvaluationByFormat(Long id) {
        EvaluationEntity evaluation = evaluationRepository.lastEvaluationByFormat(id);
        return evaluationOutputMapper.toDomain(evaluation);
    }
    
}
