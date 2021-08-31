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

    /* GET ALL TOPICS FOR A PARTICULAR SUBJECT AND CURRICULUM */

    @GetMapping("subject/{subjectId}/curriculum/{curriculumId}/topics")
    @ResponseBody
    public List<Topic> getTopics(@PathVariable("subjectId") int subId, @PathVariable("curriculumId") int curId) {

        return topics.getTopics(subId, curId);

    }

    @GetMapping("curriculum/{curriculumId}/topic/{topicId}")
    @ResponseBody
    public Optional<Topic> getTopic(@PathVariable("curriculumId") int curId, @PathVariable("topicId") int topId) {
        return topics.getTopic(curId, topId);
    }

}
