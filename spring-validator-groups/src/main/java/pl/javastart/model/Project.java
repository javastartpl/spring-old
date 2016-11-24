package pl.javastart.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import pl.javastart.constraint.group.Complete;
import pl.javastart.constraint.group.Draft;

public class Project {

    @NotNull(groups = {Draft.class})
    @Size(min=3, groups = {Draft.class})
    private String title;
    @NotNull(groups = {Draft.class})
    @Past(groups = {Draft.class})
    private Date date;
    @NotNull(groups = {Complete.class})
    @Size(min=10, groups = {Complete.class})
    private String description;
    @NotNull(groups = {Complete.class})
    @Size(min=3, groups = {Complete.class})
    private String owner;
    
    public Project() {}
    
    public Project(String title, Date date, String description, String owner) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.owner = owner;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
}