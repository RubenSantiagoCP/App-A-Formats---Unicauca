package co.edu.unicauca.asae.app_formats_a.application.output;


import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;

public interface ManageObservationGatewayIntPort {
    
    public Observation save(Observation observation);
}
