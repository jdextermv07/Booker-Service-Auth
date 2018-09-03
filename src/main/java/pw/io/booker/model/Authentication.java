package pw.io.booker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Authentication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AuthenticationId;
	@OneToOne
	private Customer customer;
	private String token;
	
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
