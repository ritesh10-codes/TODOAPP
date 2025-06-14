package com.example.ToDoTask.Service;


import com.example.ToDoTask.Model.Todo;
import com.example.ToDoTask.Repsitory.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;


    public Todo add(Todo todo) {
      Todo t=  todoRepo.save(todo);

       if(t==null){
           return null;
       }
       return t;
    }

    public Object viewall() {
        return todoRepo.findAll();
    }

    public void deletetaks(int id) {
        todoRepo.deleteById(id);
    }

    public Todo updatetake(int id, Todo updatedTask) {
        Todo existing = todoRepo.getById(id);
        if (updatedTask.getTitle() != null) existing.setTitle(updatedTask.getTitle());
        if (updatedTask.getDescription() != null) existing.setDescription(updatedTask.getDescription());
//        if (updatedTask.getStatus() != null) existing.setStatus(updatedTask.getStatus());
        return todoRepo.save(existing);
    }
}
