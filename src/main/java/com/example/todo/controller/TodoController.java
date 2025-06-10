package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Todo> Todos = service.getAllTodos();
        model.addAttribute("Todos", Todos);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "名前とメッセージは必須です");

        }else{
            service.addTodo((name), text);
        }
        
        List<Todo> Todos = service.getAllTodos();
        model.addAttribute("Todos", Todos);
        return "index";
    }
}