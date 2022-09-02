package entity;

import java.sql.Date;

public class Candidate extends User {

    private Integer voterId;
    private String phone;
    private String username;
    private String password;

    public Candidate(Integer roleId, String name, String email, Date dob, String address, Integer voterId, String phone, String username, String password) {
        super(roleId, name, email, dob, address);
        this.voterId = voterId;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Candidate() {
    }

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
