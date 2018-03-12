package com.codingdream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingdream.model.GroceryItems;

public interface GroceryItemRepository extends JpaRepository<GroceryItems, Long>{

}
