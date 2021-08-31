package com.physicsdefinitions.science.Repositories;

import java.util.Optional;

import com.physicsdefinitions.science.Models.Definition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinitionRepository extends JpaRepository<Definition, Integer> {
    // getting the definition of a term of a particular curriculum
    @Query(value = "SELECT * FROM definitions D WHERE d.curriculum_id=?1 AND d.term_id=?2", nativeQuery = true)
    public Optional<Definition> getDefinition(int curriculumId, int termId);

}
