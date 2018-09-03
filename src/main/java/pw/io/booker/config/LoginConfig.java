package pw.io.booker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pw.io.booker.repo.AuthenticationRepository;
import pw.io.booker.repo.CustomerRepository;
import pw.io.booker.service.LoginService;
import pw.io.booker.util.TokenCreator;

@Configuration
public class LoginConfig {

	@Bean
	public LoginService loginService(AuthenticationRepository authenticationRepository, CustomerRepository customerRepository ,
			TokenCreator tokenCreator) {
		return new LoginService(authenticationRepository, customerRepository, tokenCreator);
	}
	
	@Bean
	public TokenCreator tokenCreator() {
		return new TokenCreator();
	}
	
}
