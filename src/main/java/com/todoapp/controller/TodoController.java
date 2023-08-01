package com.todoapp.controller;

import com.todoapp.dto.TodoPatchDto;
import com.todoapp.dto.TodoPostDto;
import com.todoapp.entity.Todo;
import com.todoapp.mapper.TodoMapper;
import com.todoapp.repository.TodoRepository;
import com.todoapp.service.TodoService;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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

        return new ResponseEntity(todo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todo> response = todoService.readTodos();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getTodo(@PathVariable("id") @Positive long id) {
        Todo response = todoService.readTodo(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity patchTodo(@PathVariable("id") @Positive long id,
                                    @RequestBody TodoPatchDto todoPatchDto) {
        todoPatchDto.setId(id);
        Todo response = todoService.updateTodo(mapper.todoPatchDtoToTodo(todoPatchDto));

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTodos() {

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") @Positive long id) {

    }

}
