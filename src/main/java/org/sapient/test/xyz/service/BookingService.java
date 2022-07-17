package org.sapient.test.xyz.service;

import org.sapient.test.xyz.entity.BookTicket;

import java.util.List;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
public interface BookingService {


    List<BookTicket> getAllBooking() throws Exception;

    BookTicket getBookTicket(String name) throws Exception;

    BookTicket saveBookTicket(BookTicket bookTicket) throws Exception;

    BookTicket updateBookTicket(String bookingId, BookTicket booking) throws Exception;

    boolean cancelBookTicket(String bookingId) throws Exception;
}
