package de.neuefische.java_240625.todobackend.repository;


import de.neuefische.java_240625.todobackend.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
}
