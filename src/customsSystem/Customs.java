package customsSystem;

import java.io.Serializable;
import java.util.ArrayList;

import customsSystem.exceptions.*;
import customsSystem.persons.CustomsOfficer;
import customsSystem.persons.VehicleDriver;


/**
 * Customs class.
 * @author Žygimantas Gatelis
 * @version 1.0 
 */
public final class Customs implements Cloneable, Serializable {
	
	private ArrayList<CustomsOfficer> officers = new ArrayList<CustomsOfficer>();  /* All officers in customs */
	private ArrayList<Inspection> inspections = new ArrayList<Inspection>();      /* All registered Inspections */
	
	
	private final String borderWith; 	/* With which country customs has border */
	private final String customsName;	/* Customs name. */ 
	
	
	/**
	 * Constructs customs.
	 * @param borderWith The code of the neighbor country.
	 * 					 
	 * @param customsName The name of the Customs.
	 * @throws CustomsNullArgumentException if at least one
	 * 		argument is <code>null</code>.
	 */
	public Customs(String borderWith, String customsName) 
			throws CustomsNullArgumentException {
		if (borderWith == null || customsName == null)					
			throw new CustomsNullArgumentException("Null argument");
		this.borderWith = borderWith;
		this.customsName = customsName;
	}
	
	
	/**
	 * Returns customs name which was set in constructor.
	 * @return Customs name
	 */
	public String getCustomsName() {
		return this.customsName;
	}
	
	/**
	 * Returns the code of neighbor country.
	 * @return the code of neighbor country
	 */
	public String getBorderCountry() {
			return this.borderWith;
	}
	

	/* ********** Methods to work with officers ArrayList *************** */
	/**
	 * Returns the number of officers in customs.
	 * @return the number of officers in customs.
	 */
	public int getOfficersNum () {
		return this.officers.size();
	}
	
	/**
	 * Appends officer to end of customs officers list.
	 * @param officer {@link CustomsOfficer} to be appended to officers list
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 */
	public void addOfficer (CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument.");
		this.officers.add(officer);
	}
	
	/**
	 * Removes the first occurrence of the {@link CustomsOfficer}
	 * from officers list, if it is present.
	 * 
	 * If the list does not contain the element, it is unchanged. If there is  more than 
	 * one same officer only the officer with the smallest index is removed. Returns <code>true</code>
	 * if list contained the specified officer.
	 * @param officer {@link CustomsOfficer} to be removed from officers list, if present 
	 * @return <code>true</code> if officers list contained the specified element
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 */
	public  boolean removeOfficer (CustomsOfficer officer) 
			throws CustomsNullArgumentException {
		if (officer == null)
			throw new CustomsNullArgumentException("Null argument");
		ArrayList<Inspection> list = new ArrayList<Inspection>(); //to avoid java.util.ConcurrentModificationException 
		for (Inspection i : this.inspections) {
			if (i.getOfficer().getPersonalID().equals(officer.getPersonalID()) ) {
		    	  list.add(i);
		     }
		}
		for (Inspection i : list) {
			this.inspections.remove(i);
		}
		return this.officers.remove(officer);		
	}
	
	/**
	 * Removes the element at the specified position in {@link CustomsOfficer} list.
	 * 
	 * After removing element every subsequent element is shifted to the left.
	 * @param index  the index of the {@link CustomsOfficer} to be removed
	 * @throws CustomsIllegalArgumentException if the index is out of range 
	 * (<code>index < 0 || index > getOfficersNum()</code>).
	 */
	public void removeOfficer (int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		ArrayList<Inspection> list = new ArrayList<Inspection>(); //to avoid java.util.ConcurrentModificationException 
		for (Inspection i : this.inspections) {
			if (i.getOfficer().getPersonalID().equals(getOfficer(index).getPersonalID()) ) {
		    	  list.add(i);
		     }
		}
		for (Inspection i : list) {
			this.inspections.remove(i);
		}
		this.officers.remove(index);	
	}
	
	/**
	 * Returns <code>true</code> if officers list contains at least one.
	 * @return  <code>true</code> if officers list contains at least one.
	 */
	public boolean isAvailableOfficers () {
		return ! this.officers.isEmpty();
	}
	
