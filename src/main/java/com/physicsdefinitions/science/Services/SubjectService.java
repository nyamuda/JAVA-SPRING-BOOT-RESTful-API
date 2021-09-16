package com.physicsdefinitions.science.Services;

import java.util.List;

import com.physicsdefinitions.science.ErrorHandling.ApiException;
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
    public Subject getSubject(int id) {
        return subRepo.findById(id).orElseThrow(() -> new ApiException("Subject not found."));
    }

    // get all subjects for a particular curriculum
    public List<Subject> getAllSubjects(int id) {
        return subRepo.getAllSubjects(id);
    }

    // save a subject
    public void saveSubject(Subject subject) {
        try {
            // checking if the subject already exists
            Subject checkSubject = subRepo.findByName(subject.getName());
            if (checkSubject != null && subject.getName().equalsIgnoreCase(checkSubject.getName())) {
                throw new ApiException("Subject already exists.");
            } else {
                subRepo.save(subject);
            }
        } catch (Exception e) {
            throw new ApiException(e.getLocalizedMessage());
        }
    }
}
