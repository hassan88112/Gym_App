package com.global.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.global.Entity.Gym;
import com.global.Repository.GymRepos;

@Service
public class GymService {

	
	@Autowired
	private GymRepos gymRepos;
	
	// get all customers
	public List<Gym> GetAll(){
		
		return gymRepos.findAll();
	}
	
	// check if id is exsist or not
    public Boolean exsistById(@PathVariable Long id) {
		
		return gymRepos.existsById(id);
	}
	
    
    //get customer by id
    public Optional<Gym> getCustomerById(@PathVariable Long  id) {
		
		return gymRepos.findById(id);
	}
	
    // add customers to system
    
	public Gym addCustomer(@RequestBody Gym m) {
		
		return gymRepos.save(m);
	}
	public Gym update(Gym m) {
		
		return gymRepos.save(m);
	}
	
	//delete by id
	public void delete(Long id) {
		
		 gymRepos.deleteById(id);
	}
	
}
