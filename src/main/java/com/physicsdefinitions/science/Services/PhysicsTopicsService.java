package com.physicsdefinitions.science.Services;

import com.physicsdefinitions.science.Repositories.PhysicsTopicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.PhysicsTopic;

@Service
public class PhysicsTopicsService {

    @Autowired
    private PhysicsTopicsRepository repo;

    public PhysicsTopicsService(PhysicsTopicsRepository repo) {
        this.repo = repo;
    }

    public List<PhysicsTopic> getTopics() {
        return repo.findAll();
    }

    public Optional<PhysicsTopic> getTopic(int id) {
        return repo.getTopic(id);
    }

}
