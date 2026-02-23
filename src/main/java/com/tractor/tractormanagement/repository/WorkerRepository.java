package com.tractor.tractormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tractor.tractormanagement.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}