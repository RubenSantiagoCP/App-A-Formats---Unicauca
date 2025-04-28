package co.edu.unicauca.asae.app_formats_a.application.output;

import co.edu.unicauca.asae.app_formats_a.domain.models.Evaluation;

public interface ManageEvaluationGatewayIntPort {
    
    public Evaluation getLastEvaluationByFormat(Long id);
    
}
