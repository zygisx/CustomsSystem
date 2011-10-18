package customsSystem;

import java.util.ArrayList;

import customsSystem.persons.Person;


public class Vehicle {
	
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
	
	private Person driver;
	private ArrayList<Person> passengers = new ArrayList<Person>();
	
	
	private int weight = 0;	 		/* Weight in kilos. By default weight is 0 kg */  
	private int numOfPassengers = 0;
	private String vehicleNumber = null;
	private String cargoDescription = null;		/* Short description of goods in vehicle */
	private VehicleType type;		/* car type moto, car, truck, etc. */
	
	
	public Vehicle(String vehicleNumber, Person driver) {
		this(vehicleNumber, driver, VehicleType.OTHER, 0);
	}
	
	public Vehicle(String vehicleNumber, Person driver, VehicleType type, int weight) {
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

	public Person getDriver() {
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
	public void addPassenger(Person passenger) {
		numOfPassengers++;
		if (passenger != null)			// ToDo exception
			passengers.add(passenger);
	}
	
	public Person getPassenger(int index) {
		if ( index > 0 && index < passengers.size() )
			return passengers.get(index);
		return null;
	}
	
	public Person getPassenger() {
		if (! passengers.isEmpty() )
			return passengers.get(0);
		return null;
	}
	
	public void removeOfficer (Person passenger) {
		numOfPassengers--;
		passengers.remove(passenger);
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
