package com.sprint.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sprint.beans.Customer;
import com.sprint.beans.Menu;
import com.sprint.beans.Order;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orepo;

	//test to add order data in database
	@Test
	@DisplayName("Testcase to add new order in database.")
	@Rollback(false)
	@org.junit.jupiter.api.Order(1)
	public void testAddOrder() {
		
		//Adding a customer into database
		Customer cust = new Customer(1,"Shalini","Pathak","Ritu@8080","shalini@gmail.com","9304300823","Mumbai");
		
		Order order = new Order(3,"Chinese", 2, 50, cust);
		
		//calculating the price
		double price = (order.getPrice())*(order.getQuantity());
		order.setPrice(price);
		
		//saving order in database
		Order savedOrder = orepo.saveAndFlush(order);
		
		//Assert that the customer saved is not null.
		assertNotNull(savedOrder);		
	}
	
	//test to find all orders
	@Test
	@DisplayName("Testcase to find all orders.")
	@org.junit.jupiter.api.Order(2)
	public void testFindAllOrders() {
		List<Order> order = orepo.findAll();
		long rowCount = orepo.count();
		
		//Assert that the size of list of orders is equal to the size of count of rows in database.
		assertThat(order.size()).isEqualTo(rowCount);
	}
	
	//test to find order by orderID
	@Test
	@DisplayName("Testcase to find order by Order Id.")
	@org.junit.jupiter.api.Order(3)
	public void testFindOrderByOrderId(){
		int id = 1;
		Optional<Order> order = orepo.findById(id);
		
		//Assert that order fetched from database has same id equal to id entered by user.
		assertThat(order.get().getOrder_id()).isEqualTo(id);
	}
	
	
	//test to find order of one customer
	@Test
	@DisplayName("Testcase to find order by Customer ID.")
	@org.junit.jupiter.api.Order(4)
	public void testFindOrderListByCustomerId() {
		int cust_id = 1;
		List<String> list = new ArrayList<>();
		list = orepo.getOrderList(cust_id);
		
		//Assert that the count of order is not equal to 0.
		assertThat(list.size()).isNotEqualTo(0);
	}
	
	
}
