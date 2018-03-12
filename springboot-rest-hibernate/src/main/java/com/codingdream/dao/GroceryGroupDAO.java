package com.codingdream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdream.model.GroceryGroups;
import com.codingdream.repository.GroceryGroupRepository;

@Service
public class GroceryGroupDAO {
	@Autowired
	private GroceryGroupRepository groceryGroupRepository;
	
	public GroceryGroups saveGroceryGroup(GroceryGroups groceryGroups) {
		return groceryGroupRepository.save(groceryGroups);
	}
	
	public List<GroceryGroups> findAllGroceryGroups() {
		return groceryGroupRepository.findAll();
	}
	
	public GroceryGroups getGroceryGroupByID(Long id) {
		return groceryGroupRepository.findOne(id);
	}
	
	public void deleteGroceryGroup(GroceryGroups groceryGroups) {
		groceryGroupRepository.delete(groceryGroups);
	}
	
}
