package org.sapient.test.xyz.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "seat")
public class Seat extends BaseEntity{

    private String seatNumber;
    private boolean reserved;

    public Seat() {
    }

    public Seat(String seatNumber, boolean reserved) {
        this.seatNumber = seatNumber;
        this.reserved = reserved;
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public Seat(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                String seatNumber, boolean reserved) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.seatNumber = seatNumber;
        this.reserved = reserved;
    }

    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    public boolean reserve() {
        if(!this.reserved) {
            this.reserved = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if(this.reserved) {
            this.reserved = false;
            return true;
        } else {
            return false;
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
