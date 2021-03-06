package pw.io.booker.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import pw.io.booker.exception.AuthenticationException;
import pw.io.booker.repo.AuthenticationRepository;

@Aspect
@Service
public class AuthenticationAspect {

	Logger logger = Logger.getLogger(AuthenticationAspect.class);
	private AuthenticationRepository authenticationRepository;
	
	public AuthenticationAspect(AuthenticationRepository authenticationRepository) {
		super();
		this.authenticationRepository = authenticationRepository;
	}

	@Around("execution(* pw.io.booker.controller..* (..)) && args(token,..)")
	public Object authenAspect(ProceedingJoinPoint joinPoint, String token) {
		System.out.println("This is the start of the method");
		
		Object tempObject = null;
		
		if(token == null) {
			logger.error("An error occurred. Token is null.");
			return new AuthenticationException("Access Denied");
		}
		
		if(authenticationRepository.findByToken(token) == null) {
			logger.error("An error occurred. Token not found.");
			return new AuthenticationException("Access Denied");
		}
		try {
			tempObject = joinPoint.proceed();
		} catch (Throwable e) {
			logger.error("An error occurred" + e.getMessage());
			return new AuthenticationException("An error occurred");
		}
		System.out.println("This is the end of the method");
		return tempObject;
	}
	
}
