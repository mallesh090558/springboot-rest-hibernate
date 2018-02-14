package com.codingdream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdream.model.Users;
import com.codingdream.repository.UsersRepository;

@Service
public class UsersDAO {
	@Autowired
	private UsersRepository usersRepository;
	
	public Users saveUser(Users user) {
		return usersRepository.save(user);
	}
	
	public List<Users> findAllUsers() {
		return usersRepository.findAll();
	}
	
	public Users getUserByUserID(Long id) {
		return usersRepository.findOne(id);
	}
	
	public void deleteUser(Users user) {
		usersRepository.delete(user);
	}
	
}
