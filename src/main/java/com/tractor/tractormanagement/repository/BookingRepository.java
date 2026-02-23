package com.tractor.tractormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tractor.tractormanagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}