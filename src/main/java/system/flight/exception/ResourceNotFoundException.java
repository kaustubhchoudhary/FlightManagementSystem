package system.flight.exception;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}