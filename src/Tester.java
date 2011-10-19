import java.util.ArrayList;

import customsSystem.*;
import customsSystem.Vehicle.VehicleType;
import customsSystem.persons.*;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;



public class Tester {

	public static void main (String args[]) {
		
		/*
		Naudoju masyvus kad lengviau butu galima sukurti daug objektu.
		*/
		String[] names = {"Jonas", "Petras", "Juozas", "Ilona", "Agne", "Jurgis", "Justas", "Rimas", "Marija",
				"Julius", "Daiva", "Marius", "Evaldas" 
		};
		String[] surnames = {"Petraitis", "Jonaitis", "Sinkevicius", "Jusyte", "Dirmaite", "Mikutavičius", 
				"Gatelis", "Brazauskas", "Sukeviciene", "Pauliskas", "Kairiene", "Slepetys", "Gudynas"
		};
		String[] id = {"12345", "56894", "45647", "45647", "15975", "45694", "15631", "45668",
				"75669", "41564", "54654", "45468", "45687"
		};
		
		/* Polimorfizmo demonstracija */
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
		
		System.out.println("\n\nInterface Validable demostravimas: ");
		System.out.println("Visu Person saraso objektu lauku patikrinimas ir klaidu log atspausdinimas");
		
		ValidationResults v = new ValidationResults();
		ArrayList<Validable> list = new ArrayList<Validable>(p);
		list.add(v1); list.add(v2); list.add(v3);
		
		for (Validable v0 : list) {
			v0.validate(v);
		}
		
		System.out.println(v);
	
		
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
