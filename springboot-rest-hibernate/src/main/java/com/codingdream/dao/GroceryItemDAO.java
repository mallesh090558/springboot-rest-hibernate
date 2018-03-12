package com.codingdream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdream.model.GroceryItems;
import com.codingdream.repository.GroceryItemRepository;

@Service
public class GroceryItemDAO {
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	public GroceryItems saveGroceryItems(GroceryItems groceryItems) {
		return groceryItemRepository.save(groceryItems);
	}
	
	public List<GroceryItems> findAllGroceryItems() {
		return groceryItemRepository.findAll();
	}
	
	public GroceryItems getGroceryItemsByID(Long id) {
		return groceryItemRepository.findOne(id);
	}
	
	public void deleteGroceryItems(GroceryItems groceryItems) {
		groceryItemRepository.delete(groceryItems);
	}
	
}