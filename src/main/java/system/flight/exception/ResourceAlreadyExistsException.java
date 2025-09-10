package system.flight.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    private static final long serialVersionUID = 3L;

	public ResourceAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s with %s '%s' already exists", resourceName, fieldName, fieldValue));
    }
}