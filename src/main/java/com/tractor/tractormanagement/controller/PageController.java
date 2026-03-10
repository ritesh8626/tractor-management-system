package com.tractor.tractormanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Login Page
    @GetMapping("/")
    public String login() {
        return "login";
    }

    // Home Page
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // Registration Page
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // Tractor Selection Page
    @GetMapping("/tractors")
    public String tractors() {
        return "tractors";
    }

    // Worker Listing Page
    @GetMapping("/workers")
    public String workers() {
        return "workers";
    }

    // Booking Page
    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    // Payment Page
    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    // Success Page
    @GetMapping("/success")
    public String success() {
        return "success";
    }

    // Admin Booking Page
    @GetMapping("/admin-booking")
    public String adminBooking() {
        return "admin-booking";
    }

    // Driver Record Page
    @GetMapping("/driver")
    public String driver() {
        return "driver";
    }

    // Add Tractor Page
    @GetMapping("/add-tractor")
    public String addTractor() {
        return "add-tractor";
    }

    // My Tractors Page
    @GetMapping("/my-tractors")
    public String myTractors() {
        return "my-tractors";
    }

    // My Workers Page
    @GetMapping("/my-workers")
    public String myWorkers() {
        return "my-workers";
    }

    // View Services Page
    @GetMapping("/view-services")
    public String viewServices() {
        return "view-services";
    }
}
