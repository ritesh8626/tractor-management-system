package com.tractor.tractormanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tractor.tractormanagement.model.Tractor;
import com.tractor.tractormanagement.repository.TractorRepository;

@RestController
@RequestMapping("/api/tractors")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TractorController {

    private final TractorRepository tractorRepository;

    @PostMapping
    public Tractor save(@RequestBody Tractor tractor) {
        return tractorRepository.save(tractor);
    }

    @GetMapping
    public List<Tractor> getAll() {
        return tractorRepository.findAll();
    }
}