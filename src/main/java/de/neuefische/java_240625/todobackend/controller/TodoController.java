package de.neuefische.java_240625.todobackend.controller;

import de.neuefische.java_240625.todobackend.model.Todo;
import de.neuefische.java_240625.todobackend.model.TodoDto;
import de.neuefische.java_240625.todobackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) { this.service = service; }

    @GetMapping
    public List<Todo> getAllTodos() {return service.getAllTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
        return ResponseEntity.of(Optional.ofNullable(service.getTodoById(id)));}

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(service.addTodo(todoDto));}

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody TodoDto updateDto) {
        return ResponseEntity.ok(service.updateTodo(id, updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
