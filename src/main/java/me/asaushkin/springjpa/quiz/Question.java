package me.asaushkin.springjpa.quiz;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.QuestionSummary.class)
    private Long id;

    @JsonView(View.QuestionSummary.class)
    @NotNull
    @Size(min = 3)
    private String name;

    @JsonView(View.QuestionSummary.class)
    @NotNull
    private Boolean answer;

    @ManyToOne
    @NotNull
    private Quiz quiz;

    public Question() {
    }

    public Question(String name, Boolean answer, Quiz quiz) {
        this.name = name;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
