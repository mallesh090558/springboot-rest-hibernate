package com.codingdream.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingdream.model.SellerItems;

public interface SellerItemRepository extends JpaRepository<SellerItems, Long>{

}
