package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class TIAFormat extends AFormat {

    private String student1Name;
    private String student2Name;

    public TIAFormat(Long id, String generalObjective, String title, List<String> specificObjective,
            Professor objProfessor, State state, List<Evaluation> evaluations, String student1Name,
            String student2Name) {
        super(id, generalObjective, title, specificObjective, objProfessor, state, evaluations);
        this.student1Name = student1Name;
        this.student2Name = student2Name;
    }

    public String getStudent1Name() {
        return student1Name;
    }

    public void setStudent1Name(String student1Name) {
        this.student1Name = student1Name;
    }

    public String getStudent2Name() {
        return student2Name;
    }

    public void setStudent2Name(String student2Name) {
        this.student2Name = student2Name;
    }

}
