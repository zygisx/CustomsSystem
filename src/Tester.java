import customsSystem.*;
import customsSystem.CustomsOfficer.Experience;
import customsSystem.Vehicle.VehicleType;


public class Tester {

	public static void main (String args[]) {
		
		/*
		 * jau pazaidziau pirmoj uzduotį su objektų spausdinimu tai dabar uzkomentuoju tuos spausdinimu
		 * kad ekrane tiek daug nereikalingų dalykų nespausdint
		 * 
		 * dabar spausdinu sarasus objetu ir pan.
		 */
		// 7 officers
		CustomsOfficer c1 = new CustomsOfficer("Jonas", "Petraitis", "123456", Experience.JUNIOR);
		CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevičius", "123458", Experience.HEAD);
		CustomsOfficer c3 = new CustomsOfficer("Ilona", "Jusyte", "123459", Experience.TRAINEE);
		CustomsOfficer c4 = new CustomsOfficer("Rimas", "Brazauskas", "123460", Experience.TRAINEE);
		CustomsOfficer c5 = new CustomsOfficer("Jurgis", "Gatelis", "123461", Experience.TRAINEE);
		CustomsOfficer c6 = new CustomsOfficer("Jonas", "Petraitis", "123462", Experience.JUNIOR);
		CustomsOfficer c7 = new CustomsOfficer("Marija", "Jusyte", "123463", Experience.JUNIOR);
		
		// 3 vehicles
		Vehicle v1 = new Vehicle("AVH020", new Person("Jonas", "Jonaitis", "39110241458"));	
		Vehicle v2 = new Vehicle("A59585", new Person("Petras", "Jonikaitis", "36910250001"), VehicleType.VAN, 4500);
		Vehicle v3 = new Vehicle("A59583", new Person("Julius", "Jaunius", "36910250256"), VehicleType.TRUCK, 10000);
		
		v1.setType(VehicleType.CAR);
		v1.setWeight(1500);
		v1.setCargoDescription("Nepavojingas krovinys.");
		
		v2.setCargoDescription("Leistina tabako norma. Maistas. Buitiniai daiktai.");
		//System.out.println(c1);
		
		// 5 inspections
		Inspection i1 = new Inspection(c1, v2);
		i1.setDate();
		i1.setSuccessful(true);
		i1.setDescription("Sėkmingas pastikrinimas. Buvo naudojami šunys, ieškota tabako.");
		
		Inspection i2 = new Inspection(c2, v1);
		i2.setSuccessful(false);
		Inspection i3 = new Inspection(c3, v3);
		i3.setSuccessful(true);
		Inspection i4 = new Inspection(c5, v1);
		i4.setSuccessful(true);
		Inspection i5 = new Inspection(c1, v2);
		i5.setSuccessful(true);
		
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
		
		/* print */
		//System.out.println("----Sukuriami muitininkai ir transprto priemonės");
		//System.out.println("Pirmas muitininkas:\n" + c1);
		//System.out.println("Pirma transporto priemonė:\n" + v1);
		
		
		
		
		//System.out.println("----Sukuriamas patikrinimas");
		//System.out.println("PATIKRINIMO INFORMACIJA:\n" + i1);
	}
}
