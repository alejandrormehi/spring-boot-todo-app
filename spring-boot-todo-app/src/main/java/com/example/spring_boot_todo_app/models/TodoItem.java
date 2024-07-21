package com.example.spring_boot_todo_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "todo_items")

public class TodoItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Boolean isComplete;

	private Instant createdAt;

	private Instant updatedAt;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return String.format("TodoItem{id=%d, title='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}", id, title,
				isComplete, createdAt, updatedAt);
	}
}
