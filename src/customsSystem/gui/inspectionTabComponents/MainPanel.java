package customsSystem.gui.inspectionTabComponents;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;

import customsSystem.Customs;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public final static String NAME = "main";
	
	private ButtonGroup group = null;
	private ArrayList<JRadioButton> buttons = null;
	private Customs customs = null;
	
	public MainPanel(Customs cunstoms) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		buttons = new ArrayList<JRadioButton>();
		this.customs = customs;
		
		JRadioButton rdbtnAddNewInspection = new JRadioButton("add new inspection");
		rdbtnAddNewInspection.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		rdbtnAddNewInspection.setSelected(true);
		rdbtnAddNewInspection.setActionCommand(customsSystem.gui.InspectionPanel.ADD_INSPECTION_PANEL);
		
		
		JRadioButton rdbtnShowTodaysInspections = new JRadioButton("show todays inspections");
		rdbtnShowTodaysInspections.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnShowTodaysInspections.setActionCommand(customsSystem.gui.InspectionPanel.TODAYS_INSPECTIONS);
		
		buttons.add(rdbtnShowTodaysInspections);
		buttons.add(rdbtnAddNewInspection);
		
		group = new ButtonGroup();
		group.add(rdbtnAddNewInspection);
		group.add(rdbtnShowTodaysInspections);
		
		
		add(rdbtnAddNewInspection);
		add(rdbtnShowTodaysInspections);
	}
	
	public String getSelectedRadioButtonCommand() {
		for (JRadioButton a : buttons) {
			System.out.println(a.getActionCommand());
			if (a.isSelected()) {
				return a.getActionCommand();
			}
		}
		return "";
	}
	
	public String toString() {
		return NAME;
	}
}
