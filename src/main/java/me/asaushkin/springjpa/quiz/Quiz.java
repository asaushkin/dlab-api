package me.asaushkin.springjpa.quiz;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz", schema = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 64)
    private String name;

    private String description;

    @OneToMany
    @JoinColumn(name = "quiz_id")
    private List<Question> questions = new ArrayList<>();

    public Quiz() {
    }

    public Quiz(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addQuestion(Question question) {
        questions.add(question);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        if (!id.equals(quiz.id)) return false;
        if (!name.equals(quiz.name)) return false;
        return description != null ? description.equals(quiz.description) : quiz.description == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
