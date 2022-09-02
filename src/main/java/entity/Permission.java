package entity;

import base.BaseEntity;

public class Permission implements BaseEntity {

    private Integer id;
    private int roleId;
    private String title;
    private String module;
    private String description;

    public Permission(Integer id, int roleId, String title, String module, String description) {
        this.id = id;
        this.roleId = roleId;
        this.title = title;
        this.module = module;
        this.description = description;
    }

    public Permission() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
