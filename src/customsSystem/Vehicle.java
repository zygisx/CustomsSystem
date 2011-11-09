package customsSystem;

import java.util.ArrayList;

import customsSystem.exceptions.*;
import customsSystem.persons.*;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;

/* class can be extended so it isn't marked as final */
public class Vehicle implements Validable, Cloneable {
	

	/* types of vehicle */
	public enum VehicleType {
		MOTORCYCLE,
		CAR,
		VAN,
		TRUCK,
		BUS,
		MINIBUS,
		OTHER
	}
	
	private VehicleDriver driver;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	
	private int weight = 0;	 		/* Weight in kilos. By default weight is 0 kg */  
	private String vehicleNumber = null;
	private String cargoDescription = null;		/* Short description of goods in vehicle */
	private VehicleType type;		/* car type moto, car, truck, etc. */
	
	
	public Vehicle(String vehicleNumber, VehicleDriver driver) 
			throws CustomsIllegalArgumentException {
		this(vehicleNumber, driver, VehicleType.OTHER, 0);
	}
	
	public Vehicle(String vehicleNumber, VehicleDriver driver, VehicleType type, int weight) 
			throws CustomsIllegalArgumentException {  /* setWeight throws CustomIllegalArgumentException */
		if (vehicleNumber == null || driver == null)
			throw new CustomsNullArgumentException("Null argument.");	
		this.driver = driver;
		this.vehicleNumber = vehicleNumber; 
		this.setType(type);
		this.setWeight(weight);
	}

	public VehicleType getType() {
		return this.type;
	}
	
	// exception nereikia nes leidziu paduoti null
	public void setType(VehicleType type) {
		if (type != null)
			this.type = type;
		else
			this.type = VehicleType.OTHER;
	}

	public int getWeight() {
		return this.weight;
	}

	
	public void setWeight(int weight) 
			throws CustomsIllegalArgumentException {
		if (weight < 0)
			throw new CustomsIllegalArgumentException("Illegal argument");
		this.weight = weight;
	}

	public VehicleDriver getDriver() {
		return this.driver;
	}
	
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}

	public String getCargoDescription() {
		return this.cargoDescription;
	}
	
	/* description can be null */
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public int getNumOfPassengers() {
		return this.passengers.size();
	}
	
	/*
	 * Methods to work with ArrayList
	 * 
	 */
	public void addPassenger(Passenger passenger) 
			throws CustomsNullArgumentException {
		if (passenger == null)	
			throw new CustomsNullArgumentException("Null argument.");
		this.passengers.add(passenger);
	}
	
	public Passenger getPassenger(int index) throws CustomsIllegalArgumentException { 
		if (index < 0 || index >= this.getNumOfPassengers() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.passengers.get(index); 
	}
	
	@Override
	public void validate(ValidationResults results) {
		/*	paprastai daugelyje saliu numeris susideda 
			is 6 ir daugiau simboliu, taciau buna vardiniu ir kitokiu todel negalima vienareiksmiskai uzdrausti tokiu 
			numeriu ivedino, vartotojas yra tik perspejamas del galimai blogai ivesto numerio
		 */
		if (this.vehicleNumber.length() < 6) {
			results.getWarnings().add("Posibly vehicle number to short");  
		}
	}
	
	@Override
	public String toString() {
		return "Vehicle type: " + this.type + "\n"
			+ "Vehicle No.: " + this.vehicleNumber + "\n"
			+ "Driver:\n " + this.driver.getName() + " " + this.driver.getSurname() +"\n"
			+ "Weight: " + this.weight + " kg\n"
			+ "Number of passengers: " + this.getNumOfPassengers() + "\n"
			/* only if cargo description is not empty i print it */
			+ ( (cargoDescription != null) ? "Cargo description: " + this.cargoDescription + "\n" : "" ); 
	}
	
	@Override
	public Vehicle clone() {
		Vehicle result;
		try { 
			result = (Vehicle) super.clone();
			
			result.driver = (VehicleDriver) driver.clone();
			result.passengers = (ArrayList<Passenger>) passengers.clone();
			for (Passenger p : result.passengers) {
				p = p.clone();
			}
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
		return result;
	}

	


}
