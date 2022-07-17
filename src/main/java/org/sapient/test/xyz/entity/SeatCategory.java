package org.sapient.test.xyz.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "seat_category")
public class SeatCategory extends BaseEntity {

    private String theatreId;

    private String category;

    private BigDecimal cost;

    private Integer totalSeats;

    private Integer availableSeats;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Set<Seat> seats;

    public SeatCategory() {
    }

    public SeatCategory(String theatreId, String category, BigDecimal cost, Integer totalSeats) {
        this.theatreId = theatreId;
        this.category = category;
        this.cost = cost;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        Set<Seat> seatSet = new HashSet<>(totalSeats);
        for(int i = 0; i< totalSeats; i++){
            Seat seat = new Seat(i+"", false);
            seatSet.add(seat);
        }
        this.seats = seatSet;
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public SeatCategory(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                        String theatreId, String category, BigDecimal cost, Integer totalSeats, Integer availableSeats, Set<Seat> seats) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.theatreId = theatreId;
        this.category = category;
        this.cost = cost;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.seats = seats;
    }

    public Optional<Set<Seat>> bookSeats(int numberOfSeats){
        if(totalSeats>numberOfSeats){
            Set<Seat> bookedSeats = new HashSet<>(numberOfSeats);
            for(int i=0; i< numberOfSeats; i++){
                Seat seat = new Seat(totalSeats-availableSeats+1+"", true);
                availableSeats--;
                bookedSeats.add(seat);
            }
            return Optional.of(bookedSeats);
        }
        return Optional.empty();
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

}
