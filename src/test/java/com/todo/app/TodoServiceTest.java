package com.todo.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;
    @Mock
    private TodoAppRepository todoAppRepository;
    private TodoList todoList;

    @BeforeEach
    public void setup() {
        todoList = new TodoList();
        todoList.setId(100);
        todoList.setTodoName("First Item");
        todoList.setComplete(false);
        todoList.setCreateDate(LocalDate.now());
    }
    @Test
    public void createTodoItem() {
        when(todoAppRepository.save(any(TodoList.class))).thenReturn(todoList);

        TodoList todoList1 = todoService.create(todoList);
        assertEquals(todoList, todoList1);
    }
}