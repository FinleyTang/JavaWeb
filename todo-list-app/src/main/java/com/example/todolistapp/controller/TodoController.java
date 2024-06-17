package com.example.todolistapp.controller;

import com.example.todolistapp.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    private List<Todo> todos = new ArrayList<>();

    @GetMapping("/")
    public String getTodos(Model model) {
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/addTodo")
    public String addTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodoSubmit(@ModelAttribute Todo todo) {
        todos.add(todo);
        return "redirect:/";
    }

    @PostMapping("/deleteTodo")
    public String deleteTodoSubmit(@ModelAttribute Todo todo) {
        todos.removeIf(t -> t.getDescription().equals(todo.getDescription()));
        return "redirect:/";
    }

    @GetMapping("/editTodo")
    public String editTodoForm(@RequestParam String description, Model model) {
        Todo todo = todos.stream()
                .filter(t -> t.getDescription().equals(description))
                .findFirst()
                .orElse(null);
        if (todo != null) {
            model.addAttribute("todo", todo);
            return "editTodo";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/editTodo")
    public String editTodoSubmit(@ModelAttribute Todo todo) {
        todos.replaceAll(t -> t.getDescription().equals(todo.getDescription()) ? todo : t);
        return "redirect:/";
    }

}
