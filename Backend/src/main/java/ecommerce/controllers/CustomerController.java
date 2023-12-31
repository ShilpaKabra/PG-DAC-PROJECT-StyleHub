package ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.entities.Customer;
import ecommerce.models.LoginDTO;
import ecommerce.models.Response;
import ecommerce.services.CustomerService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	@ApiOperation(value = "Save a customer details", response = Customer.class)
	public ResponseEntity<?> save(@RequestBody Customer cust) {
		Customer newCustomer = customerService.registerCustomer(cust);
		if(newCustomer != null) {
			return ResponseEntity.status(HttpStatus.OK).body(newCustomer);
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body("Email ID already exist");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping
	@ApiOperation(value = "List all customers", response = Iterable.class)
	public ResponseEntity<?> findAllCustomers() {
		List<Customer> result = customerService.allCustomers();
		return Response.success(result);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Display the details of a customer")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") int id) {
		Customer result = customerService.findById(id);
		return Response.success(result);
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user = customerService.validate(dto.getUserid(), dto.getPwd());
		if (user != null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Customer cust, @PathVariable("id") int id) {
		customerService.updateProfile(cust);
		return Response.status(HttpStatus.OK);
	}

}
