package com.physicsdefinitions.science.Repositories;

import java.util.List;
import java.util.Optional;

import com.physicsdefinitions.science.Models.Topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * TopicsRepository
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    @Query(value = "SELECT * FROM topics t JOIN topic_curriculum tc ON t.id=tc.topic_id WHERE tc.curriculum_id=?1 AND t.id=?2", nativeQuery = true)
    public Optional<Topic> getTopic(int curriculumId, int topicId);

    @Query(value = "SELECT * FROM topics t JOIN topic_curriculum tc ON t.id=tc.topic_id WHERE t.subject_id=?1 AND tc.curriculum_id=?2", nativeQuery = true)
    public List<Topic> getSubjectTopics(int subjectId, int curriculumId);

}