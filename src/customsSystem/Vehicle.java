package customsSystem;

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
	
	/* 
	 * Kol kas neįdėta vairuotojo ir keleivių informacija. Kitoje užduotyje planuoju sukurti klasę Person
	 * kurioje būtų visa reikalinga informacija. Kadangi ši užduotis reikalauja tik 4 pagrindinių klasių
	 * todėl ir nėra informacijos apie transporto priemonėje esančius žmones, bei jos vairuotoją.
	 */
	
	/* ---Not yet implemented ----
	private Person driver;
	private ArrayList<Person> passengers;
	*/
	
	private int weight = 0;	 		/* Weight in kilos. By default weight is 0 kg */  
	private int numOfPassengers = 0;
	private String vehicleNumber = null;
	private String cargoDescription = null;		/* Short description of goods in vehicle */
	private VehicleType type;		/* car type moto, car, truck, etc. */
	
	
	public Vehicle(String vehicleNumber) {
		this(VehicleType.OTHER, 0, vehicleNumber);
	}
	
	public Vehicle(VehicleType type, int weight, String vehicleNumber) {
		this.type = type;
		if (weight > 0) 
			this.weight = weight;
		if (vehicleNumber != null)
			this.vehicleNumber = vehicleNumber;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0)
			this.weight = weight;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getCargoDescription() {
		return cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public void setNumOfPassengers(int num) {
		if ( num > 0)
			numOfPassengers = num;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	@Override
	public String toString() {
		return "Vehicle type: " + type + "\n"
			+ "Vehicle No.: " + vehicleNumber + "\n"
			+ "Weight: " + weight + " kg\n"
			+ "Number of passengers: " + numOfPassengers + "\n"
			/* only if cargo description is not empty i print it */
			+ ( (cargoDescription != null) ? "Cargo description: " + cargoDescription + "\n" : "" ); 
	}
	

}
