package co.edu.unicauca.asae.app_formats_a.application.input;

import java.util.List;

import co.edu.unicauca.asae.app_formats_a.domain.models.Observation;

public interface ManageObservationUCIntPort {
    
    public Observation save(Observation observation, Long formatId);

    public List<Observation> getAll();
}
