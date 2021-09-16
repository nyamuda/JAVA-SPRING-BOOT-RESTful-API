
package com.physicsdefinitions.science.Repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.physicsdefinitions.science.Models.Term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TermRepository extends JpaRepository<Term, Integer> {

    // GET TERMS FOR PARTICULAR SUBJECT AND CURRICULUM
    @Query(value = "SELECT * FROM terms JOIN topics on terms.topic_id=topics.id JOIN topic_curriculum tc ON tc.topic_id=topics.id WHERE topics.subject_id=?1 AND tc.curriculum_id=?2", nativeQuery = true)
    public List<Term> getAllTerms(int subjectId, int curriculumId);

    // GET TERMS FOR A PARTICULAR CURRICULUM AND TOPIC
    @Query(value = "SELECT * FROM terms JOIN topics on terms.topic_id=topics.id JOIN topic_curriculum tc ON tc.topic_id=topics.id WHERE tc.curriculum_id=?1 AND topics.id=?2", nativeQuery = true)
    public List<Term> getTermsForTopic(int curriculumId, int topicId);

    // GET A PARTICULAR TERM
    @Query(value = "SELECT * FROM terms t JOIN term_curriculum tc ON t.id=tc.term_id WHERE tc.curriculum_id=?1 AND t.term_name LIKE CONCAT(?2,'%')", nativeQuery = true)
    public List<Term> searchTerm(int curriculumId, String termName);

    // FIND TERM BY NAME
    public Term findByName(String name);

    public Optional<Term> findById(int id);

}
