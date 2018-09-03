package pw.io.booker.exception;

public class AuthenticationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final String userFriendlyMessage;
	
	public AuthenticationException(Exception e, String message) {
		super(e);
		this.userFriendlyMessage = message;
	}
	
	public AuthenticationException(Throwable e, String message) {
		super(e);
		this.userFriendlyMessage = message;
	}
	
	public AuthenticationException (String message) {
		this.userFriendlyMessage = message;
	}
	
	public String getUserFriendlyMessage(){
		return userFriendlyMessage;
	}
}
