package org.sapient.test.xyz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    private String name;

    @Column(columnDefinition="text")
    private String description;

    private Date releaseDate;

    public Movie() {
        // Auto-generated constructor stub
    }

    public Movie(String name, String description, Date releaseDate) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Movie(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active, String name, String description, Date releaseDate) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
