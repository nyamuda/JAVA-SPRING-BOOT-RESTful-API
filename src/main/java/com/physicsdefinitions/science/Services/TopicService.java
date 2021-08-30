package com.physicsdefinitions.science.Services;

import com.physicsdefinitions.science.Repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Topic;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repo;

    public TopicService(TopicRepository repo) {
        this.repo = repo;
    }

    public List<Topic> getTopics() {
        return repo.findAll();
    }

    public Optional<Topic> getTopic(int id) {
        return repo.getTopic(id);
    }

}
