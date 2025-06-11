package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todos = service.getAllTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       @RequestParam String deadline,
                       Model model) {
        if (name.isBlank() || text.isBlank() || deadline.isBlank()) {
            model.addAttribute("error", "名前・やること・期限は必須です");
        } else {
            LocalDate parsedDeadline = LocalDate.parse(deadline);
            service.addTodo(name, text, parsedDeadline, false);
        }

        model.addAttribute("todos", service.getAllTodos());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Todo todo = service.getTodoById(id);
        model.addAttribute("todo", todo);
        model.addAttribute("todos", service.getAllTodos());
        return "index";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
                         @RequestParam String name,
                         @RequestParam String text,
                         @RequestParam String deadline,
                         @RequestParam(defaultValue = "false") boolean done,
                         Model model) {
        LocalDate parsedDeadline = LocalDate.parse(deadline);
        service.updateTodo(id, name, text, parsedDeadline, done);
        model.addAttribute("todos", service.getAllTodos());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
      service.deleteTodo(id);
      return "redirect:/";  // 削除後、トップページへリダイレクト
}

}

