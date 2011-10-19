package customsSystem.util;

public class Utilities {

	
	/**
	 *  Private constructor so you can not create this object
	 */
	private Utilities () { 
	}
	
	
	public static boolean isWordFromDigits (String word) {
		for ( char c : word.toCharArray() ) {
	        if (! Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	public static boolean isWordFromLetters (String word) {
		for ( char c : word.toCharArray() ) {
			if (! Character.isLetter(c)) return false;
		}
		return true;
	}
	
	/*
	 * In future i'll add more methods in this class
	 */
}
