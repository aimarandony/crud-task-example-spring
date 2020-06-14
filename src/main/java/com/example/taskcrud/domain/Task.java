package com.example.taskcrud.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TASKS")
@Entity
@Data
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean state;

    @PrePersist
    public void prePersist(){
        state = true;
    }
}
