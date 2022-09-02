package entity;

import java.util.Date;

public class Voting implements BaseEntity {

    private Integer id;
    private Integer candidateId;
    private Integer citizenId;
    private String type;
    private String description;
    private String timing;
    private Date date;

    public Voting(Integer candidateId, Integer citizenId, String type, String description, String timing, Date date) {
        this.candidateId = candidateId;
        this.citizenId = citizenId;
        this.type = type;
        this.description = description;
        this.timing = timing;
        this.date = date;
    }

    public Voting() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
