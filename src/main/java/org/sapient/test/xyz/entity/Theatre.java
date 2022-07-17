package org.sapient.test.xyz.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "theatre")
public class Theatre extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    private String type;

    private Integer numOfScreens;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Theatre() {
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public Theatre(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                   String name, String type, Integer numOfScreens, String emailId, Address address) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.name = name;
        this.type = type;
        this.numOfScreens = numOfScreens;
        this.emailId = emailId;
        this.address = address;
    }

    public Theatre(String name, String type, Integer numOfScreens, String emailId, Address address) {
        this.name = name;
        this.type = type;
        this.numOfScreens = numOfScreens;
        this.emailId = emailId;
        this.address = address;
    }

    public void updateTheatre(Theatre dto) {
        if (dto != null) {
            this.setName(dto.getName());
            this.setType(dto.getType());
            this.setNumOfScreens(dto.getNumOfScreens());
            this.setEmailId(dto.emailId);
            this.setAddress(dto.getAddress());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumOfScreens() {
        return numOfScreens;
    }

    public void setNumOfScreens(Integer numOfScreens) {
        this.numOfScreens = numOfScreens;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
