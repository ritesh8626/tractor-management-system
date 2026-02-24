package com.tractor.tractormanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import com.tractor.tractormanagement.model.*;
import com.tractor.tractormanagement.repository.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BookingController {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final TractorRepository tractorRepository;
    private final WorkerRepository workerRepository;

    @PostMapping("/{userId}/{tractorId}/{workerId}")
    public Booking createBooking(
            @PathVariable Long userId,
            @PathVariable Long tractorId,
            @PathVariable Long workerId,
            @RequestBody Booking booking) {

        User user = userRepository.findById(userId).orElseThrow();
        Tractor tractor = tractorRepository.findById(tractorId).orElseThrow();
        Worker worker = workerRepository.findById(workerId).orElseThrow();

        booking.setAppUser(user);
        booking.setTractor(tractor);
        booking.setWorker(worker);
        booking.setBookingDate(LocalDate.now());
        booking.setPaymentStatus(PaymentStatus.PENDING);

        tractor.setStatus(TractorStatus.BOOKED);
        tractorRepository.save(tractor);

        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }
}