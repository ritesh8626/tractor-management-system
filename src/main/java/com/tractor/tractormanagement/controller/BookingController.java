package com.tractor.tractormanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tractor.tractormanagement.model.Booking;
import com.tractor.tractormanagement.model.PaymentStatus;
import com.tractor.tractormanagement.model.Tractor;
import com.tractor.tractormanagement.model.User;
import com.tractor.tractormanagement.model.Worker;
import com.tractor.tractormanagement.repository.BookingRepository;
import com.tractor.tractormanagement.repository.TractorRepository;
import com.tractor.tractormanagement.repository.UserRepository;
import com.tractor.tractormanagement.repository.WorkerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TractorRepository tractorRepository;
    private final WorkerRepository workerRepository;

    @PostMapping
    public Booking createBooking(@RequestBody Booking bookingRequest) {
        // Fetch actual entities from DB (optional, if you send only IDs in request)
        User user = userRepository.findById(bookingRequest.getAppUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tractor tractor = tractorRepository.findById(bookingRequest.getTractor().getId())
                .orElseThrow(() -> new RuntimeException("Tractor not found"));

        Worker worker = workerRepository.findById(bookingRequest.getWorker().getId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        Booking booking = new Booking();
        booking.setAppUser(user);               // Use correct field name
        booking.setTractor(tractor);
        booking.setWorker(worker);
        booking.setHours(bookingRequest.getHours());
        booking.setTotalAmount(bookingRequest.getTotalAmount());
        booking.setBookingDate(LocalDate.now());

        // Make sure you pass PaymentStatus, not String
        booking.setPaymentStatus(
                bookingRequest.getPaymentStatus() != null ? bookingRequest.getPaymentStatus() : PaymentStatus.PENDING
        );

        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}