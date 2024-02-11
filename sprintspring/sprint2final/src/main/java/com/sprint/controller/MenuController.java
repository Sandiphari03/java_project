package com.sprint.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sprint.beans.Menu;
import com.sprint.beans.Order;
import com.sprint.exception.ResourceNotFoundException;
import com.sprint.repository.MenuRepository;
import com.sprint.service.MenuService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuRepository mRepo;
	
	@Autowired
	MenuService service;
	
	
	@PostMapping(value="/addMenu")
	public Menu create(@RequestBody final Menu menu) {
		return mRepo.saveAndFlush(menu);
	}
	 
	@GetMapping()
	public List<String> getMenu(){
		List<String> menu =service.getMenu();
		return menu;
	}
	
	@GetMapping(value ="/get")
	public List<Menu> list(){
		return mRepo.findAll();
	}
	
	//to get particular menu
	@GetMapping("/{id}")
	public Optional<Menu> allOrder(@PathVariable("id") int m_id){
		return mRepo.findById((long) m_id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value="id")long m_id) throws ResourceNotFoundException{
		Menu menu = mRepo.findById(m_id)
				.orElseThrow(()->new ResourceNotFoundException("Menu not found for this id::"+ m_id));
		
		this.mRepo.delete(menu);
		
		Map<String, Boolean> response = new HashMap<>();
		response.putIfAbsent("deleted", Boolean.TRUE);
		
		return response;
	
	}
	@PutMapping("/updateMenu/{id}")
	public ResponseEntity<Menu> updateRestaurant(@PathVariable(value="id")long m_id,
			@Valid @RequestBody Menu menu) throws ResourceNotFoundException{
		Menu m = this.mRepo.findById(m_id)
				.orElseThrow(()->new ResourceNotFoundException("Menu item found for this id::"+ m_id));
		
		m.setFoodName(menu.getFoodName());
		m.setFoodPrice(menu.getFoodPrice());
		
		return ResponseEntity.ok(this.mRepo.save(m));
	}
	
	
}

