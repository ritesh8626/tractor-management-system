package com.tractor.tractormanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index.html";
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