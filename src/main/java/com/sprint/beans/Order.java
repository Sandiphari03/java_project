package com.sprint.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

@Entity
@Table(name="view_order", schema = "public")
public class Order implements Serializable{
	@Id
	@Column(nullable=false)
	private int order_id;
	
//	@NotNull
//	@Size(min=2,message="Name should atleast have 2 characters")
//	@Column(nullable=false)
//	private String name;
//
//	@NotNull
//	@Column(nullable=false)
//	private double price;
	
//	@OneToMany(targetEntity = Order.class, mappedBy = "customers",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonIgnoreProperties({"customers","hibernateLazyInitializer", "handler"})
	
	@NotNull
	@Column(nullable=false)
	private int quantity;
	
	
	
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id", referencedColumnName = "customerId", nullable= true)/*The @JoinColumn annotation helps Hibernate to figure out that there is a customer_id Foreign Key column in the order table that defines this association.*/
	@JsonIgnoreProperties({"orders","hibernateLazyInitializer", "handler"})
	private Customer customers;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="m_id", referencedColumnName = "m_id",nullable=true)  
	@JsonIgnoreProperties({"orders","hibernateLazyInitializer", "handler"})
	@LazyCollection(LazyCollectionOption.FALSE)
	private Menu menu;
	

	
	//default constructor
	public Order() {
		super();
	}


	//Parameterised constructor 
	public Order(int order_id, @NotNull int quantity, Customer customers, Menu menu) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.customers = customers;
		this.menu = menu;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Customer getCustomers() {
		return customers;
	}


	public void setCustomers(Customer customers) {
		this.customers = customers;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", quantity=" + quantity + ", customers=" + customers + ", menu=" + menu
				+ "]";
	}


	
	

		
}
