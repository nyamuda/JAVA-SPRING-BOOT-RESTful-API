package com.physicsdefinitions.science.Repositories;

import java.util.Optional;

import com.physicsdefinitions.science.Models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * PhysicsTopicsRepository
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Query("SELECT p FROM Topic p WHERE p.id=?1")
    public Optional<Topic> getTopic(int id);

}