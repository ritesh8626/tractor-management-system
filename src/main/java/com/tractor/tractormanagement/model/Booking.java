package com.tractor.tractormanagement.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String farmerName;
    private String mobile;
    private String serviceType;

    private String tractorName;
    private int hours;
    private double totalAmount;

    private LocalDate bookingDate;

    private String paymentMethod;
    private String paymentStatus; // Pending / Paid
}