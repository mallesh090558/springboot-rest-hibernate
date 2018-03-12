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

import com.codingdream.dao.GroceryGroupDAO;
import com.codingdream.model.GroceryGroups;

@RestController
@RequestMapping("/application")
public class GroceryGroupController {
	@Autowired
	GroceryGroupDAO groceryGroupDAO;
	
	@PostMapping("/createGroceryGroup")
	public GroceryGroups createGroceryGroups(@Valid @RequestBody GroceryGroups groceryGroups) {
		return groceryGroupDAO.saveGroceryGroup(groceryGroups);
	}
	
	@GetMapping("/groceryGroups")
	public List<GroceryGroups> getAllGroceryGroups() {
		return groceryGroupDAO.findAllGroceryGroups();
	}
	
	@GetMapping("/groceryGroups/{id}")
	public ResponseEntity<GroceryGroups> getUserByID(@PathVariable(value="id")Long id) {
		GroceryGroups groceryGroups = groceryGroupDAO.getGroceryGroupByID(id);
		if(groceryGroups==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(groceryGroups);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<GroceryGroups> updateUserByID(@PathVariable(value="id")Long id,
			@Valid @RequestBody GroceryGroups groceryGroupDetails) {
		GroceryGroups groceryGroups = groceryGroupDAO.getGroceryGroupByID(id);
		if(groceryGroups==null)
			return ResponseEntity.notFound().build();
		groceryGroups.setGroup_id(groceryGroupDetails.getGroup_id());
		groceryGroups.setGroup_availability(groceryGroupDetails.getGroup_availability());
		groceryGroups.setGroup_code(groceryGroupDetails.getGroup_code());
		groceryGroups.setGroup_name(groceryGroupDetails.getGroup_name());
		groceryGroups.setGroup_created_by(groceryGroupDetails.getGroup_created_by());
		groceryGroups.setGroup_created_on(groceryGroupDetails.getGroup_created_on());
		groceryGroups.setGroup_type(groceryGroupDetails.getGroup_type());
		
		groceryGroups = groceryGroupDAO.saveGroceryGroup(groceryGroups);
		
		return ResponseEntity.ok().body(groceryGroups);
	}
	
	@DeleteMapping("/deleteusers/{id}")
	public ResponseEntity<GroceryGroups> deleteUserByID(@PathVariable(value="id")Long id) {
		GroceryGroups groceryGroups = groceryGroupDAO.getGroceryGroupByID(id);
		if(groceryGroups==null)
			return ResponseEntity.notFound().build();
		groceryGroupDAO.deleteGroceryGroup(groceryGroups);
		return ResponseEntity.ok().body(groceryGroups);
	} 
}
