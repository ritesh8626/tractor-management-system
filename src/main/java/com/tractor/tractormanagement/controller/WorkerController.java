package com.tractor.tractormanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tractor.tractormanagement.model.Worker;
import com.tractor.tractormanagement.repository.WorkerRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkerController {

    private final WorkerRepository workerRepository;

    @PostMapping
    public Worker save(@RequestBody Worker worker) {
        return workerRepository.save(worker);
    }

    @GetMapping
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }
}