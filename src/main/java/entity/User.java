package entity;

import base.BaseEntity;

import java.sql.Date;

public abstract class User implements BaseEntity {

    private Integer id;
    private Integer roleId;
    private String name;
    private String email;
    private Date dob;
    private String address;


    public User(Integer roleId, String name, String email, Date dob, String address) {
        this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public User() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
