package com.example.todo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String text;
    private LocalDate deadline;
    private Boolean done;

    public Todo() {
    }

    public Todo(String name, String text, LocalDate deadline, Boolean done) {
        this.name = name;
        this.text = text;
        this.deadline = deadline;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Boolean getDone() {
        return done;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
