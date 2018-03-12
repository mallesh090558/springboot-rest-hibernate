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
@Table(name="grocery_groups")
@EntityListeners(AuditingEntityListener.class)
public class GroceryGroups {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int group_id;
	@NotBlank
	String group_code;
	@NotBlank
	String group_name;
	@NotBlank
	String group_type;
	@NotBlank
	String group_availability;
	@NotBlank
	String group_created_on;
	@NotBlank
	String group_created_by;
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_code() {
		return group_code;
	}
	public void setGroup_code(String group_code) {
		this.group_code = group_code;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_type() {
		return group_type;
	}
	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}
	public String getGroup_availability() {
		return group_availability;
	}
	public void setGroup_availability(String group_availability) {
		this.group_availability = group_availability;
	}
	public String getGroup_created_on() {
		return group_created_on;
	}
	public void setGroup_created_on(String group_created_on) {
		this.group_created_on = group_created_on;
	}
	public String getGroup_created_by() {
		return group_created_by;
	}
	public void setGroup_created_by(String group_created_by) {
		this.group_created_by = group_created_by;
	}
	
}