	/**
	 * Returns random {@link CustomsOfficer} from officers list.
	 * @return randomly chosen {@link CustomsOfficer}.
	 * @throws CustomsEmptyListException if no officers are in customs.
	 */
	public CustomsOfficer getRandomOfficer() 
			throws CustomsEmptyListException {
		if ( ! this.isAvailableOfficers() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return officers.get( (int) (officers.size() * Math.random()));
	}
	

	/**
	 * Returns the first {@link CustomsOfficer} in officers list.
	 * @return the first officer in officers list.
	 * @throws CustomsEmptyListException if officers list contains no officers.
	 */
	public CustomsOfficer getOfficer() 
			throws CustomsEmptyListException {
		if ( ! this.isAvailableOfficers() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return this.officers.get(0);   
	}

	/**
	 * Returns the {@link CustomsOfficer} at the specified position in officers list.
	 * @param index  index of the officer to return
	 * @return the officer at the specified position in officers list
	 * @throws CustomsIllegalArgumentException if the index is out of range 
	 * (<code>index < 0 || index > getOfficersNum()</code>).
	 */
	public CustomsOfficer getOfficer(int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.officers.get(index); 
	}
	
	/**
	 * Returns true if officers list contains the specified {@link CustomsOfficer}.
	 * 
	 * @param officer officer which existence in officers list is to be tested
	 * @return <code>true</code> list contains specified officer, <code>false</code> otherwise
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 */
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
	
	/* Methods to work with inspections ArrayList */
	 
	/**
	 * Returns the number of inspections registered in customs.
	 * @return the number of inspections registered in customs.
	 */
	public int getInspectionsNum () {
		return this.inspections.size();
	}
	
	/**
	 * Appends {@link Inspection}} to end of customs inspections list.
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 * @param inspection inspection to be appended to inspections list
	 * @throws CustomsException if argument is null or inspection contains 
	 * 		officer which is not specified in customs.
	 */
	public void addInspection (Inspection inspection) 
			throws CustomsException {
		if (inspection == null)
			throw new CustomsNullArgumentException("Null argument.");
		if (! this.containsOfficer(inspection.getOfficer()) )
			throw new CustomsUnknownOfficerException("Illegal offiser. Offiser not registred in customs.");
		this.inspections.add(inspection);
	}
	
	/**
	 * Removes the first occurrence of the {@link Inspection}
	 * from inspections list, if it is present.
	 * 
	 * If the list does not contain the inspection, it is unchanged. If there is  more than 
	 * one same inspections only the inspection with the smallest index is removed. 
	 * Returns <code>true</code> if list contained the specified officer.
	 * @param inspection {@link Inspection} to be removed from inspections list, if present 
	 * @return <code>true</code> if inspections list contained the specified element, 
	 * 		<code>false</code> otherwise.
	 * @throws CustomsNullArgumentException if argument is <code>null</code>.
	 */
	public boolean removeInspection (Inspection inspection) 
			throws CustomsNullArgumentException {
		if (inspection == null)
			throw new CustomsNullArgumentException("Null argument.");
		return this.inspections.remove(inspection);
	}
	
	/**
	 * Removes the inspection at the specified position in {@link Inspection} list.
	 * 
	 * After removing inspection every subsequent element is shifted to the left.
	 * @param index the index of the {@link Inspection} in inspections list to be removed
	 * @throws CustomsIllegalArgumentException if the index is out of range 
	 * (<code>index < 0 || index > getOfficersNum()</code>).
	 */
	public void removeInspection (int index) 
			throws CustomsIllegalArgumentException {
		if (index < 0 || index > this.getOfficersNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		this.inspections.remove(index);	
	}
	
	/**
	 * Returns  <code>true</code> if inspections list contains at least one.
	 * @return  <code>true</code> if officers list contains at least one.
	 */
	public boolean isAnyInspections () {
		return ! this.inspections.isEmpty();
	}
	
	/**
	 * Returns the first {@link Inspection} in inspections list.
	 * 
	 * @return the first inspection in inspections list.
	 * @throws CustomsEmptyListException if there is no inspections specified in customs.
	 */
	public Inspection getInspection() throws CustomsEmptyListException {
		if ( ! this.isAnyInspections() )
			throw new CustomsEmptyListException("Try to reach element in empty list.");
		return this.inspections.get(0);
	}

	/**
	 * 
	 * Returns the {@link Inspection} at the specified position in inspections list.
	 * 
	 * @param index index of the inspections to return.
	 * @return an inspection at the specified position in inspections list
	 * @throws CustomsIllegalArgumentException if the index is out of range 
	 * (<code>index < 0 || index > getOfficersNum()</code>).
	 */
	public Inspection getInspection(int index) throws CustomsIllegalArgumentException {
		if (index < 0 || index >= this.getInspectionsNum() )
			throw new CustomsIllegalArgumentException("Wrong index.");
		return this.inspections.get(index);	
	}
	
	public boolean checkVehicle(Vehicle v) 
			throws CustomsNullArgumentException {
		if (v == null) {
			throw new CustomsNullArgumentException("Null argument");
		}
		for (Inspection i : inspections) {
			if (v.getVehicleNumber().equals(i.getVehicle().getVehicleNumber())) {
				if (! i.isSuccessful()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkDriver(VehicleDriver d) 
			throws CustomsNullArgumentException {
		if (d == null) {
			throw new CustomsNullArgumentException("Null argument");
		}
		for (Inspection i : inspections) {
			if (d.getPersonalID().equals(i.getVehicle().getDriver().getPersonalID())) {
				if (! i.isSuccessful()) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Converts customs object to {@link java.lang.String}
	 * 
	 * @return {@link java.lang.String} that contains info about customs.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		str += "Custom: " + customsName + "\n";
		str += "Has border with " + borderWith + "\n";
		str += "Number of officers: " + getOfficersNum() + "\n";
		str += "Number of inspections: " + getInspectionsNum();
		return str;
	}

	/**
	 * Return a copy of this customs object.
	 * 
	 * @return {$link Customs} object copy
	 * @see java.lang.Object#clone()
	 */
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
