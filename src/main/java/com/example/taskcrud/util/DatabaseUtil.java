package com.example.taskcrud.util;

import com.example.taskcrud.domain.Task;
import com.example.taskcrud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUtil {

    @Autowired
    TaskService taskService;

    public void init(){
        if (taskService.findAll().isEmpty()){
            Task task = new Task();
            task.setName("Task 01");
            taskService.create(task);

            task = new Task();
            task.setName("Task 02");
            taskService.create(task);

            task = new Task();
            task.setName("Task 03");
            taskService.create(task);
        }
    }
}
