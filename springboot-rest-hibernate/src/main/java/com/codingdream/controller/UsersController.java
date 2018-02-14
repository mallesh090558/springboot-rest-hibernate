package com.codingdream.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdream.dao.UsersDAO;
import com.codingdream.model.Users;

@RestController
@RequestMapping("/application")
public class UsersController {
	@Autowired
	UsersDAO usersDao;
	
	@PostMapping("/createuser")
	public Users createUser(@Valid @RequestBody Users user) {
		return usersDao.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return usersDao.findAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> getUserByID(@PathVariable(value="id")Long id) {
		Users user = usersDao.getUserByUserID(id);
		if(user==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Users> updateUserByID(@PathVariable(value="id")Long id,
			@Valid @RequestBody Users userDetails) {
		Users user = usersDao.getUserByUserID(id);
		if(user==null)
			return ResponseEntity.notFound().build();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setMail(userDetails.getMail());
		user.setPhone(userDetails.getPhone());
		user.setPassword(userDetails.getPassword());
		user.setStampDate(userDetails.getStampDate());
		
		user = usersDao.saveUser(user);
		
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("/deleteusers/{id}")
	public ResponseEntity<Users> deleteUserByID(@PathVariable(value="id")Long id) {
		Users user = usersDao.getUserByUserID(id);
		if(user==null)
			return ResponseEntity.notFound().build();
		usersDao.deleteUser(user);
		return ResponseEntity.ok().body(user);
	} 
}
