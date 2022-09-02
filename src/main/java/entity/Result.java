package entity;

import base.BaseEntity;

import java.sql.Date;

public class Result implements BaseEntity {

    private Integer id;
    private Integer candidateId;
    private String type;
    private String description;
    private Date date;

    public Result(Integer id, Integer candidateId, String type, String description, Date date) {
        this.id = id;
        this.candidateId = candidateId;
        this.type = type;
        this.description = description;
        this.date = date;
    }

    public Result() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
