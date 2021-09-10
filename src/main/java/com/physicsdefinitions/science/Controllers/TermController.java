
package com.physicsdefinitions.science.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.physicsdefinitions.science.Models.Term;
import com.physicsdefinitions.science.Services.TermService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TermController {

    @Autowired
    private TermService termService;

    public TermController(TermService termService) {
        this.termService = termService;
    }

    // TO GET TERMS FOR A PARTICULAR SUBJECT AND CURRICULUM
    @GetMapping("curriculum/{curriculumId}/subject/{subjectId}/terms")
    @ResponseBody
    public ResponseEntity<List<Term>> getCurriculumTerms(@PathVariable("subjectId") int subId,
            @PathVariable("curriculumId") int curId) {
        return ResponseEntity.ok().body(termService.getAllTerms(subId, curId));
    }

    // TO GET TERMS FOR A PARTICULAR CURRICULUM, AND TOPIC
    @GetMapping("curriculum/{curriculumId}/topic/{topicId}/terms")
    @ResponseBody
    public ResponseEntity<List<Term>> getTopicTerms(@PathVariable("curriculumId") int curId,
            @PathVariable("topicId") int topId) {
        return ResponseEntity.ok().body(termService.getTopicTerms(curId, topId));
    }

    // TO GET A PARTICULAR TERM
    @GetMapping("/term/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Term>> getTerm(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(termService.getTerm(id));
    }

    // SEARCH FOR A PARTICULAR TERM
    @GetMapping("curriculum/{curriculumId}/term/{termName}")
    @ResponseBody
    public ResponseEntity<List<Term>> searchTerm(@PathVariable("curriculumId") int curId,
            @PathVariable("termName") String tName) {
        return ResponseEntity.ok().body(termService.searchTerm(curId, tName));
    }

    @PostMapping("/term/save")
    @ResponseBody
    public ResponseEntity<Object> saveTerm(@Valid @RequestBody Term term) {

        try {
            termService.saveTerm(term);
            return ResponseEntity.status(HttpStatus.OK).body("Term successfully added.\n");
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            Map<String, String> errorInfo = new HashMap<>();
            Map<String, Map<String, String>> errorBody = new HashMap<>();
            errorInfo.put("term", "Term already exists.");
            errorBody.put("errors", errorInfo);

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorBody);
        }

    }

}
