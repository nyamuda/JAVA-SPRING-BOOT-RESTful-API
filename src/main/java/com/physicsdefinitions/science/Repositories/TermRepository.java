package com.physicsdefinitions.science.Repositories;

import java.util.List;

import com.physicsdefinitions.science.Models.Term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<Term, Integer> {

    @Query("SELECT t FROM Term t")
    public List<Term> getTerms();

    @Query("SELECT t FROM Term t WHERE t.physicsTopic.id=?1")
    public List<Term> getTermsForTopic(int id);

}
