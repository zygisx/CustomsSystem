package customsSystem;

import java.util.ArrayList;

import customsSystem.persons.*;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;


public class Vehicle implements Validable {
	
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
	private int numOfPassengers = 0;
	private String vehicleNumber = null;
	private String cargoDescription = null;		/* Short description of goods in vehicle */
	private VehicleType type;		/* car type moto, car, truck, etc. */
	
	
	public Vehicle(String vehicleNumber, VehicleDriver driver) {
		this(vehicleNumber, driver, VehicleType.OTHER, 0);
	}
	
	public Vehicle(String vehicleNumber, VehicleDriver driver, VehicleType type, int weight) {
		if (vehicleNumber != null)
			this.vehicleNumber = vehicleNumber;  /* in future exception will be thrown */
		if (driver != null)
			this.driver = driver;
		setType(type);
		setWeight(weight);
	}

	public VehicleType getType() {
		return type;
	}
	
	// ToDo exception
	public void setType(VehicleType type) {
		if (type != null)
			this.type = type;
		else
			this.type = VehicleType.OTHER;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0)
			this.weight = weight;
	}

	public VehicleDriver getDriver() {
		return driver;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getCargoDescription() {
		return cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}
	
	/*
	 * Methods to work with ArrayList
	 * 
	 */
	public void addPassenger(Passenger passenger) {
		numOfPassengers++;
		if (passenger != null)			// ToDo exception
			passengers.add(passenger);
	}
	
	public Passenger getPassenger(int index) {
		if ( index > 0 && index < passengers.size() )
			return passengers.get(index);
		return null;
	}
	
	public Passenger getPassenger() {
		if (! passengers.isEmpty() )
			return passengers.get(0);
		return null;
	}
	
	public void removeOfficer (Passenger passenger) {
		numOfPassengers--;
		passengers.remove(passenger);
	}
	
	@Override
	public void validate(ValidationResults results) {
		if (this.driver == null) 
			results.getErrors().add("Driver not set");
		else
			this.driver.validate(results);
		if (this.passengers == null) 
			results.getErrors().add("Passengers not set");
		else {
			for (Passenger p : passengers)
				p.validate(results);
		}
		if (this.weight <= 0) 
			results.getErrors().add("Wrong weight");
		if (this.vehicleNumber == null || this.vehicleNumber.length() < 1) 
			results.getErrors().add("Wrong vehicle number");
		
		
	}
	
	@Override
	public String toString() {
		return "Vehicle type: " + type + "\n"
			+ "Vehicle No.: " + vehicleNumber + "\n"
			+ "Driver:\n " + driver.getName() + " " + driver.getSurname()
			+ "Weight: " + weight + " kg\n"
			+ "Number of passengers: " + numOfPassengers + "\n"
			/* only if cargo description is not empty i print it */
			+ ( (cargoDescription != null) ? "Cargo description: " + cargoDescription + "\n" : "" ); 
	}

	


}
