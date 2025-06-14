package com.example.ToDoTask.Repsitory;


import com.example.ToDoTask.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {
//    void delete(Integer id);
}
