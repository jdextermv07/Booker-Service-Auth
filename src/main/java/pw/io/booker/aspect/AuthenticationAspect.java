package pw.io.booker.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import pw.io.booker.repo.AuthenticationRepository;

@Aspect
@Service
public class AuthenticationAspect {

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
			return new RuntimeException("Access Denied");
		}
		
		if(authenticationRepository.findByToken(token) == null) {
			return new RuntimeException("Access Denied");
		}
		try {
			tempObject = joinPoint.proceed();
		} catch (Throwable e) {
			return new RuntimeException();
		}
		System.out.println("This is the end of the method");
		return tempObject;
	}
	
}
