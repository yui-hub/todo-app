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

    public Todo getTodoById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void updateTodo(Integer id, String name, String text, LocalDate deadline, boolean done) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setName(name);
            todo.setText(text);
            todo.setDeadline(deadline);
            todo.setDone(done);
            repository.save(todo);
        }
    }

    public void deleteTodo(Integer id) {
        repository.deleteById(id);
}

}

