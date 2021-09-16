package com.physicsdefinitions.science.Services;

import com.physicsdefinitions.science.Repositories.CurriculumRepository;
import com.physicsdefinitions.science.Repositories.SubjectRepository;
import com.physicsdefinitions.science.Repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// import java.util.Optional;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
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

    public Topic getTopic(int topicId) {
        return repo.findById(topicId).orElseThrow(() -> new ApiException("Topic not found."));
    }

    public void saveTopic(Topic topic) {
        try {
            // checking if the topic already exists
            Topic checkTopic = repo.findByName(topic.getName());
            if (checkTopic != null && topic.getName().equalsIgnoreCase(checkTopic.getName())) {
                throw new ApiException("Topic already exists.");
            } else {
                // checking iff the foreign key object and the property subject id was provided
                if (topic.getSubject() == null || topic.getSubject().getId() == 0) {
                    throw new ApiException("Subject field is required.");
                }
                // getting the subject with the given id
                Subject subject = subRepo.getById(topic.getSubject().getId());
                // saving the subject to the topic
                topic.setSubject(subject);

                // saving the topic
                repo.save(topic);
            }
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }

    public void addCurriculumToTopic(String topicName, int currId) {
        try {
            Topic topic = repo.findByName(topicName);
            Curriculum curriculum = currRepo.getCurriculum(currId);
            topic.getCurriculums().add(curriculum);
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }

    }

}
