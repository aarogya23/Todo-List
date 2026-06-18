package com.todo.college.controller;

import com.todo.college.model.TodoItems;
import com.todo.college.service.TodoItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/todo")

public class TodoController {

    @Autowired
    private TodoItemsService todoService;


    // ================= CREATE =================

    @PostMapping("/add")

    public String createTodo( @RequestHeader("token") String token, @RequestBody TodoItems todo){

        return todoService.createTodo(
                token,
                todo
        );
    }



    // ================= GET =================

    @GetMapping("/showall")

    public List<TodoItems> getTodos( @RequestHeader("token") String token){

        return todoService.getTodos(
                token
        );
    }





}
