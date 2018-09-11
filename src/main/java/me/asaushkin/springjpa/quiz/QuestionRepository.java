package me.asaushkin.springjpa.quiz;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findQuestionsByQuizId(Long quizId);
}
