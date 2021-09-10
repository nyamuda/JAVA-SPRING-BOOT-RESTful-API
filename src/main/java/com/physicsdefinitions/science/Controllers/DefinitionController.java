package com.physicsdefinitions.science.Controllers;

import java.util.Optional;

import com.physicsdefinitions.science.Models.Definition;
import com.physicsdefinitions.science.Services.DefinitionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefinitionController {
    @Autowired
    private DefinitionService defService;

    public DefinitionController(DefinitionService defService) {
        this.defService = defService;
    }

    // getting the definition of a term of a particular curriculum
    @GetMapping("curriculum/{curriculumId}/term/{termId}/definition")
    @ResponseBody
    public Optional<Definition> getDefinition(@PathVariable("curriculumId") int curId,
            @PathVariable("termId") int termId) {
        return defService.getDefinition(curId, termId);
    }

    // save definition
    @PostMapping("definition/save")
    @ResponseBody
    public ResponseEntity<Object> getDefinition(Definition definition) {
        defService.saveDefinition(definition);
        return ResponseEntity.ok().body("Definition successfully added.");
    }
}
