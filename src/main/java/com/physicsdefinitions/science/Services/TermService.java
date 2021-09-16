
package com.physicsdefinitions.science.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Models.Term;
import com.physicsdefinitions.science.Models.Topic;
import com.physicsdefinitions.science.Repositories.CurriculumRepository;
import com.physicsdefinitions.science.Repositories.TermRepository;
import com.physicsdefinitions.science.Repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TermService {

    @Autowired
    private TermRepository term;
    @Autowired
    private CurriculumRepository currRepo;
    @Autowired
    private TopicRepository topicRepository;

    public TermService(TermRepository term, CurriculumRepository currRepo, TopicRepository topicRepository) {
        this.term = term;
        this.currRepo = currRepo;
        this.topicRepository = topicRepository;
    }

    public List<Term> getAllTerms(int subjectId, int curriculumId) {
        return term.getAllTerms(subjectId, curriculumId);
    }

    public List<Term> getTopicTerms(int curriculumId, int topicId) {
        return term.getTermsForTopic(curriculumId, topicId);
    }

    public Term getTerm(int id) {
        return term.findById(id).orElseThrow(() -> new ApiException("Term not found."));

    }

    public List<Term> searchTerm(int curriculumId, String termName) {
        return term.searchTerm(curriculumId, termName);
    }

    public void saveTerm(Term newTerm) {

        try {
            // first checking if the term already exists.
            Term termCheck = term.findByName(newTerm.getName());

            if (termCheck != null && newTerm.getName().equalsIgnoreCase(termCheck.getName())) {
                throw new ApiException("Term already exists.");
            } else {
                // if topic id was not provided, wwe throw an error.
                if (newTerm.getTopic() == null || newTerm.getTopic().getId() == 0) {
                    throw new ApiException("Topic field is required.");
                }
                // getting the topic with the given id
                Topic topic = topicRepository.getById(newTerm.getTopic().getId());
                // saving the topic to the term
                newTerm.setTopic(topic);
                // saving the term to the database
                term.save(newTerm);
            }

        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }

    public void addCurriculumToTerm(String termName, int curriculumId) {
        try {
            Term myTerm = term.findByName(termName);
            Curriculum curriculum = currRepo.getById(curriculumId);
            myTerm.getCurriculums().add(curriculum);
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }

}
