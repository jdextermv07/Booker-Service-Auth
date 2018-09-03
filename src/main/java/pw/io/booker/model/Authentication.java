package pw.io.booker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Authentication {

	@Id
	private int AuthenticationId;
	@OneToOne
	private Customer customer;
	private int token;
	public int getAuthenticationId() {
		return AuthenticationId;
	}
	public void setAuthenticationId(int authenticationId) {
		AuthenticationId = authenticationId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	
	
	
}
