package com.example.demo.config;

import com.example.demo.service.databaseseeder.SeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.awt.desktop.AppReopenedEvent;

@Configuration
public class ApplicationConfig {
    @Autowired
    SeederService seederService;

    @EventListener(ApplicationReadyEvent.class)
    public void seeTest(){
        System.out.println("");
        seederService.seeding();
    }
}
