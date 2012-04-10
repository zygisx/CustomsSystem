package customsSystem.exceptions;
/**
 * Exception for wrong officer.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class CustomsUnknownOfficerException extends CustomsException {

	
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = -545439259934112218L;
	/**
	 * Exception constructor.
	 * @param message exception massage.
	 */
	public CustomsUnknownOfficerException(String message) {
		super(message);
	}
}
