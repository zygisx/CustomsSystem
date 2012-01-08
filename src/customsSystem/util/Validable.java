package customsSystem.util;

/**
 * Interface for validating data
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public interface Validable {
	
	/**
	 * Function to validate data using useful class {@link ValidationResults}.
	 * @param results object which helps validate data.
	 */
	public void validate(ValidationResults results);
}
