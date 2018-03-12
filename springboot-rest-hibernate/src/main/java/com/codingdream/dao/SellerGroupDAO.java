package com.codingdream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdream.model.SellerGroups;
import com.codingdream.repository.SellerGroupRepository;

@Service
public class SellerGroupDAO {
	@Autowired
	private SellerGroupRepository sellerGroupRepository;
	
	public SellerGroups saveSellerGroup(SellerGroups groceryGroups) {
		return sellerGroupRepository.save(groceryGroups);
	}
	
	public List<SellerGroups> findAllSellerGroups() {
		return sellerGroupRepository.findAll();
	}
	
	public SellerGroups getSellerGroupByID(Long id) {
		return sellerGroupRepository.findOne(id);
	}
	
	public void deleteSellerGroup(SellerGroups sellerGroups) {
		sellerGroupRepository.delete(sellerGroups);
	}
	
}
