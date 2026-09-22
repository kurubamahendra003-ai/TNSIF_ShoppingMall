package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userrepo;

	// post data
	public User addUser(User user) {
		return userrepo.save(user);
	}

	// Display
	public List<User> getUser() {
		return userrepo.findAll();
	}

	// delete data
	public void deleteUser(int id) {
		userrepo.deleteById(id);
	}

	// update
	public User updateUser(User user) {

		Integer userId = user.getId();

		User user1 = userrepo.findById(userId).get();

		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setUsertype(user.getUsertype());
		user1.setPassword(user.getPassword());

		return userrepo.save(user1);
	}
}