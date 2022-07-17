package org.sapient.test.xyz.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "shows")
public class Show extends BaseEntity {

    private String theatreId;

    private String movieId;

    private Integer screenNumber;

    private ZonedDateTime showStartTime;

    private ZonedDateTime showEndTime;

    private String seatCategoryId;

    public Show() {
    }

    public Show(String theatreId, Integer screenNumber, String movieId, ZonedDateTime showStartTime, ZonedDateTime showEndTime,
                String seatCategoryId) {
        this.theatreId = theatreId;
        this.screenNumber = screenNumber;
        this.movieId = movieId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.seatCategoryId = seatCategoryId;
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public Show(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                String theatreId, Integer screenNumber, String movieId, ZonedDateTime showStartTime, ZonedDateTime showEndTime,
                String seatCategory) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.theatreId = theatreId;
        this.screenNumber = screenNumber;
        this.movieId = movieId;
        this.showStartTime = showStartTime;
        this.showEndTime = showEndTime;
        this.seatCategoryId = seatCategoryId;
    }

    public String getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(String theatreId) {
        this.theatreId = theatreId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }

    public ZonedDateTime getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(ZonedDateTime showStartTime) {
        this.showStartTime = showStartTime;
    }

    public ZonedDateTime getShowEndTime() {
        return showEndTime;
    }

    public void setShowEndTime(ZonedDateTime showEndTime) {
        this.showEndTime = showEndTime;
    }

    public String getSeatCategoryId() {
        return seatCategoryId;
    }

    public void setSeatCategoryId(String seatCategoryId) {
        this.seatCategoryId = seatCategoryId;
    }
}
