package se.lemv.exceptions;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 7483348304785315139L;

	public RepositoryException(String message, Exception exception) {
		super(message, exception);
	}
	
	public RepositoryException(String message) {
		super(message);
	}
}
