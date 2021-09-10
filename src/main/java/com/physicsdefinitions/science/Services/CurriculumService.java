package com.physicsdefinitions.science.Services;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Curriculum;
import com.physicsdefinitions.science.Repositories.CurriculumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurriculumService {

    @Autowired
    private CurriculumRepository currRepo;

    public CurriculumService(CurriculumRepository currRepo) {
        this.currRepo = currRepo;
    }

    public List<Curriculum> getAllCurriculums() {
        return currRepo.findAll();
    }

    public Optional<Curriculum> getCurriculum(int id) {
        return currRepo.getCurriculum(id);
    }

    public void saveCurriculum(Curriculum curriculum) {
        currRepo.save(curriculum);
    }

}
