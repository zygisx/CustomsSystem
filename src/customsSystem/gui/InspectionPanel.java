package customsSystem.gui;

import javax.swing.JPanel;

import customsSystem.Customs;
import customsSystem.gui.inspectionTabComponents.AllInspections;
import customsSystem.gui.inspectionTabComponents.MainPanel;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel2;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel1;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;

import java.awt.CardLayout;
import java.awt.Component;

public class InspectionPanel extends JPanel {

	public final static String MAIN_MENU = "menu";
	public final static String ADD_INSPECTION_1 = "newInspection";
	public final static String TODAYS_INSPECTIONS = "today";
	public static final String ALL_INSPECTIONS = "all";
	public final static String ADD_INSPECTION_2 = "endInspection";
	
	private MainPanel mainPanel;
	private NewInspectionPanel1 addInspection1;
	private NewInspectionPanel2 addInspection2;
	private TodaysInspections todays;
	private AllInspections all;
	private Customs customs;
	/**
	 * Create the panel.
	 */
	public InspectionPanel(Customs customs) {
		setLayout(new CardLayout(0, 0));
		this.customs = customs;
		mainPanel = new customsSystem.gui.inspectionTabComponents.MainPanel(this.customs);
		addInspection1 = new customsSystem.gui.inspectionTabComponents.NewInspectionPanel1();
		addInspection2 = new customsSystem.gui.inspectionTabComponents.NewInspectionPanel2(addInspection1, this.customs);
		all = new customsSystem.gui.inspectionTabComponents.AllInspections(this.customs);
		todays = new customsSystem.gui.inspectionTabComponents.TodaysInspections(this.customs);
		
		add(mainPanel, MAIN_MENU);
		add(addInspection1, ADD_INSPECTION_1);
		add(todays, TODAYS_INSPECTIONS);
		add(addInspection2, ADD_INSPECTION_2);
		add(all, ALL_INSPECTIONS);
	}
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}
	
	public JPanel getCurrentPanel()
	{
	    JPanel card = null;

	    for (Component comp : this.getComponents() ) {
	        if (comp.isVisible() == true) {
	            card = (JPanel)comp;
	        }
	    }
	    return card;
	}
	
	public NewInspectionPanel1 getNewInspectionPanel1() {
		return addInspection1;
	}
	public NewInspectionPanel2 getNewInspectionPanel2() {
		return addInspection2;
	}
	
	public TodaysInspections getTodaysInspections() {
		return todays;
	}
	
	public AllInspections getAllInspections() {
		return all;
	}

	
	public void setCustoms(Customs cust) {
		this.customs = cust;
		this.addInspection2.setCustoms(this.customs);
		this.mainPanel.setCustoms(this.customs);
		this.all.setCustoms(this.customs);
		this.todays.setCustoms(this.customs);
	}
	
	
	

}
