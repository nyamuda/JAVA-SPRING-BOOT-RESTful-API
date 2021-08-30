
package com.physicsdefinitions.science.Repositories;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<Term, Integer> {

    // GET TERMS FOR PARTICULAR SUBJECT AND CURRICULUM
    @Query(value = "SELECT * FROM terms JOIN topics on terms.topic_id=topics.id JOIN topic_curriculum tc ON tc.topic_id==topics.id WHERE topics.subject_id=?1 AND tc.curriculum_id=?2", nativeQuery = true)
    public List<Term> getAllTerms(int subjectId, int curriculumId);

    // GET TERMS FOR A PARTICULAR CURRICULUM AND TOPIC
    @Query(value = "SELECT * FROM terms JOIN topics on terms.topic_id=topics.id JOIN topic_curriculum tc ON tc.topic_id=topics.id WHERE tc.curriculum_id=?1 AND topics.id=?2", nativeQuery = true)
    public List<Term> getTermsForTopic(int curriculumId, int topicId);

    // GET A PARTICULAR TERM
    @Query("SELECT t FROM Term t WHERE t.id=?1")
    public Optional<Term> getTerm(int id);

}
