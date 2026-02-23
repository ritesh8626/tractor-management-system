package com.tractor.tractormanagement.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.tractor.tractormanagement.model.Tractor;
import com.tractor.tractormanagement.repository.TractorRepository;

@RestController
@RequestMapping("/api/tractors")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TractorController {

    private final TractorRepository tractorRepository;

    @PostMapping
    public Tractor addTractor(@RequestBody Tractor tractor) {
        return tractorRepository.save(tractor);
    }

    @GetMapping
    public List<Tractor> getAllTractors() {
        return tractorRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTractor(@PathVariable Long id) {
        tractorRepository.deleteById(id);
    }
}