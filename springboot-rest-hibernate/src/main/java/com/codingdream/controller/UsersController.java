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
	
	/*	Base Methods based Common for all Models */
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
		
		user.setUser_id(userDetails.getUser_id());
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		user.setMobile_no(userDetails.getMobile_no());
		user.setUser_pin(userDetails.getUser_pin());
		user.setCreated_by(userDetails.getCreated_by());
		user.setCreated_on(userDetails.getCreated_on());
		user.setId(userDetails.getId());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setMail(userDetails.getMail());
		user.setPhone(userDetails.getPhone());
		user.setStamp_date(userDetails.getStamp_date());
		
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
	
	/*	Customized Methods based on Requirement */
	
	@GetMapping("/validateUserByUserId/{id}/{password}")
	public boolean validateUserByID(@PathVariable(value="id")Long id,
			@PathVariable(value="password")String password) {
		Users user = usersDao.getUserByUserID(id);
		if(user.getPassword().equals(password))
			return true;
		return false;
	}
	
	@GetMapping("/validateUserByUsername/{username}/{password}")
	public boolean validateUserByUserName(@PathVariable(value="username")String username,
			@PathVariable(value="password")String password) {
		Users user = usersDao.getUserByUserName(username);
		if(user.getPassword().equals(password))
			return true;
		return false;
	}
	
	@GetMapping("/updatePassword/{username}/{oldPassword}/{newPassword}")
	public boolean updateUserPassword(@PathVariable(value="username")String username,
			@PathVariable(value="oldPassword")String oldPassword,
			@PathVariable(value="newPassword")String newPassword) {
		Users user = usersDao.getUserByUserName(username);
		if(user.getPassword().equals(oldPassword)) {
			user.setPassword(newPassword);
			return true;
		}
		return false;
	}
}
