package br.com.aweb.to_do_list.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Todo {
    private Long id;
    private String title;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDate deadline;
    private LocalDat

    
    
}
