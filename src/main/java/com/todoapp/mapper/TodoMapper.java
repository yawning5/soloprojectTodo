package com.todoapp.mapper;

import com.todoapp.dto.TodoPatchDto;
import com.todoapp.dto.TodoPostDto;
import com.todoapp.dto.TodoResponseDto;
import com.todoapp.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo todoPostDtoToTodo(TodoPostDto todoPostDto);
    Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto);
    TodoResponseDto todoToTodoResponseDto(Todo todo);
}
