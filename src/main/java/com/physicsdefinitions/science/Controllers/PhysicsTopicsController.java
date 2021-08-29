package com.physicsdefinitions.science.Controllers;

import com.physicsdefinitions.science.Models.PhysicsTopic;
import com.physicsdefinitions.science.Services.PhysicsTopicsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class PhysicsTopicsController {
    @Autowired
    private PhysicsTopicsService topics;

    public PhysicsTopicsController(PhysicsTopicsService topics) {
        this.topics = topics;
    }

    @GetMapping("/topics")
    @ResponseBody
    public List<PhysicsTopic> getTopics() {

        return topics.getTopics();

    }

    @GetMapping("/topic/{id}")
    @ResponseBody
    public Optional<PhysicsTopic> getTopic(@PathVariable("id") int id) {
        return topics.getTopic(id);
    }

}
