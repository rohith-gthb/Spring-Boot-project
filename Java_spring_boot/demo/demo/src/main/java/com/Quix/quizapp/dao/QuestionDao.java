package com.Quix.quizapp.dao;

import com.Quix.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query("select * from question q where q.category=:category order by RANDOM() LIMIT :numQ")
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
