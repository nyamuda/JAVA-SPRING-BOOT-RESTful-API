package com.physicsdefinitions.science.Repositories;

import java.util.Optional;

import com.physicsdefinitions.science.Models.PhysicsTopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PhysicsTopicsRepository
 */
@Repository
public interface PhysicsTopicsRepository extends JpaRepository<PhysicsTopic, Integer> {

    @Query("SELECT p FROM PhysicsTopic p WHERE p.id=?1")
    public Optional<PhysicsTopic> getTopic(int id);

}