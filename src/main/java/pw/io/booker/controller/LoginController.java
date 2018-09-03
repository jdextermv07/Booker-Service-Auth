package pw.io.booker.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	

	
	
}
