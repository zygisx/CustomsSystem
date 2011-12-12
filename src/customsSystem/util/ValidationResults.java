package customsSystem.util;

import java.util.ArrayList;
import java.util.List;

/*
 * Taigi pakeiciau klase, dabar visose klasese patikrinimas (tikroji validacija) vyks konstruktoriuose ir setteriuose, 
 * ta prasme nebus taip kad pirma sukuriu objekta tik po to validuoju.
 * Dabar validate metodas prabeks tik pro tam tikrus specifinius laukus ir ValidatioResults saugos perspejimus del galimmu klaidu
 * pavyzdziui del datos jei data rytojus arba pakankamai toli nuo siandien tai perspesim vartotoja kad galbut jis suklydo del kalidos, taciau
 * jokiu budu negalim neleisti tokios datos nustatyti nes galbut vartotojui butent to ir reikejo.
 * Vienu zodziu validable interface pades surasti galimus specifinius netikslumus atributuose.
 */
/**
 * Class which helps validating data
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class ValidationResults {
	
	private final List<String> warnings = new ArrayList<String>();
	
	/**
	 * Empty constructos.
	 */
	public ValidationResults() {
	}
	
	/**
	 * Returns <code>true</code> if class contains any warnings, <code>false</code> otherwise.
	 * @return  <code>true</code> if class contains any warnings, <code>false</code> otherwise.
	 */
	public boolean hasWarnings() {
		return warnings.size() > 0;
	}
	
	/**
	 * Clear warning list.
	 */
	public void clearWarnings() {
		warnings.clear();
	}
	
	@Override
	public String toString() {
		return "Warnings: " + warnings;
	}

	/**
	 * Returns all warnings in list.
	 * @return all warnings in list.
	 */
	public List<String> getWarnings() {
		return warnings;
	}
}
