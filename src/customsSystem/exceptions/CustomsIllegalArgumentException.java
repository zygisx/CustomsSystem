package customsSystem.exceptions;
/**
 * Exception for illegal argument.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class CustomsIllegalArgumentException extends CustomsException {
	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8840865051573217787L;
	/**
	 * Exception constructor.
	 * @param message exception massage.
	 */
	public CustomsIllegalArgumentException(String message) {
		super(message);
	}

}

