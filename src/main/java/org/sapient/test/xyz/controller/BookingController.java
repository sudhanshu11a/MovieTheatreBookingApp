package org.sapient.test.xyz.controller;

import org.sapient.test.xyz.entity.BookTicket;
import org.sapient.test.xyz.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Sudhanshu Sharma
 * on 11-07-2022
 */
@RestController
@RequestMapping("/api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_USER')")
    @GetMapping(value = "/ticket/booking", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookTicket>> getAllBooking() throws Exception {
        return ResponseEntity.ok().body(bookingService.getAllBooking());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_USER')")
    @GetMapping(value = "/secure/ticket/booking/{bookingId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookTicket> getBooking(@PathVariable String bookingId) throws Exception {
        Optional<BookTicket> bookTicketOptional = bookingService.getBookingByBookId(bookingId);
        return ResponseEntity.of(bookTicketOptional);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_USER')")
    @PostMapping(value = "/secure/ticket/booking", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookTicket> saveBooking(@RequestBody BookTicket booking) throws Exception {
        return ResponseEntity.ok().body(bookingService.saveBookTicket(booking));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_MANAGER', 'ROLE_USER')")
    @PutMapping(value = "/secure/ticket/booking/{bookingId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookTicket> updateBooking(@PathVariable String bookingId, @RequestBody BookTicket booking) throws Exception {
        return ResponseEntity.ok().body(bookingService.updateBookTicket(bookingId, booking));
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @DeleteMapping(value = "/secure/ticket/booking/{bookingId}")
    public ResponseEntity<Boolean> deleteBooking(@PathVariable String bookingId) throws Exception {
        return ResponseEntity.ok().body(bookingService.cancelBookTicket(bookingId));
    }
}
