package com.example.spring_boot_todo_app.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring_boot_todo_app.models.TodoItem;
import com.example.spring_boot_todo_app.services.TodoItemService;

@Controller
public class HomeController {

	@Autowired
	private TodoItemService todoItemService;
	
	@GetMapping("/")
	public ModelAndView index(@RequestParam(required = false) String username, 
							  @RequestParam(required = false) String title,
							  @RequestParam(defaultValue = "0") int page,
							  @RequestParam(defaultValue = "10") int size) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		Iterable<TodoItem> allTodos = todoItemService.getAll();
	    modelAndView.addObject("todoItems", allTodos);
	    
	    
	 // Filtra elementos si se proporcionan parámetros
        if (username != null || title != null) {
            List<TodoItem> filteredTodos = todoItemService.filterTodoItems(username, title);
            modelAndView.addObject("filteredTodos", filteredTodos);
        } else {
            modelAndView.addObject("filteredTodos", Collections.emptyList());
        }

        return modelAndView;
	}
}
