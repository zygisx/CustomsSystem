import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.Vehicle;
import customsSystem.Vehicle.VehicleType;
import customsSystem.exceptions.CustomsEmptyListException;
import customsSystem.exceptions.CustomsException;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.exceptions.CustomsNullArgumentException;
import customsSystem.exceptions.CustomsUnknownOfficerException;
import customsSystem.persons.CustomsOfficer;
import customsSystem.persons.CustomsOfficer.Experience;
import customsSystem.persons.Passenger;
import customsSystem.persons.VehicleDriver;


import java.util.ArrayList;



public class Tester {

	public static void main (String args[]) {
		
		Customs customs = null, customsClone = null;
		
		try {
			
			// clone CustomsOfficer
			CustomsOfficer p = new CustomsOfficer("Jonas", "Jonaitis", "12345");
			CustomsOfficer pp = p.clone();
			pp.setExperience(Experience.HEAD);
			pp.setEmployeeNumber("1651315313841684");
		
			
			// clone Vehicle
			Vehicle v = new Vehicle("ABC526" ,new VehicleDriver("Jonas", "Jonukas", "5846846"));
			v.addPassenger(new Passenger("Indre", "Gatelyte", "35648618"));
			Vehicle vv = v.clone();
			vv.addPassenger(new Passenger("Zygis", "Gat", "695213"));
			vv.setType(VehicleType.CAR);
			
			// clone Inspection
			Inspection i = new Inspection(p, v);
			i.setDate(2011, 11, 20);
			Inspection ii = i.clone();
			ii.setDate();
			ii.getVehicle().setType(VehicleType.MOTORCYCLE);
			
			
			// creation of few more objects 
			CustomsOfficer c1 = new CustomsOfficer("Jonas", "Petraitis", "123456");
			CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevičius", "123458");
			CustomsOfficer c3 = new CustomsOfficer("Ilona", "Jusyte", "123459");
			
			Inspection i1 = new Inspection(c1, v);
			Inspection i2 = new Inspection(c2, v);
			Inspection i3 = new Inspection(c1, v);
			Inspection i4 = new Inspection(c2, v);
			Inspection i5 = new Inspection(c3, v);
			Inspection i6 = new Inspection(c1, v);
			
			// Customs 
			customs = new Customs("PL", "Lazdijų pasienio punktas.");
			customs.addOfficer(p);
			customs.addOfficer(c1);
			customs.addOfficer(c2);
			customs.addOfficer(c3);
			
			customs.addInspection(i);
			customs.addInspection(i);
			customs.addInspection(i1);
			customs.addInspection(i2);
			customs.addInspection(i3);
			customs.addInspection(i4);
			customs.addInspection(i5);
			customs.addInspection(i6);
			
			
			// clone customs
			customsClone = customs.clone();
		
		}
		catch (CustomsUnknownOfficerException ex) {
			System.out.println("Unknown officer: " + ex);
		}
		catch (CustomsNullArgumentException ex) {
			System.out.println("Null argument: " + ex);
		}
		catch (CustomsIllegalArgumentException ex) {
			System.out.println("Illegal argument: " + ex);
		}
		catch (CustomsEmptyListException ex) {
			System.out.println(ex);
		}
		catch (CustomsException ex) {
			System.out.println("Customs exception: " + ex);
		}
		
		// tikrinu ar referencai skirtingi
		System.out.println("AR NUKLONUOTA MUITINE RODO I KITA ATMINTIES VIETA :\n"
			+ ( customs == customsClone));
		
		for (int i = 0; i < customs.getInspectionsNum(); i++) {
			try {
				if (customs.getInspection(i) == customsClone.getInspection(i) )
					System.out.println("FAIL. Klonavimas veikia blogai, rodoma i ta pacia atminties vieta.");
				System.out.println(i);
			} catch (CustomsIllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < customsClone.getOfficersNum(); i++) {
			try {
				if (customs.getOfficer(i).equals(customsClone.getOfficer(i)) )
					System.out.println(customs.getOfficer(i));
			} catch (CustomsIllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		
		/* parodau jog klone kazka pakeitus nepasikeis originalas */
		System.out.println("\nPries pakeitima:\nMuitine turi " + customs.getOfficersNum() + " muitininkus" +
				"\nKlonuota muitine turi " + customsClone.getOfficersNum() + " muitininkus");
		
		System.out.println("\nIsmetu du muitininkus is klonuotos muitines..");
		
		try {
			customsClone.removeOfficer(1);
			customsClone.removeOfficer(1);
		} catch (CustomsIllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
		
		System.out.println("\nPo pakeitimo:\nMuitine turi " + customs.getOfficersNum() + " muitininkus" +
				"\nKlonuota muitine turi " + customsClone.getOfficersNum() + " muitininkus");
		
		
		/* dar karta */
		try {
			System.out.println("\n\nKitas:\nPries pakeitima:\nMuitines pirmo patikrinimo darta: " + customs.getInspection().getDateAsString() 
					+ "\nKlonuotos muitines pirmo patikrinimo data: " + customsClone.getInspection().getDateAsString() );
		
		
			System.out.println("Pakeiciu pirmo patikrinimo data i 2011 12 31");
			customs.getInspection().setDate(2011, 11, 31);
		
		
			System.out.println("Po pakeitimo:\nMuitines pirmo patikrinimo darta: " + customs.getInspection().getDateAsString() 
					+ "\nKlonuotos muitines pirmo patikrinimo data: " + customsClone.getInspection().getDateAsString() );
		} catch (CustomsEmptyListException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n\nGAUDAU TYCIA PADARYTUS EXCEPTIONUS:\n");
		try {
			customs.removeOfficer(99);
			
		}
		catch (CustomsIllegalArgumentException ex) {
			System.out.println(ex);
		} 
		try {
			customs.getOfficer().setEmployeeNumber(null);
		}
		catch (CustomsEmptyListException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} catch (CustomsIllegalArgumentException e) {
			System.out.println(e);
			//e.printStackTrace();
		}
		
		
		
		
		/****************************************************************************************************
		 * SENAS KODAS:
		 
		 
		 
		String[] names = {"Jonas", "Petras", "Juozas", "Ilona", "Agne", "Jurgis", "Justas", "Rimas", "Marija",
				"Julius", "Daiva", "Marius", "Evaldas" 
		};
		String[] surnames = {"Petraitis", "Jonaitis", "Sinkevicius", "Jusyte", "Dirmaite", "Mikutavičius", 
				"Gatelis", "Brazauskas", "Sukeviciene", "Pauliskas", "Kairiene", "Slepetys", "Gudynas"
		};
		String[] id = {"12345", "56894", "45647", "45647", "15975", "45694", "15631", "45668",
				"75669", "41564", "54654", "45468", "45687"
		};
		
		// Polimorfizmo demonstracija 
		ArrayList<Person> p = new ArrayList<Person>();

		// sukuriu 4 Passenger
		for (int i = 0; i < 4; i++)
			p.add(new Passenger(names[i], surnames[i], id[i]));
		// sukuriu dar 5 VehicleDriver
		for (int i = 4; i < 9; i++)
			p.add(new VehicleDriver(names[i], surnames[i], id[i]));
		// sukuriu 4 CustomsOfficer
		for (int i = 9; i < 13; i++)
			p.add(new CustomsOfficer(names[i], surnames[i], id[i]));
		
		System.out.println("Atspausdinu visus CustomsOfficer esancius Persons sarase: ");
		for (Person p0 : p) {
			if (p0 instanceof CustomsOfficer) {
				((CustomsOfficer) p0).setEmployeeNumber("25895"); // bet koki employee numeri nustatau
				System.out.println(p0);
			}
		}
		
		System.out.println("\n\nVisiems Passenger ir VehicleDriver nustatau tautybe \"LT\"");
		for (Person p0 : p) {
			if (p0 instanceof Passenger ) {  // kadangi VehicleDriver extendina Passenger tai uztenka instanceof Passenger
				((Passenger) p0).setNationality("LT");
				System.out.println(p0);
			}
		}
		
		// 3 vehicles sukurimas
		Vehicle v1 = new Vehicle("AVH020", new VehicleDriver("Jonas", "Jonaitis", "39110241458"));	
		Vehicle v2 = new Vehicle("A59585", new VehicleDriver("Petras", "Jonikaitis", "36910250001"), VehicleType.VAN, 4500);
		Vehicle v3 = new Vehicle("A59583", new VehicleDriver("Julius", "Jaunius", "36910250256"), VehicleType.TRUCK, 10000);
		
		v1.setType(VehicleType.CAR);
		v1.setWeight(1500);
		v1.setCargoDescription("Nepavojingas krovinys.");
		
		v2.setCargoDescription("Leistina tabako norma. Maistas. Buitiniai daiktai.");
		
		
		*/  //END
		
		
		
		/* *******************************************************************************************
		*******--- Uzkomentuoju sena koda -----------------------
		// 7 officers
		CustomsOfficer c1 = new CustomsOfficer("Jonas", "Petraitis", "123456", Experience.JUNIOR);
		CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevičius", "123458", Experdiience.HEAD);
		CustomsOfficer c3 = new CustomsOfficer("Ilona", "Jusyte", "123459", Experience.TRAINEE);
		CustomsOfficer c4 = new CustomsOfficer("Rimas", "Brazauskas", "123460", Experience.TRAINEE);
		CustomsOfficer c5 = new CustomsOfficer("Jurgis", "Gatelis", "123461", Experience.TRAINEE);
		CustomsOfficer c6 = new CustomsOfficer("Jonas", "Petraitis", "123462", Experience.JUNIOR);
		CustomsOfficer c7 = new CustomsOfficer("Marija", "Jusyte", "123463", Experience.JUNIOR);
		
		// 3 vehicles
		Vehicle v1 = new Vehicle("AVH020", new VehicleDriver("Jonas", "Jonaitis", "39110241458"));	
		Vehicle v2 = new Vehicle("A59585", new VehicleDriver("Petras", "Jonikaitis", "36910250001"), VehicleType.VAN, 4500);
		Vehicle v3 = new Vehicle("A59583", new VehicleDriver("Julius", "Jaunius", "36910250256"), VehicleType.TRUCK, 10000);
		
		v1.setType(VehicleType.CAR);
		v1.setWeight(1500);
		v1.setCargoDescription("Nepavojingas krovinys.");
		
		v2.setCargoDescription("Leistina tabako norma. Maistas. Buitiniai daiktai.");
		//System.out.println(c1);
		
		// 11 inspections
		Inspection i1 = new Inspection(c4, v2);
		i1.setDate();
		i1.setSuccessful(true);
		i1.setDescription("Sėkmingas pastikrinimas. Buvo naudojami šunys, ieškota tabako.");
		
		Inspection i2 = new Inspection(c4, v1);
		i2.setSuccessful(false);
		Inspection i3 = new Inspection(c4, v3);
		i3.setSuccessful(true);
		Inspection i4 = new Inspection(c2, v1);
		i4.setSuccessful(true);
		Inspection i5 = new Inspection(c4, v2);
		i5.setSuccessful(true);
		Inspection i6 = new Inspection(c4, v3);
		i6.setSuccessful(true);
		Inspection i7 = new Inspection(c4, v2);
		i7.setSuccessful(true);
		Inspection i8 = new Inspection(c4, v1);
		i8.setSuccessful(true);
		Inspection i9 = new Inspection(c4, v1);
		i9.setSuccessful(true);
		Inspection i10 = new Inspection(c4, v2);
		i10.setSuccessful(true);
		Inspection i11 = new Inspection(c4, v3);
		i11.setSuccessful(true);
		
		
		Customs c = new Customs("PL", "Lazdijų pasienio punktas.");
		
		c.addOfficer(c1);
		c.addOfficer(c2);
		c.addOfficer(c3);
		c.addOfficer(c4);
		c.addOfficer(c5);
		c.addOfficer(c6);
		c.addOfficer(c7);
		
		c.addInspection(i1);
		c.addInspection(i2);
		c.addInspection(i3);
		c.addInspection(i4);
		c.addInspection(i5);
		c.addInspection(i6);
		c.addInspection(i7);
		c.addInspection(i8);
		c.addInspection(i9);
		c.addInspection(i10);
		c.addInspection(i11);
		 
		System.out.println("Muitines Informacija:\n" + c);
		
		
		System.out.println("\nAtspausdinsiu visus pareigunus kurie yra tik apmokomi (trainee):\n");
		for (int i = 0; i < c.getOfficersNum(); i++) {
			if (c.getOfficer(i).getExperience() == Experience.TRAINEE) {
				System.out.println("Vardas: " + c.getOfficer(i).getName() + " Pavarde: " + c.getOfficer(i).getSurname());
			}
		}
		
		System.out.println("\n\nAtspausdinti visus patikrinimus kuriuose tikrino Jonas Petraitis: ");
		for (int i = 0; i < c.getInspectionsNum(); i++) {
			CustomsOfficer p = c.getInspection(i).getOfficer();
			if (p.getName().equals("Jonas") && p.getSurname().equals("Petraitis")) {
				System.out.println(c.getInspection(i));
			}
		}
		
		System.out.println("\nAtspausinu visus darbuotojus:\n");
		for (int i = 0; i < c.getOfficersNum(); i++) {
			System.out.println((i+1) +". " + c.getOfficer(i) );
		}
		
		System.out.println("\nPanikinkim darbuotoja Ilona Jusyte\n");
		for (int i = 0; i < c.getOfficersNum(); i++) {
			if (c.getOfficer(i).getName().equalsIgnoreCase("Ilona") && c.getOfficer(i).getSurname().equalsIgnoreCase("Jusyte")) {
				c.removeOfficer(i);
			}
		}
		
		System.out.println("\nVel Atspausdinu visus pareigūnus:\n");
		for (int i = 0; i < c.getOfficersNum(); i++) {
			System.out.println((i+1) +". " + c.getOfficer(i) );
		}
		*/
				
				
				
		/*
		System.out.println("-----------------Dėstytojo užduotis-------------------------");
		for (int i = 0; i < c.getOfficersNum(); i++) {
			int count = 0;
			
			for (int j = 0; j < c.getInspectionsNum(); j++) {
				if ( c.getOfficer(i).equals(c.getInspection(j).getOfficer()) )
					count = count + 1;		
			}
			if (count >= 10) 
				System.out.println(c.getOfficer(i));
		}
		*/
		
		
		
		/* print */
		//System.out.println("----Sukuriami muitininkai ir transprto priemonės");
		//System.out.println("Pirmas muitininkas:\n" + c1);
		//System.out.println("Pirma transporto priemonė:\n" + v1);
		
		
		
		
		//System.out.println("----Sukuriamas patikrinimas");
		//System.out.println("PATIKRINIMO INFORMACIJA:\n" + i1);
	}
}
