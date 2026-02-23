package com.tractor.tractormanagement.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.tractor.tractormanagement.model.Worker;
import com.tractor.tractormanagement.repository.WorkerRepository;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerRepository workerRepository;

    @PostMapping
    public Worker addWorker(@RequestBody Worker worker) {
        return workerRepository.save(worker);
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }
}