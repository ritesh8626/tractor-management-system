package com.tractor.tractormanagement.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.tractor.tractormanagement.model.Booking;
import com.tractor.tractormanagement.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        booking.setPaymentStatus("Pending");
        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PutMapping("/pay/{id}")
    public Booking payBooking(@PathVariable Long id,
                              @RequestParam String method) {

        Booking booking = bookingRepository.findById(id).orElseThrow();
        booking.setPaymentMethod(method);
        booking.setPaymentStatus("Paid");

        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
    }
}