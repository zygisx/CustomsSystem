


import customsSystem.*;
import customsSystem.CustomsOfficer.Experience;


public class Tester {

	public static void main (String args[]) {
		CustomsOfficer c1 = new CustomsOfficer("Jonas", "Petraitis", "123456", Experience.JUNIOR);
		CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevičius", "123458", Experience.HEAD);
		Vehicle v1 = new Vehicle("AVH020");
		
		Inspection i1 = new Inspection(c1, v1);
		i1.setDate();
		
		System.out.println(i1.toString());
		
		/*
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		*/
	}
}

/*

TIPS:
	pasirašyt klasei toString metoda 
	savybiu nedet, kaip ernio rukaliam
	emploee turi staza turi darbo nr ir t.t.
	
*/
	