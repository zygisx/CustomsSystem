package customsSystem.exceptions;
/**
 * Exception for null argument.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class CustomsEmptyListException extends CustomsException {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -2528518573618376425L;
	/**
	 * Exception constructor.
	 * @param message exception massage.
	 */
	public CustomsEmptyListException(String message) {
		super(message);
	}

}
