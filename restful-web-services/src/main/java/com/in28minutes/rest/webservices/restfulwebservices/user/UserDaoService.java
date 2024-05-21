package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import jakarta.persistence.criteria.Predicate;

import java.time.LocalDate;
import java.util.*;

@Component
public class UserDaoService {

	/*
	 * 
	 * 
	 * //JPA/HIBERNATE/DATABASE
	 * 
	 * //uSERdAOsERVICE>STATIC list
	 */
  
	private static List<User> users = new ArrayList<>();
	
	private static int userCount=0;
	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(24)));
		users.add(new User(++userCount, "Ravi", LocalDate.now().minusYears(21)));
		users.add(new User(++userCount, "suman", LocalDate.now().minusYears(29)));
		users.add(new User(++userCount, "Amann", LocalDate.now().minusYears(29)));

	}

	public List<User> findAll() {
		return users;
	}

//	public User findOne(int id) {
//		// TODO Auto-generated method stub

//		return users.get(id-1);
//	}
	
	
	
	public User findOne(int id) {

		
		java.util.function.Predicate<? super User> predicate=user->user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	//ADD USER
	
		public User save(User user) {
			user.setId(++userCount);
			users.add(user);
			return user;
		}
		

		
		
		public void deleteById(int id) {
			// TODO Auto-generated method stub
//			java.util.function.Predicate<? super User>  predicate=user->user.getId().equals(id);
//			users.remove(predicate);
			users.remove(id);
		}

}
