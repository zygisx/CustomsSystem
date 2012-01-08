package customsSystem.exceptions;
/**
 * Exception for null argument.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class CustomsNullArgumentException extends CustomsIllegalArgumentException {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 3860888770992476618L;
	/**
	 * Exception constructor.
	 * @param message exception massage.
	 */
	public CustomsNullArgumentException(String message) {
		super(message);
	}

	
	
}
