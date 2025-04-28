package co.edu.unicauca.asae.app_formats_a.domain.models;

import java.util.List;

public class Professor {

    private Long id;
    private String name;
    private String lastName;
    private String groupName;
    private String email;
    private List<HistoricalRecord> historicalRecord;
    private List<AFormat> aFormats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<HistoricalRecord> getHistoricalRecord() {
        return historicalRecord;
    }

    public void setHistoricalRecord(List<HistoricalRecord> historicalRecord) {
        this.historicalRecord = historicalRecord;
    }

    public List<AFormat> getaFormats() {
        return aFormats;
    }

    public void setAFormats(List<AFormat> aFormats) {
        this.aFormats = aFormats;
    }

    public void addFormat(AFormat aFormat) {
        this.aFormats.add(aFormat);
        aFormat.setObjProfessor(this);
    }

}
