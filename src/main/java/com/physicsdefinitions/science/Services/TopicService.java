package com.physicsdefinitions.science.Services;

import com.physicsdefinitions.science.Repositories.CurriculumRepository;
import com.physicsdefinitions.science.Repositories.SubjectRepository;
import com.physicsdefinitions.science.Repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Models.Subject;
import com.physicsdefinitions.science.Models.Topic;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repo;
    @Autowired
    private CurriculumRepository currRepo;
    @Autowired
    private SubjectRepository subRepo;

    public TopicService(TopicRepository repo, CurriculumRepository currRepo, SubjectRepository subRepo) {
        this.repo = repo;
        this.currRepo = currRepo;
        this.subRepo = subRepo;
    }

    public List<Topic> getTopics(int subjectId, int curriculumId) {
        return repo.getSubjectTopics(subjectId, curriculumId);
    }

    public Optional<Topic> getTopic(int topicId) {
        return repo.getTopic(topicId);
    }

    public void saveTopic(Topic topic) {
        // getting the subject with the given id
        Subject subject = subRepo.getById(topic.getSubject().getId());
        // saving the subject to the topic
        topic.setSubject(subject);

        // saving the topic
        repo.save(topic);
    }

    public void addCurriculumToTopic(String topicName, int currId) {
        Topic topic = repo.findByName(topicName);
        Curriculum curriculum = currRepo.getCurriculum(currId);
        topic.getCurriculums().add(curriculum);

    }

}
