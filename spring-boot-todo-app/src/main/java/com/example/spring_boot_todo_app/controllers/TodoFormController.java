package com.example.spring_boot_todo_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_boot_todo_app.services.TodoItemService;

@Controller
public class TodoFormController {

	@Autowired
	private TodoItemService todoItemService;
	
	@GetMapping("/create-todo")
	
	public String showCreateForm() {
		return "new-todo-item";
	}
	
}
