package com.todoapp.controller;

import com.todoapp.dto.TodoPostDto;
import com.todoapp.entity.Todo;
import com.todoapp.mapper.TodoMapper;
import com.todoapp.repository.TodoRepository;
import com.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/")
@Validated
public class TodoController {
    private TodoMapper mapper;
    private TodoService todoService;

    public TodoController(TodoMapper mapper, TodoService todoService) {
        this.mapper = mapper;
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity postTodo(@RequestBody TodoPostDto todoPostDto) {
        Todo todo = todoService.creatTodo(mapper.todoPostDtoToTodo(todoPostDto));

        return new ResponseEntity(todo, HttpStatus.OK);
    }
//
//    @GetMapping
//    public ResponseEntity getTodos() {
//
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity getTodo(@PathVariable("id") @Positive long id) {
//
//    }
//
//    @PatchMapping("{id}")
//    public ResponseEntity patchTodo(@PathVariable("id") @Positive long id) {
//
//    }
//
//    @DeleteMapping
//    public ResponseEntity deleteTodos() {
//
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity deleteTodo(@PathVariable("id") @Positive long id) {
//
//    }

}
