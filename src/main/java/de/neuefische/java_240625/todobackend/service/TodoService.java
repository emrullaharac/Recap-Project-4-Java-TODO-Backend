package de.neuefische.java_240625.todobackend.service;

import de.neuefische.java_240625.todobackend.model.Todo;
import de.neuefische.java_240625.todobackend.model.TodoDto;
import de.neuefische.java_240625.todobackend.model.TodoStatus;
import de.neuefische.java_240625.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repo;
    private final IdService idService;

    @Autowired
    public TodoService(TodoRepository repository,  IdService idService) {
        this.repo = repository;
        this.idService = idService;
    }

    public List<Todo> getAllTodos() {return repo.findAll();}

    public Todo getTodoById(String id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));}

    public Todo addTodo(TodoDto todoDto) {
        String id = idService.randomId();
        Todo newTodo = new Todo(id, todoDto.description(), todoDto.status());
        return repo.save(newTodo);
    }

    public Todo updateTodo(String id, TodoDto updateDto) {
        return repo.findById(id)
                .map(oldTodo -> {
                    String newDescription = updateDto.description() != null
                            ? updateDto.description()
                            : oldTodo.description();

                    TodoStatus newStatus = updateDto.status() != null
                            ? updateDto.status()
                            : oldTodo.status();

                    Todo updated = oldTodo
                            .withDescription(newDescription)
                            .withStatus(newStatus);
                    return repo.save(updated);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));
    }

    public void deleteTodo(String id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id);
        }
        repo.deleteById(id);
    }

}
