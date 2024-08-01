package com.aleksey.spring_boot_33.__todo_application.controllers;

import com.aleksey.spring_boot_33.__todo_application.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private ToDoItemService service;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("ToDoItems", service.getAll());
        return modelAndView;
    }
}
