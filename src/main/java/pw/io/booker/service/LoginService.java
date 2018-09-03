package pw.io.booker.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;
import pw.io.booker.repo.AuthenticationRepository;
import pw.io.booker.repo.CustomerRepository;
import pw.io.booker.util.TokenCreator;

public class LoginService {

	private AuthenticationRepository authenticationRepository;
	private CustomerRepository customerRepository;
	private TokenCreator tokenCreator;
	
	public LoginService(AuthenticationRepository authenticationRepository, CustomerRepository customerRepository,
			TokenCreator tokenCreator) {
		super();
		this.authenticationRepository = authenticationRepository;
		this.customerRepository = customerRepository;
		this.tokenCreator = tokenCreator;
	}
	
	public String generateToken(Customer customer) {
		Customer customerTemp = customerRepository.findByUsernameAndPassword(
				customer.getUsername(), customer.getPassword());
		String token = tokenCreator.encode(customerTemp);
		Authentication auth = new Authentication();
		auth.setToken(token);
		auth.setCustomer(customerTemp);
		authenticationRepository.save(auth);
			
		return token;
	}
	
	public void deleteToken(String token) {
		Authentication authentic = (Authentication) authenticationRepository.findByToken(token);
		authenticationRepository.deleteById(authentic.getAuthenticationId());
	}

	
	
	
	
}
