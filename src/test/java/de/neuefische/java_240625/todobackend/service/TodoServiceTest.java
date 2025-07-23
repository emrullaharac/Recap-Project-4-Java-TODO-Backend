package de.neuefische.java_240625.todobackend.service;

import de.neuefische.java_240625.todobackend.model.Todo;
import de.neuefische.java_240625.todobackend.model.TodoDto;
import de.neuefische.java_240625.todobackend.model.TodoStatus;
import de.neuefische.java_240625.todobackend.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TodoServiceTest {


    @Test
    void getAllTodos_ShouldReturnEmptyList_WhenCalledInitially() {
        //GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());
        List<Todo> expected = Collections.emptyList();
        //WHEN
        List<Todo> actual = service.getAllTodos();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getAllTodos_ShouldReturnListOfOneToDo_WhenCalledWithOneTodoInDB() {
        //GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);
        Todo newTodo = new Todo("1", "Test", TodoStatus.OPEN);
        when(mockRepo.findAll()).thenReturn(List.of(newTodo));
        List<Todo> expected = List.of(newTodo);
        //WHEN
        List<Todo> actual = service.getAllTodos();
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void addTodo_ShouldReturnTodo_WhenCalledWithDTO() {
        //GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        TodoDto todoDto = new TodoDto("Test",  TodoStatus.OPEN);
        Todo expected = new Todo("1", "Test", TodoStatus.OPEN);
        when(service.addTodo(todoDto)).thenReturn(expected);

        //WHEN
        Todo actual = service.addTodo(todoDto);
        //THEN
        assertEquals(expected, actual);
        verify(mockRepo).save(any(Todo.class));
    }

    @Test
    void getTodoById_ShouldReturnSearchedTodo_WhenGivenValidId() {
        //GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        Todo expected = new Todo("1", "Test", TodoStatus.OPEN);
        when(mockRepo.findById("1")).thenReturn(Optional.of(expected));

        //WHEN
        Todo actual = service.getTodoById(expected.id());
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void getTodoById_ShouldThrowException_WhenGivenInvalidId() {
        //GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        when(mockRepo.findById("1")).thenReturn(Optional.empty());

        //WHEN

        //THEN
        assertThrows(ResponseStatusException.class, () -> service.getTodoById("1"));
    }

    @Test
    void updateTodo_ShouldReturnUpdatedTodo_WhenGivenValidIdAndDto() {
        // GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        String id = "1";
        Todo oldTodo = new Todo(id, "Old Description", TodoStatus.OPEN);
        TodoDto updateDto = new TodoDto("Updated Description", TodoStatus.IN_PROGRESS);
        Todo updatedTodo = new Todo(id, "Updated Description", TodoStatus.IN_PROGRESS);

        when(mockRepo.findById(id)).thenReturn(Optional.of(oldTodo));
        when(mockRepo.save(any(Todo.class))).thenReturn(updatedTodo);

        // WHEN
        Todo actual = service.updateTodo(id, updateDto);

        // THEN
        assertEquals(updatedTodo, actual);
        verify(mockRepo).findById(id);
        verify(mockRepo).save(any(Todo.class));
    }

    @Test
    void updateTodo_ShouldThrowException_WhenGivenInvalidId() {
        // GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        String id = "1";
        TodoDto updateDto = new TodoDto("Updated Description", TodoStatus.IN_PROGRESS);

        when(mockRepo.findById(id)).thenReturn(Optional.empty());

        // WHEN & THEN
        assertThrows(ResponseStatusException.class, () -> service.updateTodo(id, updateDto));
        verify(mockRepo).findById(id);
        verify(mockRepo, never()).save(any(Todo.class));
    }

    @Test
    void deleteTodo_ShouldDelete_WhenGivenValidId() {
        // GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        String id = "1";
        when(mockRepo.existsById(id)).thenReturn(true);

        // WHEN
        service.deleteTodo(id);

        // THEN
        verify(mockRepo).existsById(id);
        verify(mockRepo).deleteById(id);
    }

    @Test
    void deleteTodo_ShouldThrowException_WhenGivenInvalidId() {
        // GIVEN
        TodoRepository mockRepo = mock(TodoRepository.class);
        IdService idService = mock(IdService.class);
        TodoService service = new TodoService(mockRepo, idService);

        String id = "1";
        when(mockRepo.existsById(id)).thenReturn(false);

        // WHEN & THEN
        assertThrows(ResponseStatusException.class, () -> service.deleteTodo(id));
        verify(mockRepo).existsById(id);
        verify(mockRepo, never()).deleteById(id);
    }
}