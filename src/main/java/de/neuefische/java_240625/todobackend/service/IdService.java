package de.neuefische.java_240625.todobackend.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String randomId() {return UUID.randomUUID().toString();}
}
