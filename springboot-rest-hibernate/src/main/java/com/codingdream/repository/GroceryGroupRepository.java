package com.codingdream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingdream.model.GroceryGroups;

public interface GroceryGroupRepository extends JpaRepository<GroceryGroups, Long>{

}
