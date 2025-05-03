package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class PPAFormat extends AFormat {

    private String assesorName;
    private String student1Name;
    private String acceptanceLetterRoute;

    public PPAFormat(Long id, String generalObjective, String title, List<String> specificObjective,
            Professor objProfessor, State state, List<Evaluation> evaluations, String assesorName, String studedt1Name,
            String acceptanceLetterRoute) {
        super(id, generalObjective, title, specificObjective, objProfessor, state, evaluations);
        this.assesorName = assesorName;
        this.student1Name = studedt1Name;
        this.acceptanceLetterRoute = acceptanceLetterRoute;
    }

    public String getAssesorName() {
        return assesorName;
    }

    public void setAssesorName(String assesorName) {
        this.assesorName = assesorName;
    }

    public String getStudent1Name() {
        return student1Name;
    }

    public void setStudent1Name(String student1Name) {
        this.student1Name = student1Name;
    }

    public String getAcceptanceLetterRoute() {
        return acceptanceLetterRoute;
    }

    public void setAcceptanceLetterRoute(String acceptanceLetterRoute) {
        this.acceptanceLetterRoute = acceptanceLetterRoute;
    }

}
