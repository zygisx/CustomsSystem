package customsSystem.util;

/**
 * Class contains useful functions
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class Utilities {

	
	/**
	 * How long should be emplpoyee number.
	 */
	public static final byte EMPLOYEE_NUMBER_LENGTH = 5;
	
	
	/**
	 *  Private constructor so you can not create this object
	 */
	private Utilities () { 
	}
	
	
	/**
	 * Check if word contains only numbers.
	 * @param word value to check
	 * @return <code>true</code> if word contains only digits <code>false</code> otherwise.
	 */
	public static boolean isWordFromDigits (String word) {
		for ( char c : word.toCharArray() ) {
	        if (! Character.isDigit(c)) 
	        	return false;
	    }
	    return true;
	}
	/**
	 * Check if word contains only letters.
	 * @param word value to check
	 * @return <code>true</code> if word contains only letters <code>false</code> otherwise.
	 */
	public static boolean isWordFromLetters (String word) {
		for ( char c : word.toCharArray() ) {
			if (! Character.isLetter(c)) 
				return false;
		}
		return true;
	}
	
	/*
	 * In future i'll add more methods in this class
	 */
}
