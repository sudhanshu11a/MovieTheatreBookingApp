package org.sapient.test.xyz.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    private String city;

    private String mapLocation;

    public Address() {
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public Address(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                   String city, String mapLocation) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.city = city;
        this.mapLocation = mapLocation;
    }

    public Address(String city, String mapLocation){
        this.city = city;
        this.mapLocation = mapLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }
}
