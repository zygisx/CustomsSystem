package customsSystem.gui;

import javax.swing.JPanel;

import customsSystem.Customs;
import customsSystem.gui.inspectionTabComponents.NewInspectionEndPanel;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;

import java.awt.CardLayout;
import java.awt.Component;

public class InspectionPanel extends JPanel {

	public final static String MAIN_MENU = "menu";
	public final static String ADD_INSPECTION_PANEL = "newInspection";
	public final static String TODAYS_INSPECTIONS = "today";
	public final static String ADD_END_INSPECTION = "endInspection";
	
	private JPanel mainPanel;
	private NewInspectionPanel addInspection = new customsSystem.gui.inspectionTabComponents.NewInspectionPanel();
	private NewInspectionEndPanel addEndInspection;
	private TodaysInspections todays = new customsSystem.gui.inspectionTabComponents.TodaysInspections();
	/**
	 * Create the panel.
	 */
	public InspectionPanel(Customs customs) {
		setLayout(new CardLayout(0, 0));
		mainPanel = new customsSystem.gui.inspectionTabComponents.MainPanel(customs);
		addEndInspection = new customsSystem.gui.inspectionTabComponents.NewInspectionEndPanel(addInspection, customs);
		
		add(mainPanel, MAIN_MENU);
		add(addInspection, ADD_INSPECTION_PANEL);
		add(todays, TODAYS_INSPECTIONS);
		add(addEndInspection, ADD_END_INSPECTION);
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
	
	public NewInspectionPanel getNewInspectionPanel() {
		return addInspection;
	}
	
	
	

}
