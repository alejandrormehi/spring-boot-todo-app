package com.example.spring_boot_todo_app.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.spring_boot_todo_app.models.TodoItem;
import com.example.spring_boot_todo_app.models.User;
import com.example.spring_boot_todo_app.services.TodoItemService;
import com.example.spring_boot_todo_app.services.UserService;

import jakarta.validation.Valid;

@Controller
public class TodoFormController {

	@Autowired
	private TodoItemService todoItemService;

	@Autowired
	private UserService userService; // Inyectar UserService

	@GetMapping("/create-todo")
	public String showCreateForm(TodoItem todoItem, Model model) {
		model.addAttribute("users", userService.getAllUsers()); // Agregar usuarios al modelo
		return "new-todo-item";
	}

	@GetMapping("/filter")
	public String filterTodoItems(@RequestParam(required = false) String username,
			@RequestParam(required = false) String title, Model model) {

		List<TodoItem> filteredItems = todoItemService.filterTodoItems(username, title);

		model.addAttribute("filteredTodos", filteredItems);
		model.addAttribute("todoItems", todoItemService.getAll());
		return "index";
	}

	@PostMapping("/todo")
	public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("users", userService.getAllUsers()); // Agregar usuarios al modelo en caso de error
			return "new-todo-item";
		}
		// Asigna el usuario seleccionado al todoItem
		User user = userService.findByUsername(todoItem.getUser().getUsername());

		// Asegúrate de que el usuario no sea nulo
		if (user == null) {
			// Maneja el caso donde el usuario es nulo
			return "redirect:/error";
		}

		todoItem.setUser(user);
		
		// Establecer las fechas de creación y actualización
	    todoItem.setCreatedAt(Instant.now());
	    todoItem.setUpdatedAt(Instant.now());

		todoItemService.save(todoItem);
		return "redirect:/";
	}
	
	
	

	@GetMapping("/delete/{id}")
	public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
		TodoItem todoItem = todoItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("To-Do item id: " + id + " not found"));

		todoItemService.delete(todoItem);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		TodoItem todoItem = todoItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("To-Do item id: " + id + " not found"));

		model.addAttribute("todo", todoItem);
		return "edit-todo-item";
	}

	@PostMapping("/todo/{id}")
	public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result,
			Model model) {
		TodoItem item = todoItemService.getById(id)
				.orElseThrow(() -> new IllegalArgumentException("To-Do item id: " + id + " not found"));
		item.setIsComplete(todoItem.getIsComplete());
		item.setTitle(todoItem.getTitle());

		todoItemService.save(item);

		return "redirect:/";

	}

}
