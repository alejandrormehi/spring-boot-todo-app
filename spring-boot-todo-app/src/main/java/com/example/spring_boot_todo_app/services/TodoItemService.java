package com.example.spring_boot_todo_app.services;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_todo_app.models.TodoItem;
import com.example.spring_boot_todo_app.repositories.TodoItemRepository;

@Service
public class TodoItemService {

	@Autowired
	private TodoItemRepository todoItemRepository;

	public Iterable<TodoItem> getAll() {
		return todoItemRepository.findAll();
	}

	public Optional<TodoItem> getById(Long id) {
		return todoItemRepository.findById(id);
	}

	public TodoItem save(TodoItem todoItem) {
		if (todoItem.getId() == null) {
			todoItem.setCreatedAt(Instant.now());
		}
		todoItem.setUpdatedAt(Instant.now());
		return todoItemRepository.save(todoItem);

	}

	public void delete(TodoItem todoItem) {
		todoItemRepository.delete(todoItem);
	}

	public List<TodoItem> filterTodoItems(String username, String title) {
		if (username != null && !username.isEmpty() && title != null && !title.isEmpty()) {
			return todoItemRepository.findByUserUsernameAndTitleContaining(username, title);
		} else if (username != null && !username.isEmpty()) {
			return todoItemRepository.findByUserUsername(username);
		} else if (title != null && !title.isEmpty()) {
			return todoItemRepository.findByTitleContaining(title);
		} else {
			return todoItemRepository.findAll();
		}
	}
}