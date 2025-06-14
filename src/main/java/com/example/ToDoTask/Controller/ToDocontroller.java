package com.example.ToDoTask.Controller;

import com.example.ToDoTask.Model.Todo;
import com.example.ToDoTask.Service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ToDocontroller {

    @Autowired
    private TodoService todoService;


    @PostMapping("/add")
    public ResponseEntity<?> addDetails(@RequestBody Todo todo){

        return ResponseEntity.ok(todoService.add(todo));

    }
    @GetMapping("/view")
    public ResponseEntity<Object> viewAll(){
        try {
            return ResponseEntity.ok(todoService.viewall());
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteTaks(@PathVariable int id){
        try{
           todoService.deletetaks(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }



    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody Todo task){
        try {
           return ResponseEntity.ok(todoService.updatetake(id,task));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

}
