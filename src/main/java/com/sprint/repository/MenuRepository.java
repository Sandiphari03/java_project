package com.sprint.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.beans.Customer;
import com.sprint.beans.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{


	@Query(value="SELECT food_name,food_price from menu" ,nativeQuery = true)
	public List<String> getMenu();
	
	@Query(value="SELECT f.food_price from menu f where f.food_name=:food_name",nativeQuery = true)
	public double itemPrice(@Param("food_name") String foodName);
	

	public List<Menu> findByfoodPrice(double foodPrice);
	
	//Menu findByM_id(int m_id);
	
	
}
