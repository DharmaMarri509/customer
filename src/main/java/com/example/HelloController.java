package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Autowired
	CustomerService custService;

	@GetMapping("/getcustomers")
	public List<Customer> getCustomers() {
		return custService.getCustomer();
		
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody Customer c) {
		return custService.saveCustomer(c);
	}
	
	@PutMapping("/update")
	public String updateProd(@RequestParam Integer id, @RequestBody Customer c) {
		return custService.updateCustomer(id, c);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProd(@PathVariable int id) {
		return custService.deleteCustomer(id);
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "welcome to wirpo";
	}
	
}
