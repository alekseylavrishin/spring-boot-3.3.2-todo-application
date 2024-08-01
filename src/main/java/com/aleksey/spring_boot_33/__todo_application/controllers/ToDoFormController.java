package com.aleksey.spring_boot_33.__todo_application.controllers;

import ch.qos.logback.core.model.Model;
import com.aleksey.spring_boot_33.__todo_application.models.ToDoItem;
import com.aleksey.spring_boot_33.__todo_application.services.ToDoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String showCreateForm(ToDoItem item) {
        return "new-todo-item";
    }

    /**
     * Listens for the POST call
     */
    @PostMapping("/todo")
    public String createToDoItem(@Valid ToDoItem item, BindingResult result, Model model) {
        ToDoItem TDItem = new ToDoItem();
        TDItem.setDescription(item.getDescription());
        TDItem.setComplete(item.isComplete());

        service.save(item);
        return "redirect:/";
    }
}
