package com.example.crud.Controller;


import com.example.crud.Model.Task;
import com.example.crud.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("http://localhost:5173")
public class CrudController {
    @Autowired
    private CrudService crudService;


    @GetMapping("/v1")
    public List<Task> getTasks(){
        return crudService.getTasks();
    }
    @PostMapping("/v1/add")
    public String addTask(@RequestBody Task task){
        return crudService.addtask(task);
    }

    @GetMapping("/v1/{id}")
    public Task getTaskById(@PathVariable int id){
        return crudService.getTaskById(id);
    }

    @PutMapping("/v1/update/{id}")
    public String updateTask(@PathVariable int id,@RequestBody Task task){
        return crudService.updateTask(id,task);
    }

    @DeleteMapping("/v1")
    public List<Task> deleteALl(){
        return crudService.deleteAllTasks();
    }

    @DeleteMapping("/v1/{id}")
    public List<Task> delete(@PathVariable int id){
        return crudService.deleteById(id);
    }


}
