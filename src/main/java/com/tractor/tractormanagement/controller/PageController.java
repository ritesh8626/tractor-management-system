package com.tractor.tractormanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

   @GetMapping("/register")
    public String registerString() {
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // 👇 Farmer Dashboard
    @GetMapping("/farmer-dashboard")
    public String farmerDashboard() {
        return "farmer-dashboard";
    }

    // 👇 Admin Dashboard
    @GetMapping("/admin-dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/tractors")
    public String tractors() {
        return "tractors";
    }

    @GetMapping("/workers")
    public String workers() {
        return "workers";
    }

    @GetMapping("/booking")
    public String booking() {
        return "booking";
    }

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/admin-booking")
    public String adminBooking() {
        return "admin-booking";
    }

    @GetMapping("/driver")
    public String driver() {
        return "driver";
    }

    @GetMapping("/view-services")
    public String viewServices() {
        return "view-services";
    }
}
