package com.physicsdefinitions.science.Repositories;

import java.util.List;

import com.physicsdefinitions.science.Models.PhysicsTopic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PhysicsTopicsRepository
 */
@Repository
public interface PhysicsTopicsRepository extends JpaRepository<PhysicsTopic, Integer> {

    @Query("SELECT p FROM PhysicsTopic p")
    public List<PhysicsTopic> getNames();

}