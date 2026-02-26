package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoItem> todoList = List.of(
                new TodoItem(1L, "Learn Spring Boot", "OPEN"),
                new TodoItem(2L, "Build ToDo app", "IN_PROGRESS"),
                new TodoItem(3L, "Tune UI", "DONE")
        );
        model.addAttribute("todoList", todoList);
        return "todo/list";
    }

    @GetMapping("/new")
    public String showNewForm() {
        return "todo/new";
    }

    public record TodoItem(Long id, String title, String status) {
    }
}