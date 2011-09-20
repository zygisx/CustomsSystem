package customsSystem;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class Inspection {
	
	
	/* For now I consider that in one inspection there is only one officer, 
	 * in forward task I'll change it to list of officers  */
	private CustomsOfficer officer = null;	 /* the inspector */
	private Vehicle vehicle	= null;			/* vehicle */
	private String description = null;
	private boolean isSuccessful;		/* Is inspection successful. False if Vehicle failed to pass border. */
	
	private Calendar date = null;
	private SimpleDateFormat dateFormat;
	
	
	
	public Inspection (CustomsOfficer officer, Vehicle vehicle) {
		this.officer = officer;
		this.vehicle = vehicle;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}


	public CustomsOfficer getOfficer() {
		return officer;
	}


	public void setOfficer(CustomsOfficer officer) {
		this.officer = officer;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}


	public boolean isSuccessful() {
		return isSuccessful;
	}
	
	/**
	 * Set date to todays date
	 */
	public void setDate () {
		date = GregorianCalendar.getInstance();
	}
	
	/**
	 * Set date to optional date
	 */
	public void setDate (int year, int month, int day) { /* Overload */
		date = GregorianCalendar.getInstance();
		date.set(year, month, day);
	}
	
	/* return Date object */
	public Date getDate() {
		return date.getTime();
	}
	
	/* return date in String */
	public String getDateAsString() {
		return dateFormat.format(date.getTime());
	}
	
	private void makeDescription () {
		description = null;
		description = "Inspector:\n"
			+ officer
			+ "Vehicle:\n" 
			+ vehicle
			+ "Vehicle succesfuly pass border: "  + ( (isSuccessful) ? "YES\n" : "NO\n")
			+ ( (date != null) ? "Inspection date: " + dateFormat.format(date.getTime()) + "\n" : "\n" );
	}
	
	public String getDescription() {
		makeDescription();
		return description;
	}

	@Override
	public String toString() {
		return getDescription();
	}	
	
}
