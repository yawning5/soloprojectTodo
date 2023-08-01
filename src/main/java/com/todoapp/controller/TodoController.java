package com.todoapp.controller;

import com.todoapp.entity.Todo;
import com.todoapp.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/")
public class TodoController {
    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public ResponseEntity postTodo() {
        Todo todo = new Todo();
        todo.setTodoOrder(1);
        todo.setTitle("테스트");
        todoRepository.save(todo);
        return new ResponseEntity(todo, HttpStatus.OK);
    }

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
