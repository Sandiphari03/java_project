package com.sprint.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Menu implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;
	
	private String foodName;

	private double foodPrice;
	
	
//	@OneToMany(targetEntity = Order.class, mappedBy = "menus",orphanRemoval = true, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"menus","hibernateLazyInitializer", "handler"})
//	private List<Order> orders1;
//
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@JoinColumn(name = "m_id")
	private List<Order> orders1 = new ArrayList<>();
	
	//

	public Menu() {}

public Menu(int m_id, String foodName, double foodPrice, List<Order> orders) {
	super();
	this.m_id = m_id;
	this.foodName = foodName;
	this.foodPrice = foodPrice;
	this.orders1 = orders;
}


public int getM_id() {
	return m_id;
}

public void setM_id(int m_id) {
	this.m_id = m_id;
}

public String getFoodName() {
	return foodName;
}

public void setFoodName(String foodName) {
	this.foodName = foodName;
}

public double getFoodPrice() {
	return foodPrice;
}

public void setFoodPrice(double foodPrice) {
	this.foodPrice = foodPrice;
}

public List<Order> getOrders() {
	return orders1;
}

public void setOrders(List<Order> orders) {
	this.orders1 = orders;
}

@Override
public String toString() {
	return "Menu [m_id=" + m_id + ", foodName=" + foodName + ", foodPrice=" + foodPrice +"]";
}
	
	



}
