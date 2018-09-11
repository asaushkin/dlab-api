package me.asaushkin.springjpa.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Transactional
    public Question saveQuestion(Long quizId, Question question) {
        Quiz quiz = quizRepository.findById(quizId).get();

        question.setQuiz(quiz);
        questionRepository.save(question);

        return question;
    }

}
