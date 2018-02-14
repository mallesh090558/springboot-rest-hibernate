package com.codingdream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdream.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
