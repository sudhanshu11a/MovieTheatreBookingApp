package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.BookTicket;
import org.sapient.test.xyz.enums.BookingStatus;
import org.sapient.test.xyz.repository.BookingRepository;
import org.sapient.test.xyz.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    /**
     * @return
     * @throws Exception
     */
    @Override
    public List<BookTicket> getAllBooking() throws Exception {
        return bookingRepository.findAll();
    }

    /**
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public BookTicket getBookTicket(String userId) throws Exception {
        return bookingRepository.findByUserId(userId);
    }

    /**
     * @param bookTicket
     * @return
     * @throws Exception
     */
    @Override
    public BookTicket saveBookTicket(BookTicket bookTicket) throws Exception {
        return bookingRepository.save(bookTicket);
    }

    /**
     * @param bookingId
     * @param booking
     * @return
     * @throws Exception
     */
    @Override
    public BookTicket updateBookTicket(String bookingId, BookTicket bookTicket) throws Exception {
        Optional<BookTicket> bookTicketEntityOptional =  bookingRepository.findById(UUID.fromString(bookingId));
        if(bookTicketEntityOptional.isPresent() && bookTicket!=null){
            bookTicketEntityOptional.get().updateBookTicket(bookTicket);
            bookTicket = bookingRepository.save(bookTicketEntityOptional.get());
        }
        return bookTicket;
    }

    /**
     * @param bookingId
     * @return
     * @throws Exception
     */
    @Override
    public boolean cancelBookTicket(String bookingId) throws Exception {
        Optional<BookTicket> bookTicketEntityOptional =  bookingRepository.findById(UUID.fromString(bookingId));
        if(bookTicketEntityOptional.isPresent() ){
            bookTicketEntityOptional.get().setStatus(BookingStatus.CANCELLED);
            bookingRepository.save(bookTicketEntityOptional.get());
            return true;
        }
        return false;
    }
}
