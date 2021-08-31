package com.physicsdefinitions.science.Repositories;

import java.util.Optional;

import com.physicsdefinitions.science.Models.Curriculum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
    @Query(value = "SELECT * FROM curriculums c WHERE c.id=?1", nativeQuery = true)
    public Optional<Curriculum> getCurriculum(int id);

}
