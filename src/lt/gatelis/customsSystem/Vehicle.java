package lt.gatelis.customsSystem;

public class Vehicle {
	
	/* types of vehicle */
	public static final int MOTORCYCLE 	= 0;
	public static final int CAR 		= 1;
	public static final int VAN			= 2;
	public static final int TRUCK 		= 3;

	public static final int OTHER 		= 9;
	
	
	private int weight = 0;	 /* Weight in kilos. By default weight is 0 kg */  
	
	private String carNumber = null;
	
	private String cargoDescription = null;	/* Short description of goods in vehicle */
	
	private boolean isTabacoInCargo = false; /* is tabaco included in cargo */
	
	private boolean isAlcoholInCargo = false; /* is alcohol included in cargo */
	
	

}
