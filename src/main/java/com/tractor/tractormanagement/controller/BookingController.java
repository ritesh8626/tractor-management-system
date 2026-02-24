package com.tractor.tractormanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.tractor.tractormanagement.model.Booking;
import com.tractor.tractormanagement.model.User;
import com.tractor.tractormanagement.model.Tractor;
import com.tractor.tractormanagement.model.Worker;
import com.tractor.tractormanagement.model.PaymentStatus;

import com.tractor.tractormanagement.repository.BookingRepository;
import com.tractor.tractormanagement.repository.UserRepository;
import com.tractor.tractormanagement.repository.TractorRepository;
import com.tractor.tractormanagement.repository.WorkerRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TractorRepository tractorRepository;
    private final WorkerRepository workerRepository;

    // ✅ CREATE BOOKING
    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestParam Long userId,
            @RequestParam Long tractorId,
            @RequestParam Long workerId,
            @RequestBody Booking booking) {

        User user = userRepository.findById(userId).orElse(null);
        Tractor tractor = tractorRepository.findById(tractorId).orElse(null);
        Worker worker = workerRepository.findById(workerId).orElse(null);

        if (user == null || tractor == null || worker == null) {
            return ResponseEntity.badRequest().body("Invalid User/Tractor/Worker ID");
        }

        booking.setUser(user);
        booking.setTractor(tractor);
        booking.setWorker(worker);
        booking.setPaymentStatus(PaymentStatus.PENDING);

        return ResponseEntity.ok(bookingRepository.save(booking));
    }

    // ✅ GET ALL BOOKINGS
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // ✅ PAY BOOKING
    @PutMapping("/pay/{id}")
    public ResponseEntity<?> payBooking(@PathVariable Long id,
                                        @RequestParam String method) {

        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking == null) {
            return ResponseEntity.badRequest().body("Booking Not Found");
        }

        booking.setPaymentMethod(method);
        booking.setPaymentStatus(PaymentStatus.PAID);

        return ResponseEntity.ok(bookingRepository.save(booking));
    }
}