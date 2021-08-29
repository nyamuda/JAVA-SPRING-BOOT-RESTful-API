package com.physicsdefinitions.science.Controllers;

import java.util.List;

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
    private TermService term;

    TermController(TermService term) {
        this.term = term;
    }

    @GetMapping("/terms")
    @ResponseBody
    public List<Term> getTerms() {
        return term.getTerms();
    }

    @GetMapping("/terms/{id}")
    @ResponseBody
    public List<Term> getTopicTerms(@PathVariable("id") int id) {
        return term.getTermsForTopic(id);
    }

}
