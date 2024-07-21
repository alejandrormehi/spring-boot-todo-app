package com.example.spring_boot_todo_app.models;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

	private String street;
	private String city;
	private String zipcode;
	private String country;
	
	
}
