package customsSystem;

import java.util.ArrayList;

public class Customs {
	
	private ArrayList<CustomsOfficer> officers = new ArrayList<CustomsOfficer>();  /* All officers in customs */
	private ArrayList<Inspection> inspections = new ArrayList<Inspection>();      /* All registered Inspections */
	
	
	private String borderWith = null; 	/* With which country customs has border */
	private String customsName = null;	/* Customs name. */ 
	
	public Customs(String borderWith, String customsName) {
		if (borderWith != null)					/* add exception in forward tasks */
			this.borderWith = borderWith;
		if (customsName != null)
			this.customsName = customsName;
	}

	public String getCustomsName() {
		return customsName;
	}

	public String getBorderCountry() {
			return borderWith;
	}
	
	/*
	 * Methods to work with officers ArrayList
	 */
	public int getOfficersNum () {
		return officers.size();
	}
	
	public void addOfficer (CustomsOfficer officer) {
		if (officer != null)
			officers.add(officer);
	}
	
	public boolean removeOfficer (CustomsOfficer officer) {
		if (officer != null)
			return officers.remove(officer);		/* nors pats remove apdoroja null check */
		return false;
	}
	
	public void removeOfficer (int index) {
		if (index >=0 && index < getOfficersNum())
			officers.remove(index);		/* nors pats remove apdoroja klaidas*/
	}
	
	public boolean isAvailableOfficers () {
		return ! officers.isEmpty();
	}

	public CustomsOfficer getRandomOfficer() {
		if ( isAvailableOfficers() )
			return officers.get( (int) (officers.size() * Math.random()));
		return null;	/* do nothing if list is empty */
	}
	
	// ToDo: exception
	public CustomsOfficer getOfficer() {
		if ( isAvailableOfficers() )
			return officers.get(0);
		return null;	/* do nothing if list is empty */
	}
	// ToDo: exception
	public CustomsOfficer getOfficer(int index) {
		if (index >= 0 && index < getOfficersNum ())
			return officers.get(index);
		return null;
	}
	
	/* 
	 * Methods to work with inspections ArrayList
	 */
	public int getInspectionsNum () {
		return inspections.size();
	}
	
	public void addInspection (Inspection inspection) {
		if (inspection != null)
			inspections.add(inspection);
	}
	
	public boolean removeInspection (Inspection inspection) {
		if (inspection != null)
			return inspections.remove(inspection);
		return false;
	}
	
	public void removeInspection (int index) {
		if (index >=0 && index < getInspectionsNum())
			inspections.remove(index);		/* nors pats remove apdoroja klaidas*/
	}
	
	public boolean isAnyInspections () {
		return ! inspections.isEmpty();
	}
	
	// ToDo: exception
	public Inspection getInspection() {
		if ( isAnyInspections() )
			return inspections.get(0);
		return null;	/* do nothing if list is empty */
	}
	// ToDo: exception
	public Inspection getInspection(int index) {
		if (index >= 0 && index < getInspectionsNum())
			return inspections.get(index);
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		str += "Custom: " + customsName + "\n";
		str += "Has border with " + borderWith + "\n";
		str += "Number of officers: " + getOfficersNum() + "\n";
		str += "Number of inspections: " + getInspectionsNum();
		return str;
	}
	
	
	
		
}
