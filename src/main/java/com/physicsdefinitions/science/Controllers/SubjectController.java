package com.physicsdefinitions.science.Controllers;

import java.util.Optional;

import com.physicsdefinitions.science.Models.Subject;
import com.physicsdefinitions.science.Services.SubjectService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SubjectController {
    private SubjectService subService;

    public SubjectController(SubjectService subService) {
        this.subService = subService;
    }

    // get a subject
    @GetMapping("subject/{id}")
    @ResponseBody
    public Optional<Subject> getSubject(@PathVariable("id") int id) {
        return subService.getSubject(id);
    }

    // get all subjects for a particular curriculum
    @GetMapping("curriculum/{curriculumId}/subjects")
    @ResponseBody
    public List<Subject> getSubjects(@PathVariable("curriculumId") int id) {
        return subService.getAllSubjects(id);
    }
}
