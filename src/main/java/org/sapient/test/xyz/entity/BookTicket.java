package org.sapient.test.xyz.entity;

import org.sapient.test.xyz.enums.BookingStatus;
import org.sapient.test.xyz.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Entity
@Table(name = "booked_ticket")
public class BookTicket extends BaseEntity {

    private String userId;

    private String showId;

    private String seatCategoryId;

    @ElementCollection
    @CollectionTable(name = "seatId" )
    private Set<String> seatIds;

    private BigDecimal amountPaid;

    private PaymentType paymentType;

    private BookingStatus status;

    public BookTicket() {
    }

    /**
     * @param id
     * @param createdBy
     * @param createdDate
     * @param modifiedBy
     * @param modifiedDate
     * @param active
     */
    public BookTicket(String id, Long createdBy, Date createdDate, Long modifiedBy, Date modifiedDate, Boolean active,
                      String userId, String showId, String seatCategoryId, Set<String> seatIds, BigDecimal amountPaid, PaymentType paymentType, BookingStatus status) {
        super(id, createdBy, createdDate, modifiedBy, modifiedDate, active);
        this.userId = userId;
        this.showId = showId;
        this.seatCategoryId = seatCategoryId;
        this.seatIds = seatIds;
        this.amountPaid = amountPaid;
        this.paymentType = paymentType;
        this.status = status;
    }

    public void updateBookTicket(BookTicket bookTicket){
        this.userId = bookTicket.getUserId();
        this.showId = bookTicket.getShowId();
        this.seatCategoryId = bookTicket.getSeatCategoryId();
        this.seatIds = bookTicket.getSeatIds();
        this.amountPaid = bookTicket.getAmountPaid();
        this.paymentType = bookTicket.getPaymentType();
        this.status = bookTicket.getStatus();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getSeatCategoryId() {
        return seatCategoryId;
    }

    public void setSeatCategoryId(String seatCategoryId) {
        this.seatCategoryId = seatCategoryId;
    }

    public Set<String> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(Set<String> seatIds) {
        this.seatIds = seatIds;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
