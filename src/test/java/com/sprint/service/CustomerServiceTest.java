package com.sprint.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint.beans.Customer;
import com.sprint.repository.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CustomerServiceTest {

	@Autowired
	private CustomerServiceImpl custService;
	
	@MockBean
	private CustomerRepository cRepo;
	
	
	@Test
	@DisplayName("Testcase to register or save customer.")
	@Order(1)
	public void testSaveOrUpdateCustomer() {
		
		Customer customer=new Customer();
		customer.setCustomerId(5);
		customer.setFirstName("Smita");
		customer.setLastName("Mhatre");
		customer.setPassword("Smita@1234");
		customer.setMailId("smita@gmail.com");
		customer.setMobileNo("9087654321");
		customer.setAddress("Mumbai");
		
		Mockito.when(cRepo.saveAndFlush(customer)).thenReturn(customer);
		assertThat(custService.saveOrUpdate(customer)).isEqualTo("customer Registered successfully");
	}
	
	@Test
	@DisplayName("Testcase to get all registered customers.")
	@Order(2)
	public void testGetAllCustomers() {
		
		Customer customer1=new Customer();
		customer1.setCustomerId(1);
		customer1.setFirstName("nisha");
		customer1.setLastName("chaturvedi");
		customer1.setMailId("nisha123@gmail.com");
		customer1.setMobileNo("9060741288");
		customer1.setPassword("Nisha@1234");
	    
		Customer customer2=new Customer();
		customer2.setCustomerId(2);
		customer2.setFirstName("nisha");
		customer2.setLastName("kumari");
		customer2.setMailId("nisha098@gmail.com");
		customer2.setMobileNo("9005741456");
		customer2.setPassword("Nisha@kum23");
	    
	    List<Customer> customer = new ArrayList<Customer>();
	    customer.add(customer1);
	    customer.add(customer2);
	    
		Mockito.when(cRepo.findAll()).thenReturn(customer);
		assertThat(custService.getAllCustomers()).isEqualTo(customer);
	}
	
	@Test
	@DisplayName("Testcase to login customer.")
	@Order(3)
	public void testLoginCustomer() {
		
		Customer customer=new Customer();
		customer.setCustomerId(2);
		customer.setFirstName("nisha");
		customer.setLastName("chaturvedi");
		customer.setMailId("nisha123@gmail.com");
		customer.setMobileNo("9060741288");
		customer.setPassword("Nisha@1234");
				
		Mockito.when(cRepo.loginCustomer(2, "Nisha@1234")).thenReturn(customer);
		assertThat(custService.loginCustomer(2, "Nisha@1234")).isEqualTo(customer);
	}
	
	@Test
	@DisplayName("Testcase to fetch customer by their id.")
	@Order(4)
	public void testFindCustomerById() {
	
		Customer customer=new Customer();
		customer.setCustomerId(2);
		customer.setFirstName("nisha");
		customer.setLastName("chaturvedi");
		customer.setMailId("nisha123@gmail.com");
		customer.setMobileNo("9060741288");
		customer.setPassword("Nisha@1234");
		
		Mockito.when(cRepo.findByCustomerId(2)).thenReturn(customer);
	    assertThat(custService.findOneById(2)).isEqualTo(customer);
	}
}
