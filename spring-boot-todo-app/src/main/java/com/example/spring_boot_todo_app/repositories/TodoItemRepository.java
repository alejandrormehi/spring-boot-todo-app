package com.example.spring_boot_todo_app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_todo_app.models.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByUserUsername(String username);
    List<TodoItem> findByTitleContaining(String title);
	List<TodoItem> findByUserUsernameAndTitleContaining(String username, String title);
	
	
}
