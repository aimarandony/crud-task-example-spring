package com.example.taskcrud.config;

import com.example.taskcrud.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PopulateConfig {

    @Autowired
    DatabaseUtil databaseUtil;

    @PostConstruct
    public void init(){
        databaseUtil.init();
    }
}
