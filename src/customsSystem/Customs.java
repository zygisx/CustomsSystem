package customsSystem;

import java.util.ArrayList;

import customsSystem.exceptions.*;
import customsSystem.persons.CustomsOfficer;


public final class Customs implements Cloneable {
	
	private ArrayList<CustomsOfficer> officers = new ArrayList<CustomsOfficer>();  /* All officers in customs */
	private ArrayList<Inspection> inspections = new ArrayList<Inspection>();      /* All registered Inspections */
	
	
	private final String borderWith; 	/* With which country customs has border */
	private final String customsName;	/* Customs name. */ 
	
	public Customs(String borderWith, String customsName) 
			throws CustomsNullArgumentException {
		if (borderWith == null || customsName == null)					
			throw new CustomsNullArgumentException("Null argument");
		this.borderWith = borderWith;
		this.customsName = customsName;
	}

	public String getCustomsName() {
		return this.customsName;
	}

	public String getBorderCountry() {
			return this.borderWith;
	}
	
	/*
	 * Methods to work with officers ArrayList
	 */
	public int getOfficersNum () {
		return this.officers.size();
	}
	
	public void addOfficer (CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.officers.add(officer);
	}
	
	public boolean removeOfficer (CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument");
		return this.officers.remove(officer);		
	}
	
	public void removeOfficer (int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		this.officers.remove(index);	
	}
	
	public boolean isAvailableOfficers () {
		return ! this.officers.isEmpty();
	}

	public CustomsOfficer getRandomOfficer() 
			throws CustomsEmptyListException {
		if ( ! this.isAvailableOfficers() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return officers.get( (int) (officers.size() * Math.random()));
	}
	

	public CustomsOfficer getOfficer() 
			throws CustomsEmptyListException {
		if ( ! this.isAvailableOfficers() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return this.officers.get(0);   
	}

	public CustomsOfficer getOfficer(int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.officers.get(index); 
	}
	
	public boolean containsOfficer(CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument.");
		for (CustomsOfficer c : officers) {
			if ( c.getPersonalID().equals(officer.getPersonalID()) )
				return true;
		}
		return false;
	}
	
	/* 
	 * Methods to work with inspections ArrayList
	 */
	public int getInspectionsNum () {
		return this.inspections.size();
	}
	
	public void addInspection (Inspection inspection) 
			throws CustomsException {
		if (inspection == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! this.containsOfficer(inspection.getOfficer()) )
			throw new CustomsUnknownOfficerException("Illegal offiser.");
		this.inspections.add(inspection);
	}
	
	public boolean removeInspection (Inspection inspection) 
			throws CustomsNullArgumentException {
		if (inspection == null)
			throw new CustomsNullArgumentException("Null argument.");
		return this.inspections.remove(inspection);
	}
	
	public void removeInspection (int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		this.inspections.remove(index);	
	}
	
	public boolean isAnyInspections () {
		return ! this.inspections.isEmpty();
	}
	
	public Inspection getInspection() throws CustomsEmptyListException {
		if ( ! this.isAnyInspections() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return this.inspections.get(0);
	}

	public Inspection getInspection(int index) throws CustomsIllegalArgumentException {
		if (index < 0 || index >= this.getInspectionsNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.inspections.get(index);	
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

	@Override
	public Customs clone() {
		Customs result;
		try {
			result = (Customs) super.clone();
			/* clone all officers */
			result.officers = new ArrayList<CustomsOfficer>();
			for (CustomsOfficer o : this.officers) {
				result.officers.add((CustomsOfficer) o.clone());
			}
			/* clone all inspections */
			result.inspections = new ArrayList<Inspection>();
			for (Inspection i : this.inspections) {
				result.inspections.add((Inspection) i.clone());
				
			}
			/* link all officers in inspection with correct officer from Customs ArrayList */	
			for (Inspection i : result.inspections) {
				for (CustomsOfficer c : result.officers ) {
					if (i.getOfficer().getPersonalID().equals(c.getPersonalID())) {
						try {
							i.setOfficer(c);
						} catch (CustomsNullArgumentException ex) {} //exceptionas negali kilti juk officeris jau viena karta buvo uzsetintas.
						break;
					}
				}
			}
		}
		catch (Exception ex) {
			throw new RuntimeException("Clone failure.", ex);
		}
		return result;
	}
	
	
	
		
}
