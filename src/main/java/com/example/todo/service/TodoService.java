package com.example.todo.service;

import org.springframework.stereotype.Service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository){
        this.repository = repository;
    }

    public List<Todo> getAllTodos(){
        return repository.findAll();
    }

    public void addTodo(String name, String text){
        repository.save(new Todo(name,text));
    }
}
