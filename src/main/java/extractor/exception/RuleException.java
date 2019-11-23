package extractor.exception;

/**
 * @author jvinh
 */
public class RuleException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1814164128946603476L;

    /**
     * Exception message
     */
    private String message;
    
    /**
     * Instanciates a new rule exception
     * 
     * @param message the message
     */
    public RuleException(String message) {
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
