package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.time.LocalDate;

import co.edu.unicauca.asae.app_formats_a.commons.enums.StateEnum;

public class State {

    private Long id;
    private StateEnum actualState;
    private LocalDate registerStateDate;
    private AFormat objAformat;

    
    public State(Long id, StateEnum actualState, LocalDate registerStateDate, AFormat objAformat) {
        this.id = id;
        this.actualState = actualState;
        this.registerStateDate = registerStateDate;
        this.objAformat = objAformat;
    }

    public Long getId() {
        return id;
    }

    public StateEnum getActualState() {
        return actualState;
    }

    public LocalDate getRegisterStateDate() {
        return registerStateDate;
    }

    public AFormat getObjAformat() {
        return objAformat;
    }

    public void setActualState(StateEnum actualState) {
        this.actualState = actualState;
    }

    public void setRegisterStateDate(LocalDate registerStateDate) {
        this.registerStateDate = registerStateDate;
    }

    public void setObjAformat(AFormat objAformat) {
        this.objAformat = objAformat;
    }

}
