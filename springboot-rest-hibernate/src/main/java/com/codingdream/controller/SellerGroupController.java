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

import com.codingdream.dao.SellerGroupDAO;
import com.codingdream.model.SellerGroups;

@RestController
@RequestMapping("/application")
public class SellerGroupController {
	@Autowired
	SellerGroupDAO sellerGroupDAO;
	
	@PostMapping("/createSellerGroup")
	public SellerGroups createSellerGroups(@Valid @RequestBody SellerGroups sellerGroups) {
		return sellerGroupDAO.saveSellerGroup(sellerGroups);
	}
	
	@GetMapping("/sellerGroups")
	public List<SellerGroups> getAllSellerGroups() {
		return sellerGroupDAO.findAllSellerGroups();
	}
	
	@GetMapping("/sellerGroups/{id}")
	public ResponseEntity<SellerGroups> getUserByID(@PathVariable(value="id")Long id) {
		SellerGroups sellerGroups = sellerGroupDAO.getSellerGroupByID(id);
		if(sellerGroups==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(sellerGroups);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<SellerGroups> updateUserByID(@PathVariable(value="id")Long id,
			@Valid @RequestBody SellerGroups sellerGroupDetails) {
		SellerGroups sellerGroups = sellerGroupDAO.getSellerGroupByID(id);
		if(sellerGroups==null)
			return ResponseEntity.notFound().build();
		sellerGroups.setGroup_id(sellerGroupDetails.getGroup_id());
		sellerGroups.setGroup_availability(sellerGroupDetails.getGroup_availability());
		sellerGroups.setGroup_code(sellerGroupDetails.getGroup_code());
		sellerGroups.setGroup_name(sellerGroupDetails.getGroup_name());
		sellerGroups.setGroup_created_by(sellerGroupDetails.getGroup_created_by());
		sellerGroups.setGroup_created_on(sellerGroupDetails.getGroup_created_on());
		sellerGroups.setGroup_type(sellerGroupDetails.getGroup_type());
		
		sellerGroups = sellerGroupDAO.saveSellerGroup(sellerGroups);
		
		return ResponseEntity.ok().body(sellerGroups);
	}
	
	@DeleteMapping("/deleteusers/{id}")
	public ResponseEntity<SellerGroups> deleteUserByID(@PathVariable(value="id")Long id) {
		SellerGroups sellerGroups = sellerGroupDAO.getSellerGroupByID(id);
		if(sellerGroups==null)
			return ResponseEntity.notFound().build();
		sellerGroupDAO.deleteSellerGroup(sellerGroups);
		return ResponseEntity.ok().body(sellerGroups);
	} 
}
