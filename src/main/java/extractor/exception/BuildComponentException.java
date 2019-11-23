package extractor.exception;

/**
 * @author jvinh
 */
public class BuildComponentException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = -8612300924227503644L;
    /**
     * Exception message
     */
    private String message;
    
    /**
     * Instanciates a new BuildComponentException
     * 
     * @param message the message
     */
    public BuildComponentException(String message) {
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
