package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(String name, String text, LocalDate deadline, boolean done) {
        Todo todo = new Todo(name, text, deadline, done);
        repository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }
}
