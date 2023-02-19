package com.rest.webservices.restfulwebservices.Social_Media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import java.util.function.Predicate;


@Component
public class UserDauService {

	private static List<Users> users=new ArrayList<>();
	static int count=0;
	static {
		users.add(new Users(++count,"adam",LocalDate.now().minusYears(30)));
		users.add(new Users(++count,"mdam",LocalDate.now().minusYears(20)));
		users.add(new Users(++count,"kdam",LocalDate.now().minusYears(15)));
	}
	
	public List<Users> findAll(){
		return users;
	}
	
	
	public Users findOne(int id){
		Predicate<? super Users> predicate=users-> users.getAge().equals(id);
		return users.stream().filter(predicate).findFirst().get();
			}
	
	public Users save(Users user)
	{	user.setAge(++count);
		users.add(user);
		return user;
		
	}
	
	public void deleteById(int id) {
		Predicate<? super Users> predicate = user -> user.getAge().equals(id);
		users.removeIf(predicate);
	}
	}

