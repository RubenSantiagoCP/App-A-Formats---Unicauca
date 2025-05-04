package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class TIAFormat extends AFormat {

    private String student2Name;
    private Long student2Code;

    public TIAFormat() {}
    public TIAFormat(Long id, String generalObjective, String title, List<String> specificObjective, Professor objProfessor, State state, List<Evaluation> evaluations, String student1Name, Long student1code, String student2Name, Long student2Code) {
        super(id, generalObjective, title, specificObjective, objProfessor, state, evaluations, student1Name, student1code);
        this.student2Name = student2Name;
        this.student2Code = student2Code;
    }

    public String getStudent2Name() {
        return student2Name;
    }

    public void setStudent2Name(String student2Name) {
        this.student2Name = student2Name;
    }

    public Long getStudent2Code() {
        return student2Code;
    }

    public void setStudent2Code(Long student2Code) {
        this.student2Code = student2Code;
    }
}
