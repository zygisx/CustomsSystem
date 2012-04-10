package customsSystem.exceptions;

/**
 * Abstract Exception.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public abstract class CustomsException extends Exception {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 5085700967692359197L;

	/**
	 * Exception constructor.
	 * @param message exception massage.
	 */
	public CustomsException(String message) {
		super(message);
	}
	
	
	
	
}
