package com.physicsdefinitions.science.Controllers;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Services.CurriculumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurriculumController {
    @Autowired
    private CurriculumService currService;

    public CurriculumController(CurriculumService currService) {
        this.currService = currService;
    }

    // GET ALL CURRICULUMS
    @GetMapping("/curriculums")
    @ResponseBody
    public ResponseEntity<List<Curriculum>> getCurriculums() {
        return ResponseEntity.ok().body(currService.getAllCurriculums());
    }

    // GET A PARTICULAR CURRICULUM
    @GetMapping("curriculum/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Curriculum>> getCurriculum(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(currService.getCurriculum(id));
    }

}
