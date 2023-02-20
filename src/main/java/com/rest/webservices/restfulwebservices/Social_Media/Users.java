package com.rest.webservices.restfulwebservices.Social_Media;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Users {

	@Id
	@GeneratedValue
	@Size(min=2,message="name should ve atleast 2 characters")
	@JsonProperty("User_Age")
	private Integer age;
	@JsonProperty("User_Name")
	private String name;
	
	@Past(message="birthdate should be in past")
	@JsonProperty("User_Birthdate")
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
