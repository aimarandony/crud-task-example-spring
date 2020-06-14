package com.example.taskcrud.controller;

import com.example.taskcrud.domain.Task;
import com.example.taskcrud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> init(){
        return taskService.findAll();
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> create(@RequestBody Task task){
        Map<String, Object> resp = new HashMap<>();
        try {
            Task taskCreated = taskService.create(task);
            if (taskCreated == null){
                resp.put("msg","Falta añadir el nombre de la tarea");
            }else{
                resp.put("msg","Tarea creada con exito");
                resp.put("task",taskCreated);
            }
        } catch (DataAccessException ex){
            resp.put("msg","Error en la BD");
            resp.put("error","Error: ".concat(ex.getMessage()).concat(" - ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
