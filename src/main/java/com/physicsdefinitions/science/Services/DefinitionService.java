package com.physicsdefinitions.science.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Models.Definition;
import com.physicsdefinitions.science.Models.Term;
import com.physicsdefinitions.science.Repositories.CurriculumRepository;
import com.physicsdefinitions.science.Repositories.DefinitionRepository;
import com.physicsdefinitions.science.Repositories.TermRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DefinitionService {
    @Autowired
    private DefinitionRepository defRepo;
    @Autowired
    private CurriculumRepository currRepo;
    @Autowired
    private TermRepository termRepository;

    public DefinitionService(DefinitionRepository defRepo, CurriculumRepository currRepo,
            TermRepository termRepository) {
        this.defRepo = defRepo;
        this.currRepo = currRepo;
        this.termRepository = termRepository;
    }

    // getting the definition of a term of a particular curriculum
    public Optional<Definition> getDefinition(int curriculumId, int termId) {
        return defRepo.getDefinition(curriculumId, termId);
    }

    // save definition
    public void saveDefinition(Definition definition) {
        try {
            // getting the term with the given id
            Term term = termRepository.getById(definition.getTerm().getId());
            // getting the curriculum with the given id
            Curriculum curriculum = currRepo.getById(definition.getCurriculum().getId());

            // saving the term and curriculum to the definition
            definition.setTerm(term);
            definition.setCurriculum(curriculum);
            // saving the definition to the database
            defRepo.save(definition);
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }
}
