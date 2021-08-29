package com.physicsdefinitions.science.Services;

import com.physicsdefinitions.science.Repositories.PhysicsTopicsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.physicsdefinitions.science.Models.PhysicsTopic;

@Service
public class PhysicsTopicsService {

    @Autowired
    private PhysicsTopicsRepository repository;

    public PhysicsTopicsService(PhysicsTopicsRepository repository) {
        this.repository = repository;
    }

    public List<PhysicsTopic> getTopics() {
        return repository.findAll();
    }

    public PhysicsTopic getTopic(int id) {
        return repository.getById(id);
    }

    public List<PhysicsTopic> getNames() {
        return repository.getNames();
    }

}
