package customsSystem;

import java.util.ArrayList;

public class Customs {
	
	private ArrayList<CustomsOfficer> officers = null;  /* All officers in customs */
	
	private String borderWith = null; /* With which country customs has border */
	
	public Customs() {
		this(null);
	}
	
	public Customs(String borderCountry) {
		borderWith = borderCountry;
		officers = new ArrayList<CustomsOfficer>();
	}
	
	public void addOfficer (CustomsOfficer officer) {
		officers.add(officer);
	}
	/*
	public CustomsOfficer getOfficer() {
		return
	}
	*/


}
