package org.sapient.test.xyz.service.impl;

import org.sapient.test.xyz.entity.*;
import org.sapient.test.xyz.enums.BookingStatus;
import org.sapient.test.xyz.enums.PaymentType;
import org.sapient.test.xyz.repository.BookingRepository;
import org.sapient.test.xyz.service.BookingService;
import org.sapient.test.xyz.service.SeatCategoryService;
import org.sapient.test.xyz.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SeatCategoryService seatCategoryService;

    @Autowired
    private ShowService showService;

    /**
     * @return returning all booking
     * @throws Exception
     */
    @Override
    public List<BookTicket> getAllBooking() throws Exception {
        return bookingRepository.findAll();
    }

    /**
     * @return returning all booking by booking id
     * @throws Exception
     */
    @Override
    public Optional<BookTicket> getBookingByBookId(String bookingId) throws Exception {
        return bookingRepository.findById(UUID.fromString(bookingId));
    }

    /**
     * @return returning all booking
     * @throws Exception
     */
    @Override
    public List<BookTicket> getAllBookingByUserId(String userId) throws Exception {
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

    @Override
    public Optional<BookTicket> bookTicket(String userId, String showId, int numberOfSeats, PaymentType paymentType) throws Exception {
        Show show = showService.getShow(showId);
        SeatCategory seatCategory = seatCategoryService.getSeatCategory(show.getSeatCategoryId());
        Optional<Set<Seat>> optionalSeatList = seatCategory.bookSeats(numberOfSeats);
        if(optionalSeatList.isPresent()){
            BookTicket bookTicket = new BookTicket(userId, show.getId(), seatCategory.getId(),
                    optionalSeatList.get().stream().map(BaseEntity::getId).collect(Collectors.toSet()),
                    seatCategory.getCost().multiply(new BigDecimal(numberOfSeats)), paymentType, BookingStatus.BOOKED);
            return Optional.of(bookTicket);
        }
        return Optional.empty();
    }

    /**
     * @param bookingId
     * @param bookTicket
     * @return
     * @throws Exception
     */
    @Override
    public BookTicket updateBookTicket(String bookingId, BookTicket bookTicket) throws Exception {
        Optional<BookTicket> bookTicketEntityOptional = bookingRepository.findById(UUID.fromString(bookingId));
        if (bookTicketEntityOptional.isPresent() && bookTicket != null) {
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
        Optional<BookTicket> bookTicketEntityOptional = bookingRepository.findById(UUID.fromString(bookingId));
        if (bookTicketEntityOptional.isPresent()) {
            bookTicketEntityOptional.get().setStatus(BookingStatus.CANCELLED);
            bookingRepository.save(bookTicketEntityOptional.get());
            return true;
        }
        return false;
    }
}
