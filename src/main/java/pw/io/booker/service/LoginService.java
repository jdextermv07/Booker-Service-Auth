package pw.io.booker.service;

import org.springframework.transaction.annotation.Transactional;

import pw.io.booker.repo.AuthenticationRepository;

public class LoginService {

	private AuthenticationRepository authenticationRepository;

	public LoginService(AuthenticationRepository authenticationRepository) {
		super();
		this.authenticationRepository = authenticationRepository;
	}
	
//	@Transactional
//	public 
	
	
}
