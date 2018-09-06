package com.in28min.rest.webservice.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();

	private static int userCount = 4;
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "jack", new Date()));
		users.add(new User(4, "Jill", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		
			user.setId(++userCount);
		
		users.add(user);
		for (User user1 : users) {
			System.out.println(user1);
		}
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				// return user;
			}
		}
		return null;
	}

}
