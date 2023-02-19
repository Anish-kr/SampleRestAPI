package com.rest.webservices.restfulwebservices.Social_Media;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Users {

	@Size(min=2)
	private Integer age;
	private String name;
	
	@Past
	private LocalDate BirthDate;
	
	public Users(Integer age, String name, LocalDate birthDate) {
		super();
		this.age = age;
		this.name = name;
		BirthDate = birthDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Users [age=" + age + ", name=" + name + ", BirthDate=" + BirthDate + "]";
	}
	
	
	
}
