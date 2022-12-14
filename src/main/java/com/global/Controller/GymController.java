package com.global.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.global.Entity.Gym;

import com.global.Service.GymService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class GymController {

	@Autowired
	private GymService gymService;
	
	@GetMapping("/AllCustomers")
	public List<Gym> AllCustomers(){
		
		return gymService.GetAll();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Gym	> findById(@PathVariable Long id) {
		
		return gymService.getCustomerById(id);
	}
	
	
	@PostMapping("/Add")
	public Gym add(@RequestBody Gym m) {
		
		return gymService.addCustomer(m);
	}
	
	
	/*
	@PutMapping("update/{id}")
	public ResponseEntity<?> updateById(@RequestBody Gym m,@PathVariable Long id){
		if(gymService.exsistById(id)) {
			
			Gym t1 = gymService.getCustomerById(id).orElseThrow();
			t1.setId(m.getId());
			t1.setName(m.getName());
			t1.setHeight(m.getHeight());
			t1.setWeight(m.getWeight());
			t1.setPrice(m.getPrice());
			t1.setSystem_eat(m.getSystem_eat());
			
			gymService.addCustomer(t1);
			return ResponseEntity.ok().body(t1);	
			
		}else {
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + "Customer  not found or match");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}*/
	@PutMapping("/update/{id}")
	public Gym updateCustomer(@RequestBody Gym m ,@PathVariable Long id) {
		
		m.setId(id);
		return gymService.update(m);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String,String>> deleteById(@PathVariable Long id) {
		if(gymService.exsistById(id)) {
			gymService.delete(id);
			
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + "Customer deleted successfully");
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}else {
			
			HashMap<String, String> message = new HashMap<>();
			message.put("message","Customer id"+" "+ id +" "+ " not found or match");
		     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
		
	}
}
