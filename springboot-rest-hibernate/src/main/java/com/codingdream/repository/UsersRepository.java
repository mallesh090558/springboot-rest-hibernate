package com.codingdream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingdream.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	@Query("SELECT t FROM Users t WHERE t.username = ?1")
	Users findOneByUserName(String username);
}
