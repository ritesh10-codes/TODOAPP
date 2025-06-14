package com.example.ToDoTask.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title can't be more than 100 characters")
    String title;

    @Size(max = 500, message = "Description can't be more than 500 characters")
    String description;

//    @Column(nullable = false)
//    private String status = "Pending";
//
//    private LocalDateTime createdAt = LocalDateTime.now();


}
