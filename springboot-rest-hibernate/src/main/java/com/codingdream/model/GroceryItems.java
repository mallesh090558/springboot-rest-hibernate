package com.codingdream.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="grocery_item")
@EntityListeners(AuditingEntityListener.class)
public class GroceryItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int item_id;
	@NotBlank
	int group_id;
	@NotBlank
	String item_code;
	@NotBlank
	String item_name;
	@NotBlank
	String item_price;
	@NotBlank
	String item_availability;
	@NotBlank
	String item_disc_percent;
	@NotBlank
	String created_on;
	@NotBlank
	String created_by;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_price() {
		return item_price;
	}
	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	public String getItem_availability() {
		return item_availability;
	}
	public void setItem_availability(String item_availability) {
		this.item_availability = item_availability;
	}
	public String getItem_disc_percent() {
		return item_disc_percent;
	}
	public void setItem_disc_percent(String item_disc_percent) {
		this.item_disc_percent = item_disc_percent;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
}
