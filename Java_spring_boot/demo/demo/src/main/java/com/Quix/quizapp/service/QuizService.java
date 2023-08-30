package com.Quix.quizapp.service;

import com.Quix.quizapp.dao.QuestionDao;
import com.Quix.quizapp.dao.QuizDao;
import com.Quix.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionDao.findRandomQuestionsByCategory(category, numQ));
        quizDao.save(quiz);
        String response = quiz.getTitle()+" created successfully";
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
