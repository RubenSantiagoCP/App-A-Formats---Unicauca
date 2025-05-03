package co.edu.unicauca.asae.app_formats_a.domain.models;

import co.edu.unicauca.asae.app_formats_a.commons.enums.ConceptEnum;
import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AFormat {

    private Long id;
    private String generalObjective;
    private String title;
    private List<String> specificObjective;
    private Professor objProfessor;
    private State state;
    private List<Evaluation> evaluations;
    private String student1Name;
    private Long student1code;

    public AFormat(Long id, String generalObjective, String title, List<String> specificObjective, Professor objProfessor, State state, List<Evaluation> evaluations, String student1Name, Long student1code) {
        this.id = id;
        this.generalObjective = generalObjective;
        this.title = title;
        this.specificObjective = specificObjective;
        this.objProfessor = objProfessor;
        this.state = state;
        this.evaluations = evaluations;
        this.student1Name = student1Name;
        this.student1code = student1code;
    }

    public String getStudent1Name() {
        return student1Name;
    }

    public void setStudent1Name(String student1Name) {
        this.student1Name = student1Name;
    }

    public Long getStudent1code() {
        return student1code;
    }

    public void setStudent1code(Long student1code) {
        this.student1code = student1code;
    }

    public Long getId() {
        return id;
    }

    public String getGeneralObjective() {
        return generalObjective;
    }

    public void setGeneralObjective(String generalObjective) {
        this.generalObjective = generalObjective;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSpecificObjective() {
        return specificObjective;
    }

    public void setSpecificObjective(List<String> specificObjective) {
        this.specificObjective = specificObjective;
    }

    public Professor getObjProfessor() {
        return objProfessor;
    }

    public void setObjProfessor(Professor objProfessor) {
        this.objProfessor = objProfessor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public void initialize() {
        this.setState(new State(null, StateEnum.FORMULATED, LocalDate.now(), this));
        Evaluation ev = new Evaluation(null, ConceptEnum.UNESTABLISHED, LocalDate.now(), "n/a", null, null);
        this.setEvaluations(new ArrayList<>(List.of(ev)));
    }

}
