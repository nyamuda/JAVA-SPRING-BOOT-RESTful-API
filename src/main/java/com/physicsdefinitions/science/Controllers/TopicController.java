package com.physicsdefinitions.science.Controllers;

import com.physicsdefinitions.science.Models.Topic;
import com.physicsdefinitions.science.Services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topics;

    public TopicController(TopicService topics) {
        this.topics = topics;
    }

    @GetMapping("/topics")
    @ResponseBody
    public List<Topic> getTopics() {

        return topics.getTopics();

    }

    @GetMapping("/topic/{id}")
    @ResponseBody
    public Optional<Topic> getTopic(@PathVariable("id") int id) {
        return topics.getTopic(id);
    }

}
