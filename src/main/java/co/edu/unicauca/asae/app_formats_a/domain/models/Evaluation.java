package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.time.LocalDate;
import java.util.List;

import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;

public class Evaluation {

    private Long id;
    private ConceptEnum concept;
    private LocalDate dateRegisterConcept;
    private String coordinatorName;
    private AFormat objAFormat;
    private List<Observation> observations;

    public Evaluation(Long id, ConceptEnum concept, LocalDate dateRegisterConcept, String coordinatorName,
            AFormat objAFormat, List<Observation> observations) {
        this.id = id;
        this.concept = concept;
        this.dateRegisterConcept = dateRegisterConcept;
        this.coordinatorName = coordinatorName;
        this.objAFormat = objAFormat;
        this.observations = observations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConceptEnum getConcept() {
        return concept;
    }

    public void setConcept(ConceptEnum concept) {
        this.concept = concept;
    }

    public LocalDate getDateRegisterConcept() {
        return dateRegisterConcept;
    }

    public void setDateRegisterConcept(LocalDate dateRegisterConcept) {
        this.dateRegisterConcept = dateRegisterConcept;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public AFormat getObjAFormat() {
        return objAFormat;
    }

    public void setObjAFormat(AFormat objAFormat) {
        this.objAFormat = objAFormat;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

}
