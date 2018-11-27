package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//whatever class your mappings go in must be a controller; name of class doesn't matter
@RestController
//use requestmapping here to add prefix to all mappings eg /prefix/tasks
//note that trailing slashes are also mapped!
@RequestMapping("/prefix")
public class TasksController {

    //can also use @requestmapping to indiscriminately respond to get/post/put etc
    @GetMapping("/tasks")
    //name of the method doesn't matter
    public String getTasks() {
        return "These are tasks";
    }

    @PostMapping("/tasks")
    public String createTask() {
        return "You just POSTed to /tasks";
    }
}
