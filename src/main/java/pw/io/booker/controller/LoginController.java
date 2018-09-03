package pw.io.booker.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pw.io.booker.model.Customer;
import pw.io.booker.service.LoginService;

@RestController
@Transactional
@RequestMapping("/customerregistration")
public class LoginController {
	
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@PostMapping
	public String generateToken(@RequestBody Customer customer) {
		return loginService.generateToken(customer);
	}
	
	@DeleteMapping("/logout")
	public void deleteToken(@RequestHeader("Authentication-Token") String token) {
		loginService.deleteToken(token);
	}

	
	
}
