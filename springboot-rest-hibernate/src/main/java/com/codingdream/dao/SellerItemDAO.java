package com.codingdream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdream.model.SellerItems;
import com.codingdream.repository.SellerItemRepository;

@Service
public class SellerItemDAO {
	@Autowired
	private SellerItemRepository sellerItemRepository;
	
	public SellerItems saveSellerItems(SellerItems groceryItems) {
		return sellerItemRepository.save(groceryItems);
	}
	
	public List<SellerItems> findAllSellerItems() {
		return sellerItemRepository.findAll();
	}
	
	public SellerItems getSellerItemsByID(Long id) {
		return sellerItemRepository.findOne(id);
	}
	
	public void deleteSellerItems(SellerItems sellerItems) {
		sellerItemRepository.delete(sellerItems);
	}
	
}