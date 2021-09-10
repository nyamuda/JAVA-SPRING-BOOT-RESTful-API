package com.physicsdefinitions.science.Controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.physicsdefinitions.science.Models.Subject;
import com.physicsdefinitions.science.Services.SubjectService;

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

@RestController
public class SubjectController {
    private SubjectService subService;

    public SubjectController(SubjectService subService) {
        this.subService = subService;
    }

    // get a subject
    @GetMapping("subject/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Subject>> getSubject(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(subService.getSubject(id));
    }

    // get all subjects for a particular curriculum
    @GetMapping("curriculum/{curriculumId}/subjects")
    @ResponseBody
    public ResponseEntity<List<Subject>> getSubjects(@PathVariable("curriculumId") int id) {
        return ResponseEntity.ok().body(subService.getAllSubjects(id));
    }

    // save subject
    @PostMapping("/subject/save")
    @ResponseBody
    public ResponseEntity<Object> saveSubject(@Valid @RequestBody Subject subject) {

        try {
            subService.saveSubject(subject);
            return ResponseEntity.status(HttpStatus.OK).body("Subject successfully added.\n");
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            Map<String, String> errorInfo = new HashMap<>();
            Map<String, Map<String, String>> errorBody = new HashMap<>();
            errorInfo.put("subject", "Subject already exists.");
            errorBody.put("errors", errorInfo);

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorBody);
        }

    }
}
