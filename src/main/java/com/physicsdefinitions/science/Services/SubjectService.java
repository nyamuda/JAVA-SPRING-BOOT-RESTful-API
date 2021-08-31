package com.physicsdefinitions.science.Services;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Subject;
import com.physicsdefinitions.science.Repositories.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subRepo;

    public SubjectService(SubjectRepository subRepo) {
        this.subRepo = subRepo;
    }

    // get a subject
    public Optional<Subject> getSubject(int id) {
        return subRepo.getSubject(id);
    }

    // get all subjects for a particular curriculum
    public List<Subject> getAllSubjects(int id) {
        return subRepo.getAllSubjects(id);
    }
}
