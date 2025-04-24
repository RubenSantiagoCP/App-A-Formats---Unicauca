package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class AFormat {

    private Long id;
    private String generalObjective;
    private String title;
    private List<String> specificObjective;
    private Professor objProfessor;
    private State state;
    private List<Evaluation> evaluations;

    public AFormat(Long id, String generalObjective, String title, List<String> specificObjective,
            Professor objProfessor, State state, List<Evaluation> evaluations) {
        this.id = id;
        this.generalObjective = generalObjective;
        this.title = title;
        this.specificObjective = specificObjective;
        this.objProfessor = objProfessor;
        this.state = state;
        this.evaluations = evaluations;
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

}
