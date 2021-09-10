package com.physicsdefinitions.science.Controllers;

import com.physicsdefinitions.science.Models.Topic;
import com.physicsdefinitions.science.Services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

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
    public ResponseEntity<List<Topic>> getTopics(@PathVariable("subjectId") int subId,
            @PathVariable("curriculumId") int curId) {

        return ResponseEntity.ok().body(topics.getTopics(subId, curId));

    }

    /* GET A PARTICULAR TOPIC */

    @GetMapping("topic/{topicId}")
    @ResponseBody
    public ResponseEntity<Optional<Topic>> getTopic(@PathVariable("topicId") int topId) {
        return ResponseEntity.ok().body(topics.getTopic(topId));
    }

    // SAVE A TOPIC
    @PostMapping("/topic/save")
    @ResponseBody
    public ResponseEntity<Object> saveTopic(@Valid @RequestBody Topic topic) {

        try {
            topics.saveTopic(topic);
            return ResponseEntity.status(HttpStatus.OK).body("Topic successfully added.\n");
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            Map<String, String> errorInfo = new HashMap<>();
            Map<String, Map<String, String>> errorBody = new HashMap<>();
            errorInfo.put("topic", "Topic already exists.");
            errorBody.put("errors", errorInfo);

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorBody);
        }

    }

}
