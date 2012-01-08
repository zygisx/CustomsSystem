package customsSystem.gui.inspectionTabComponents;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;

import customsSystem.Customs;
import customsSystem.gui.MainFrame;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JSeparator;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public final static String NAME = "main";
	
	private ButtonGroup group = null;
	private JLabel lblNewLabel;
	private ArrayList<JRadioButton> buttons = null;
	private Customs customs = null;
	
	public MainPanel(Customs customs) {
		buttons = new ArrayList<JRadioButton>();
		this.customs = customs;
		setLayout(new BorderLayout());
		
		lblNewLabel = new JLabel(customs.getCustomsName());
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
		
		java.net.URL imageURL = MainFrame.class.getResource(MainFrame.ICON_FILE);
		if (imageURL != null) {
		    ImageIcon icon = new ImageIcon(imageURL);
		    JLabel image = new JLabel(icon);
		    add(image, BorderLayout.NORTH);
		}
	    
		group = new ButtonGroup();
		
		JSeparator separator = new JSeparator();
		add(separator, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JRadioButton rdbtnAddNewInspection = new JRadioButton("add new inspection");
		rdbtnAddNewInspection.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(rdbtnAddNewInspection);
		rdbtnAddNewInspection.setAlignmentX(Component.CENTER_ALIGNMENT);

		rdbtnAddNewInspection.setSelected(true);
		rdbtnAddNewInspection.setActionCommand(customsSystem.gui.InspectionPanel.ADD_INSPECTION_1);
		buttons.add(rdbtnAddNewInspection);
		group.add(rdbtnAddNewInspection);
		
		
		JRadioButton rdbtnShowTodaysInspections = new JRadioButton("show todays inspections");
		panel.add(rdbtnShowTodaysInspections);
		rdbtnShowTodaysInspections.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnShowTodaysInspections.setActionCommand(customsSystem.gui.InspectionPanel.TODAYS_INSPECTIONS);
		
		buttons.add(rdbtnShowTodaysInspections);
		group.add(rdbtnShowTodaysInspections);
		
		JRadioButton rdbtnShowAll = new JRadioButton("show all inspections");
		panel.add(rdbtnShowAll);
		rdbtnShowAll.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnShowAll.setActionCommand(customsSystem.gui.InspectionPanel.ALL_INSPECTIONS);
		buttons.add(rdbtnShowAll);
		group.add(rdbtnShowAll);
		
	}
	
	public String getSelectedRadioButtonCommand() {
		for (JRadioButton a : buttons) {
			if (a.isSelected()) {
				
				return a.getActionCommand();
				
			}
		}
		return "";
	}
	
	public void setCustoms(Customs cust) {
		this.customs = cust;
	}
	
	public void updateLabel() {
		this.lblNewLabel.setText(this.customs.getCustomsName());
	}
	
	public String toString() {
		return NAME;
	}

}
