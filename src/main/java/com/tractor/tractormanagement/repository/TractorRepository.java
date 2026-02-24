package com.tractor.tractormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tractor.tractormanagement.model.Tractor;

public interface TractorRepository extends JpaRepository<Tractor, Long> {
}