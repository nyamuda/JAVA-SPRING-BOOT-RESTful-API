
package com.physicsdefinitions.science.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

    public Optional<Term> getTerm(int id) {
        return term.getTerm(id);
    }

    public List<Term> searchTerm(int curriculumId, String termName) {
        return term.searchTerm(curriculumId, termName);
    }

    public void saveTerm(Term newTerm) {

        // getting the topic with the given id
        Topic topic = topicRepository.getById(newTerm.getTopic().getId());
        // saving the topic to the term
        newTerm.setTopic(topic);
        // saving the term to the database
        term.save(newTerm);
    }

    public void addCurriculumToTerm(String termName, int curriculumId) {
        Term myTerm = term.findByName(termName);
        Curriculum curriculum = currRepo.getById(curriculumId);
        myTerm.getCurriculums().add(curriculum);
    }

}
