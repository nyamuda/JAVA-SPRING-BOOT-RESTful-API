package com.physicsdefinitions.science.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.Models.Definition;
import com.physicsdefinitions.science.Repositories.DefinitionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DefinitionService {
    @Autowired
    private DefinitionRepository defRepo;

    public DefinitionService(DefinitionRepository defRepo) {
        this.defRepo = defRepo;
    }

    // getting the definition of a term of a particular curriculum
    public Optional<Definition> getDefinition(int curriculumId, int termId) {
        return defRepo.getDefinition(curriculumId, termId);
    }

    public void saveDefinition(Definition definition) {
        defRepo.save(definition);
    }
}
