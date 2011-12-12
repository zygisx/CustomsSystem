package customsSystem;

import java.util.ArrayList;

import customsSystem.exceptions.*;
import customsSystem.persons.*;
import customsSystem.util.Validable;
import customsSystem.util.ValidationResults;

/* class can be extended so it isn't marked as final */
/**
 * Class contains information about vehicle
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public class Vehicle implements Validable, Cloneable {
	

	/* types of vehicle */
	/**
	 * Enumeration contains vehicle types
	 * @author Žygimntas Gatelis
	 * 
	 */
	public enum VehicleType {
		/**
		 * Vehicle type is motorcycle.
		 */
		MOTORCYCLE,
		/**
		 * Vehicle type is car.
		 */
		CAR,
		/**
		 * Vehicle type is van.
		 */
		VAN,
		/**
		 * Vehicle type is truck.
		 */
		TRUCK,
		/**
		 * Vehicle type is bus.
		 */
		BUS,
		/**
		 * Vehicle type is minibus.
		 */
		MINIBUS,
		/**
		 * Vehicle type is not listed in this enumeration.
		 */
		OTHER
	}
	
	private VehicleDriver driver;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	
	
	private int weight = 0;	 		/* Weight in kilos. By default weight is 0 kg */  
	private String vehicleNumber = null;
	private String cargoDescription = null;		/* Short description of goods in vehicle */
	private VehicleType type;		/* car type moto, car, truck, etc. */
	
	/**
	 * Constructs Vehicle object.
	 * @param vehicleNumber numbers of this vehicle.
	 * @param driver driver of this vehicle
	 * @throws CustomsIllegalArgumentException if one or both argument is <code>null</code>
	 */
	public Vehicle(String vehicleNumber, VehicleDriver driver) 
			throws CustomsIllegalArgumentException {
		this(vehicleNumber, driver, VehicleType.OTHER, 0);
	}
	
	/**
	 * Constructs Vehicle object.
	 * @param vehicleNumber numbers of this vehicle.
	 * @param driver driver of this vehicle
	 * @param type type of this vehicle
	 * @param weight weight of this vehicle
	 * @throws CustomsIllegalArgumentException if one or both argument is <code>null</code> or
	 * <code>weight < 0</code>.
	 */
	public Vehicle(String vehicleNumber, VehicleDriver driver, VehicleType type, int weight) 
			throws CustomsIllegalArgumentException {  /* setWeight throws CustomIllegalArgumentException */
		if (vehicleNumber == null || driver == null)
			throw new CustomsNullArgumentException("Null argument.");	
		this.driver = driver;
		this.vehicleNumber = vehicleNumber; 
		this.setType(type);
		this.setWeight(weight);
	}

	/**
	 * Returns enumeration value of vehicle type.
	 * @return vehicle type.
	 */
	public VehicleType getType() {
		return this.type;
	}
	
	// exception nereikia nes leidziu paduoti null
	/**
	 * Set vehicle type.
	 * @param type enumeration {@link VehicleType} value.
	 */
	public void setType(VehicleType type) {
		if (type != null)
			this.type = type;
		else
			this.type = VehicleType.OTHER;
	}
	
	/**
	 * Returns weight of vehicle.
	 * @return weight of vehicle.
	 */
	public int getWeight() {
		return this.weight;
	}

	/**
	 * Set vehicle weight.
	 * @param weight vehicle weight
	 * @throws CustomsIllegalArgumentException if <code>weight < 0</code>
	 */
	public void setWeight(int weight) 
			throws CustomsIllegalArgumentException {
		if (weight < 0)
			throw new CustomsIllegalArgumentException("Illegal argument");
		this.weight = weight;
	}
	
	/**
	 * Returns driver of vehicle
	 * @return driver of vehicle
	 */
	public VehicleDriver getDriver() {
		return this.driver;
	}
	
	/**
	 * Returns number of this vehicle
	 * @return number of this vehicle
	 */
	public String getVehicleNumber() {
		return this.vehicleNumber;
	}
	
	/**
	 * Returns cargo description.
	 * @return cargo description.
	 */
	public String getCargoDescription() {
		return this.cargoDescription;
	}
	
	/* description can be null */
	/**
	 * Set cargo description.
	 * @param cargoDescription String object of cargo description.
	 */
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}
	
	/**
	 * Returns number of passengers in this vehicle.
	 * @return number of passengers in this vehicle.
	 */
	public int getNumOfPassengers() {
		return this.passengers.size();
	}
	
	/* Methods to work with ArrayList */
	/**
	 *  Appends passenger to end of passengers list.
	 * @param passenger passenger in this vehicle
	 * @throws CustomsNullArgumentException if passenger is null
	 */
	public void addPassenger(Passenger passenger) 
			throws CustomsNullArgumentException {
		if (passenger == null)	
			throw new CustomsNullArgumentException("Null argument.");
		this.passengers.add(passenger);
	}
	
	/**
	 * Returns the {@link Passenger} at the specified position in passengers list.
	 * @param index index of the passenger to return
	 * @return passenger at the specified position in passengers list
	 * @throws CustomsIllegalArgumentException if the index is out of range 
	 * (<code>index < 0 || index > getOfficersNum()</code>).
	 */
	public Passenger getPassenger(int index) throws CustomsIllegalArgumentException { 
		if (index < 0 || index >= this.getNumOfPassengers() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.passengers.get(index); 
	}
	
	/** 
	 * Method help to control data correctness. It set warnings of 
	 * inspections data in Validation result object.
	 * @param results in this object is set all warnings.
	 * @see customsSystem.util.Validable#validate(customsSystem.util.ValidationResults)
	 */
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
	
	/**
	 * Returns vehicle information in String
	 * @return vehicle information in String
	 */
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
	
	/**
	 * Returns vehicle clone.
	 * @return vehicle clone.
	 */
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
