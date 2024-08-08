package com.aleksey.spring_boot_33.__todo_application.controllers;


import com.aleksey.spring_boot_33.__todo_application.models.ToDoItem;
import com.aleksey.spring_boot_33.__todo_application.services.ToDoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showCreateForm(@ModelAttribute("todoItem") ToDoItem todoItem) {
        return "new-todo-item";
    }

    /**
     * Listens for the POST call
     */
    @PostMapping("/todo")
    public String createToDoItem(@Valid ToDoItem todoItem, BindingResult result, Model model) {
        ToDoItem TDItem = new ToDoItem();
        TDItem.setDescription(todoItem.getDescription());
        TDItem.setIsComplete(todoItem.getIsComplete());

        service.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteToDoItem(@PathVariable("id") Long id, Model model) {
        ToDoItem todoItem = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Todo Item id: " + id + " not found"));
        service.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        ToDoItem todoItem = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Todo Item id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateToDoItem(@PathVariable("id") Long id, @Valid ToDoItem todoItem, BindingResult result, Model model) {
        ToDoItem item = service.getById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Todo Item id: " + id + " not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        service.save(item);
        return "redirect:/";
    }

}
