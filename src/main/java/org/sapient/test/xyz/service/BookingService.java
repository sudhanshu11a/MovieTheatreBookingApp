package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.BookTicket;
import org.sapient.test.xyz.enums.PaymentType;

import java.util.List;
import java.util.Optional;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public interface BookingService {


    List<BookTicket> getAllBooking() throws Exception;

    List<BookTicket> getAllBookingByUserId(String name) throws Exception;

    Optional<BookTicket> getBookingByBookId(String bookingId) throws Exception;

    Optional<BookTicket> bookTicket(String userId, String showId, int numberOfSeats, PaymentType paymentType) throws Exception;

    BookTicket saveBookTicket(BookTicket bookTicket) throws Exception;

    BookTicket updateBookTicket(String bookingId, BookTicket booking) throws Exception;

    boolean cancelBookTicket(String bookingId) throws Exception;
}
