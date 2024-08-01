package com.aleksey.spring_boot_33.__todo_application.controllers;

import com.aleksey.spring_boot_33.__todo_application.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoFormController {

    @Autowired
    private ToDoItemService service;

    /**
     * Returns the name of the view that is returned, referencing ../../resources/templates/new-todo-item.html
     *
     * @return Name of view that is returned
     */
    @GetMapping("/create-todo")
    public String showCreateForm() {
        return "new-todo-item";
    }
}
