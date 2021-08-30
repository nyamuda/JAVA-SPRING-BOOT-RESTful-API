/*
 * package com.physicsdefinitions.science.Repositories;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import com.physicsdefinitions.science.Models.Term;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; //import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository public interface TermRepository extends JpaRepository<Term,
 * Integer> {
 * 
 * @Query("SELECT t FROM Term t WHERE t.topic.id=?1") public List<Term>
 * getTermsForTopic(int id);
 * 
 * // @Query("SELECT t FROM Term t WHERE t.id=?1") public Optional<Term>
 * getTerm(int id);
 * 
 * }
 */