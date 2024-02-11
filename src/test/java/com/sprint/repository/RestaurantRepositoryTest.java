package com.sprint.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sprint.beans.Customer;
import com.sprint.beans.Restaurant;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class RestaurantRepositoryTest {

	@Autowired
	private RestaurantRepository rsrepo;
	
	@Test
	@DisplayName("Testcase to add new restaurant in database.")
	@Rollback(false)
	@Order(1)
	public void testAddRestaurant() {
		
		Restaurant rest = new Restaurant(1,"def@gmail.com", "Ritu@8080","WayToFood", "Mumbai");
		Restaurant savedRest = rsrepo.saveAndFlush(rest);
		
		//Assert that the customer saved is not null.
		assertNotNull(savedRest);		
	}
	
	@Test
	@DisplayName("Testcase to check restaurant login.")
	@Order(2)
    public void testLoginRestaurant() {
    	int rest_id = 1;
    	String password = "Ritu@8080";
    	Restaurant restaurant = rsrepo.loginRestaurant(rest_id, password);
    	
    	//Assert that entered password is equal to restaurant password.
    	assertThat(restaurant.getRestaurantPwd()).isEqualTo(password);
    }
	
	@Test
	@DisplayName("Testcase to find all restaurant details.")
	@Order(3)
	public void testFindAllRestaurant() {
		List<Restaurant> list = new ArrayList<>();
		list = rsrepo.findAll();
		long rowCount = rsrepo.count();
		
		//Assert that the size of list of restaurants is equal to the size of count of rows in database.
		assertThat(list.size()).isEqualTo(rowCount);
	}
	
	@Test
	@DisplayName("Testcase to find Restaurant By Id.")
	@Order(4)
	public void testFindRestaurantById() {
		int id = 1;
		Optional<Restaurant> rest = rsrepo.findById(id);
		
		//Assert that restaurant fetched from database has same id equal to id entered by user.
		assertThat(rest.get().getRid()).isEqualTo(id);		
	}
	
	@Test
    @DisplayName("Test to get restaurant details by Email.") 
	@Order(5)
    public void testFindRestaurantByEmail() {
    	String email = "def@gmail.com";
    	Restaurant rest = rsrepo.findByrestaurantEmail(email);
    	
    	//Assert that email of customer from database is equal to given emailId.
    	assertThat(rest.getRestaurantEmail()).isEqualTo(email);  	
    }
}
