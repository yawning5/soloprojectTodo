package com.todoapp.service;

import com.todoapp.entity.Todo;
import com.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo creatTodo(Todo todo) {
        return todoRepository.save(todo);
    }

//    public Todo readTodos() {
//
//    }
//
//    public Todo readTodo(long Id) {
//
//
//    }
//
//    public Todo updateTodo(Todo todo) {
//
//    }
//
//    public void deleteTodo(long Id) {
//
//    }
//
//    public void deleteTodos() {
//
//    }

}
