package org.sapient.test.xyz.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 *
 * A convenient base class for {@link Entity @Entity} classes that wish to
 * provide default columns of every entity.
 *
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@MappedSuperclass
public class BaseEntity {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    /** The created by. */
    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    /** The created date. */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    /** The modified by. */
    @Column(name = "modified_by", nullable = true)
    private Long modifiedBy;

    /** The modified date. */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date", nullable = true)
    private Date modifiedDate;

    @Column(name = "is_active", nullable = false)
    private Boolean active;

    public BaseEntity() {
        // Auto-generated constructor stub
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public BaseEntity(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active) {
        this.id = UUID.fromString(id);
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.active = active;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id==null?null:this.id.toString();
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id==null?null:UUID.fromString(id);
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = new Date();
        this.createdBy = 1l;
        this.active = true;
        this.modifiedDate = null;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = new Date();
        this.modifiedBy = 1l;
    }
}
