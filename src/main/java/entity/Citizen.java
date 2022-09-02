package entity;

import java.sql.Date;

public class Citizen extends User{

    private String phone;
    private String username;
    private String password;
    private Integer voterId;

    public Citizen(Integer roleId, String name, String email, Date dob, String address, String phone, String username, String password, Integer voterId) {
        super(roleId, name, email, dob, address);
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.voterId = voterId;
    }

    public Citizen() {
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

    public Integer getVoterId() {
        return voterId;
    }

    public void setVoterId(Integer voterId) {
        this.voterId = voterId;
    }
}
