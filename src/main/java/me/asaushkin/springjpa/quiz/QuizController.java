package me.asaushkin.springjpa.quiz;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizService quizService;

    @RequestMapping("/quiz")
    public Iterable<Quiz> getQuizes() {
        return quizRepository.findAll();
    }

    @RequestMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public Quiz saveQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.PUT)
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @RequestMapping(value = "/quiz/{id}", method = RequestMethod.DELETE)
    public void deleteQuiz(@PathVariable Long id) {
        quizRepository.deleteById(id);
    }

    @RequestMapping("/quiz/{quizId}/question")
    @JsonView(View.QuestionSummary.class)
    public Iterable<Question> getQuestions(@PathVariable Long quizId) {
        return questionRepository.findQuestionsByQuizId(quizId);
    }

    @RequestMapping("/quiz/{quizId}/question/{questionId}")
    public Question getQuestion(@PathVariable Long quizId, @PathVariable Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @RequestMapping(value = "/quiz/{quizId}/question", method = RequestMethod.POST)
    public Question saveQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        return quizService.saveQuestion(quizId, question);
    }

    @RequestMapping(value = "/quiz/{quizId}/question", method = RequestMethod.PUT)
    public Question updateQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        return quizService.saveQuestion(quizId, question);
    }

    @RequestMapping(value = "/quiz/{quizId}/question/{questionId}", method = RequestMethod.DELETE)
    public void updateQuestion(@PathVariable Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
