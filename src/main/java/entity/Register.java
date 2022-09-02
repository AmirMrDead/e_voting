package entity;

public class Register implements BaseEntity {

    private Integer id;
    private Integer candidateId;
    private String description;
    private String type;
    private String name;
    private Integer citizenId;

    public Register(Integer id, Integer candidateId, String description, String type, String name, Integer citizenId) {
        this.id = id;
        this.candidateId = candidateId;
        this.description = description;
        this.type = type;
        this.name = name;
        this.citizenId = citizenId;
    }

    public Register() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

}
