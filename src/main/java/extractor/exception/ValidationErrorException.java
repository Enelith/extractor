package extractor.exception;

/**
 * @author jvinh
 */
public class ValidationErrorException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 4300036379163146575L;
    
    /**
     * Exception message
     */
    private String message;
    
    /**
     * Instanciates a new validation error exception
     * 
     * @param message the message
     */
    public ValidationErrorException(String message) {
	super();
	this.message = message;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
	return message;
    }
    
    /**
     * Set the message
     * 
     * @param message the new message
     */
    public void setMessage(String message) {
	this.message = message;
    }
}
