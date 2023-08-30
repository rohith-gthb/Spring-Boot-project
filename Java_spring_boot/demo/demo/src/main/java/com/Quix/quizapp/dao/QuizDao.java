package com.Quix.quizapp.dao;

import com.Quix.quizapp.model.Question;
import com.Quix.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
