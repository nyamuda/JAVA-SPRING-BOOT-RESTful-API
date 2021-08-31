package com.physicsdefinitions.science.Repositories;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    // get a particular subject
    @Query(value = "SELECT * FROM subjects s WHERE s.id=?1", nativeQuery = true)
    public Optional<Subject> getSubject(int id);

    // get all subjects for a curriculum
    @Query(value = "SELECT DISTINCT s.name, s.id FROM subjects s JOIN topics t on s.id=t.subject_id JOIN topic_curriculum tc ON t.id=tc.topic_id WHERE tc.curriculum_id=?1", nativeQuery = true)
    public List<Subject> getAllSubjects(int id);

}
