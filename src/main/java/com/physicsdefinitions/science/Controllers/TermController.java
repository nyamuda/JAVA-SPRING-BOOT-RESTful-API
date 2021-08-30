
package com.physicsdefinitions.science.Controllers;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Term;
import com.physicsdefinitions.science.Services.TermService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TermController {

    @Autowired
    private TermService termService;

    TermController(TermService termService) {
        this.termService = termService;
    }

    // TO GET TERMS FOR A PARTICULAR SUBJECT AND CURRICULUM
    @GetMapping("subject/{subjectId}/curriculum/{curriculumId}/terms")
    @ResponseBody
    public List<Term> getCurriculumTerms(@PathVariable("subjectId") int subId,
            @PathVariable("curriculumId") int curId) {
        return termService.getAllTerms(subId, curId);
    }

    // TO GET TERMS FOR A PARTICULAR CURRICULUM, AND TOPIC
    @GetMapping("curriculum/{curriculumId}/topic/{topicId}/terms")
    @ResponseBody
    public List<Term> getTopicTerms(@PathVariable("curriculumId") int curId, @PathVariable("topicId") int topId) {
        return termService.getTopicTerms(curId, topId);
    }

    // TO GET A PARTICULAR TERM
    @GetMapping("/term/{id}")
    @ResponseBody
    public Optional<Term> getTerm(@PathVariable("id") int id) {
        return termService.getTerm(id);
    }

}
