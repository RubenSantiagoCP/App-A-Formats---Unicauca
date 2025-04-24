package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.time.LocalDate;

public class HistoricalRecord {

    private Long id;
    private Boolean active;
    private LocalDate startDate;
    private LocalDate endDate;
    private Professor professor;
    private Role role;

    

    public HistoricalRecord(Long id, Boolean active, LocalDate startDate, LocalDate endDate, Professor professor,
            Role role) {
        this.id = id;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.professor = professor;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
