package entity;

public class Role implements BaseEntity {

    private Integer id;
    private String title;
    private String description;

    public Role(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Role() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
