package me.asaushkin.springjpa;

import me.asaushkin.springjpa.quiz.QuestionRepository;
import me.asaushkin.springjpa.quiz.Quiz;
import me.asaushkin.springjpa.quiz.QuizRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    TransactionTemplate txTemplate;

    @Test
    public void testQuiz() {
        Assert.assertNotNull(quizRepository);

        Quiz quiz = quizRepository.save(new Quiz("Simple Quiz",
                "Description Simple Quiz"));

        Assert.assertNotNull(quiz);

        quiz.setName("Updated name");
        quiz.setDescription("Updated description");

        Quiz otherQuiz = quizRepository.save(quiz);

        Assert.assertEquals(quiz, otherQuiz);

        quizRepository.deleteById(quiz.getId());

        Assert.assertNull(quizRepository.findById(quiz.getId()).orElse(null));
    }
}
