package com.example.crud.Service;

import com.example.crud.Model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrudService {

    List<Task> Tasks = new ArrayList<>();
    int id = 1;

    public List<Task> getTasks(){
        return Tasks;
    }

    public String addtask(Task task){
        task.setId(id++);
        Tasks.add(task);
        return "Added";
    }

    public Task getTaskById(int id){
      return  Tasks.stream().filter(task->task.getId()==id).findFirst().orElse(null);

    }

    public String updateTask(int id,Task task)  {
       Task todo= Tasks.stream().filter(tas->tas.getId()==id).findFirst().orElse(null);
       if(todo==null){
           return "No Task Found";
       }
       else{
           todo.setTask(task.getTask());
           return "Updated successfully";
       }

    }

    public List<Task> deleteAllTasks(){
          Tasks.clear();
          id= 1;
          return Tasks;
    }
    public List<Task> deleteById(int id ){
        for(Task t: Tasks)
        {
            if(t.getId()==id){
                Tasks.remove(t);
            return Tasks ;
        }}
return Tasks;
    }
}
