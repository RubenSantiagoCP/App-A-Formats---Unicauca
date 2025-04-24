package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

import co.edu.unicauca.asae.app_formats_a.commons.enums.RoleEnum;

public class Role {

    private Long id;
    private RoleEnum assignedRole;
    private List<HistoricalRecord> historicalRecords;

    public Role(Long id, RoleEnum assignedRole, List<HistoricalRecord> historicalRecords) {
        this.id = id;
        this.assignedRole = assignedRole;
        this.historicalRecords = historicalRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getAssignedRole() {
        return assignedRole;
    }

    public void setAssignedRole(RoleEnum assignedRole) {
        this.assignedRole = assignedRole;
    }

    public List<HistoricalRecord> getHistoricalRecords() {
        return historicalRecords;
    }

    public void setHistoricalRecords(List<HistoricalRecord> historicalRecords) {
        this.historicalRecords = historicalRecords;
    }

}
