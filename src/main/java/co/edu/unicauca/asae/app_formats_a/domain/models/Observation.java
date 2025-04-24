package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.time.LocalDate;
import java.util.List;

public class Observation {

    private Long id;
    private String observation;
    private LocalDate observationDateRegister;
    private List<Professor> proffesors;
    private Evaluation objEvaluation;

    public Observation(Long id, String observation, LocalDate observationDateRegister, List<Professor> proffesors,
            Evaluation objEvaluation) {
        this.id = id;
        this.observation = observation;
        this.observationDateRegister = observationDateRegister;
        this.proffesors = proffesors;
        this.objEvaluation = objEvaluation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public LocalDate getObservationDateRegister() {
        return observationDateRegister;
    }

    public void setObservationDateRegister(LocalDate observationDateRegister) {
        this.observationDateRegister = observationDateRegister;
    }

    public List<Professor> getProffesors() {
        return proffesors;
    }

    public void setProffesors(List<Professor> proffesors) {
        this.proffesors = proffesors;
    }

    public Evaluation getObjEvaluation() {
        return objEvaluation;
    }

    public void setObjEvaluation(Evaluation objEvaluation) {
        this.objEvaluation = objEvaluation;
    }

}
