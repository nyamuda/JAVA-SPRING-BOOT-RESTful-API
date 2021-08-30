
package com.physicsdefinitions.science.Services;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Term;
import com.physicsdefinitions.science.Repositories.TermRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermService {

    @Autowired
    private TermRepository term;

    public TermService(TermRepository term) {
        this.term = term;
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

}
