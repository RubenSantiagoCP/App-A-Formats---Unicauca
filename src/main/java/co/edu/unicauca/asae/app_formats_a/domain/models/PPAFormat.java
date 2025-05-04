package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class PPAFormat extends AFormat {

    private String assesorName;
    private String acceptanceLetterRoute;

    public PPAFormat() {
    }

    public PPAFormat(Long id, String generalObjective, String title, List<String> specificObjective, Professor objProfessor, State state, List<Evaluation> evaluations, String student1Name, Long student1code, String assesorName, String acceptanceLetterRoute) {
        super(id, generalObjective, title, specificObjective, objProfessor, state, evaluations, student1Name, student1code);
        this.assesorName = assesorName;
        this.acceptanceLetterRoute = acceptanceLetterRoute;
    }

    public String getAssesorName() {
        return assesorName;
    }

    public void setAssesorName(String assesorName) {
        this.assesorName = assesorName;
    }

    public String getAcceptanceLetterRoute() {
        return acceptanceLetterRoute;
    }

    public void setAcceptanceLetterRoute(String acceptanceLetterRoute) {
        this.acceptanceLetterRoute = acceptanceLetterRoute;
    }

}
