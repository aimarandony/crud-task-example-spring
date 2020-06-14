package com.example.taskcrud.service;

import com.example.taskcrud.domain.Task;
import com.example.taskcrud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task create(Task task){
        if (task.getName().isEmpty()) return null;
        return taskRepository.save(task);
    }

}
