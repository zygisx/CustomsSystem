package customsSystem.gui;

import javax.swing.JPanel;

import customsSystem.Customs;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel2;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel1;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;

import java.awt.CardLayout;
import java.awt.Component;

public class InspectionPanel extends JPanel {

	public final static String MAIN_MENU = "menu";
	public final static String ADD_INSPECTION_1 = "newInspection";
	public final static String TODAYS_INSPECTIONS = "today";
	public final static String ADD_INSPECTION_2 = "endInspection";
	
	private JPanel mainPanel;
	private NewInspectionPanel1 addInspection1 = new customsSystem.gui.inspectionTabComponents.NewInspectionPanel1();
	private NewInspectionPanel2 addInspection2;
	private TodaysInspections todays = new customsSystem.gui.inspectionTabComponents.TodaysInspections();
	/**
	 * Create the panel.
	 */
	public InspectionPanel(Customs customs) {
		setLayout(new CardLayout(0, 0));
		mainPanel = new customsSystem.gui.inspectionTabComponents.MainPanel(customs);
		addInspection2 = new customsSystem.gui.inspectionTabComponents.NewInspectionPanel2(addInspection1, customs);
		
		add(mainPanel, MAIN_MENU);
		add(addInspection1, ADD_INSPECTION_1);
		add(todays, TODAYS_INSPECTIONS);
		add(addInspection2, ADD_INSPECTION_2);
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public JPanel getCurrentPanel()
	{
	    JPanel card = null;

	    for (Component comp : this.getComponents() ) {
	        if (comp.isVisible() == true) {
	            card = (JPanel)comp;
	            System.out.println(card.getName() );
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
	
	
	

}
