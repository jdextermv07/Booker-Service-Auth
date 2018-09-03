package pw.io.booker.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;

public interface AuthenticationRepository extends PagingAndSortingRepository<Authentication, Integer>{

	public Object findByToken(String token);
	
	
	
}
