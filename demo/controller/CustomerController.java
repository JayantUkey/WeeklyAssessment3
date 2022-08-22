package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;

@RestController
public class CustomerController {
	
	@Autowired 
	CustomerRepo repo;
	
	//Create
	@PostMapping(path="/customer", consumes= {"application/json"})
	public Customer addCustomer(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	//Retrive
	
	@GetMapping("/customers") 
	public List<Customer> getCustomers()
	{
		return repo.findAll();
	}
	
	
	//Update
	@PutMapping(path="/customer", consumes= {"application/json"})
	public Customer saveOrUpdateCustomer(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}

	//Delete
	@DeleteMapping("/customer/{cId}")
	public String deleteCustomer(@PathVariable int cId)
	{
		Customer cus = repo.getOne(cId);
		repo.delete(cus);
		
		return "deleted";
	}
	
}
