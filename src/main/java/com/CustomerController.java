package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private EmailService emailService;

	@GetMapping("/form")
	public String showForm() {
		return "form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {

		repo.save(customer);

		// SEND EMAIL
		emailService.sendCustomerMail(customer);

		// WHATSAPP MESSAGE TEXT
		String msg = "New Loan Customer:%0A" + "Name:" + customer.getName() + "%0A" + "Mobile:" + customer.getMobile()
				+ "%0A" + "Loan:" + customer.getLoanType();

		// REDIRECT TO WHATSAPP
		return "redirect:https://wa.me/919000123549?text=" + msg;
	}
}