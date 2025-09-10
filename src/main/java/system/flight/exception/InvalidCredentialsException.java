package system.flight.exception;

public class InvalidCredentialsException extends RuntimeException {
    private static final long serialVersionUID = 2L;

	public InvalidCredentialsException(String message) {
        super(message);
    }
}
