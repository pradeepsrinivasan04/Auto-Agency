package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.LoginCredentials;
import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.exceptions.ExistingUserException;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> newCustomer( @Valid   @RequestBody CustomerDTO customerDTO) throws ExistingUserException
	{
	
		ResponseEntity<CustomerDTO> custDto = customerService.createCustomer(customerDTO);
        return custDto;
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws CustomerNotFoundException
	{
		ResponseEntity<List<CustomerDTO>> customersDto = customerService.getAllCustomers();
		return customersDto;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) throws CustomerNotFoundException
	{
		ResponseEntity<CustomerDTO> customerDTO = customerService.getCustomer(id);
		return customerDTO;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateVehicle(@PathVariable Integer id , @RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException
	{
		ResponseEntity<CustomerDTO> updatedCustomer = customerService.updateCustomer(id, customerDTO);
		return updatedCustomer;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginCredentials loginCredentials)
	{
		ResponseEntity<String> loginMsg =  customerService.login(loginCredentials);
		return loginMsg;
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) throws CustomerNotFoundException
	{
		ResponseEntity<String> deletedCustomer = customerService.deleteCustomer(id);
		return deletedCustomer;
		
	}
	


	  
}
