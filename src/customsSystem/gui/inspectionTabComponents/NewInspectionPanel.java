package customsSystem.gui.inspectionTabComponents;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.java.swing.plaf.nimbus.ComboBoxComboBoxArrowButtonPainter;

import customsSystem.Vehicle;
import customsSystem.Vehicle.VehicleType;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.persons.VehicleDriver;
import customsSystem.util.Utilities;

import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class NewInspectionPanel extends JPanel {
	
	public final static String NAME = "newInspection";
	
	private JTextArea textArea;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblCheck;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public NewInspectionPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panelVehicle = new JPanel();
		add(panelVehicle);
		panelVehicle.setBorder(BorderFactory.createTitledBorder("Vehicle"));
		panelVehicle.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("19px"),
				ColumnSpec.decode("100px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("126px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("120px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("30px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("30px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
			
			JLabel vehichleNumberLabel = new JLabel("Vehicle number: ");
			vehichleNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
			panelVehicle.add(vehichleNumberLabel, "2, 2, left, center");
			
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.LEFT);
			panelVehicle.add(textField, "4, 2, left, top");
			textField.setColumns(15);
			vehichleNumberLabel.setLabelFor(textField);
			
			JLabel lblCargoDescription = new JLabel("Cargo description: ");
			lblCargoDescription.setHorizontalAlignment(SwingConstants.RIGHT);
			panelVehicle.add(lblCargoDescription, "6, 2");
			
			
			
			JLabel weightLabel = new JLabel("Weight:");
			panelVehicle.add(weightLabel, "2, 4, left, center");
			
			textField_1 = new JTextField();
			panelVehicle.add(textField_1, "4, 4, left, top");
			textField_1.setColumns(10);
			weightLabel.setLabelFor(textField_1);
			
			
			textArea = new JTextArea();
			textArea.setLineWrap(true);
			
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panelVehicle.add(scrollPane,  "6, 4, 3, 5, fill, fill");
			
			JLabel typeLabel = new JLabel("Vehicle type:");
			panelVehicle.add(typeLabel, "2, 6, left, center");
			
			comboBox = new JComboBox();
			
			panelVehicle.add(comboBox, "4, 6, left, center");
			comboBox.addItem(Vehicle.VehicleType.CAR);
			comboBox.addItem(Vehicle.VehicleType.MOTORCYCLE);
			
			comboBox.addItem(Vehicle.VehicleType.VAN);
			comboBox.addItem(Vehicle.VehicleType.TRUCK);
			comboBox.addItem(Vehicle.VehicleType.BUS);
			comboBox.addItem(Vehicle.VehicleType.MINIBUS);
			comboBox.addItem(Vehicle.VehicleType.OTHER);
			//typeLabel.setLabelFor(comboBox);
			

		JPanel panelDriver = new JPanel();
		add(panelDriver);
		panelDriver.setBorder(BorderFactory.createTitledBorder("Driver"));
		panelDriver.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("80px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("100px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("101px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("120px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("62px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name: ");
		panelDriver.add(lblName, "2, 2, left, center");
		
		textField_2 = new JTextField();
		panelDriver.add(textField_2, "4, 2, left, top");
		textField_2.setColumns(10);
		lblName.setLabelFor(textField_2);
		
		JLabel lblSurname = new JLabel("Surname: ");
		panelDriver.add(lblSurname, "6, 2, left, center");
		
		textField_3 = new JTextField();
		panelDriver.add(textField_3, "8, 2, left, top");
		textField_3.setColumns(10);
		lblSurname.setLabelFor(textField_3);
		
		JLabel lblPersonalId = new JLabel("Personal ID: ");
		panelDriver.add(lblPersonalId, "2, 4, left, center");
		
		textField_4 = new JTextField();
		panelDriver.add(textField_4, "4, 4, left, top");
		textField_4.setColumns(10);
		
		JLabel lblDriverLicenseNo = new JLabel("Driver license no.:");
		lblDriverLicenseNo.setHorizontalAlignment(SwingConstants.LEFT);
		panelDriver.add(lblDriverLicenseNo, "6, 4, left, default");
		
		textField_5 = new JTextField();
		panelDriver.add(textField_5, "8, 4, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality: ");
		lblNationality.setHorizontalAlignment(SwingConstants.LEFT);
		panelDriver.add(lblNationality, "2, 6, left, default");
		
		textField_6 = new JTextField();
		panelDriver.add(textField_6, "4, 6, fill, default");
		textField_6.setColumns(10);
		
		lblCheck = new JLabel("");
		lblCheck.setFont(new Font("Verdana", Font.BOLD, 20));
		lblCheck.setEnabled(true);
		lblCheck.setBackground(Color.WHITE);
		lblCheck.setOpaque(true);
		add(lblCheck);
		
	}
	
	public Vehicle getVehicle() 
			throws CustomsIllegalArgumentException {
		VehicleDriver d = new VehicleDriver(
				textField_2.getText(),
				textField_3.getText(),
				textField_4.getText() );
		System.out.println(textField_2.getText() + "**********");
		
		//driver license
		String result = textField_5.getText();
		if (result != null && result.length() > 0) {
			d.setDriverLicenseNumber(result);
		}
		// nationality
		result = textField_6.getText();
		if (result != null && result.length() > 0) {
			d.setNationality(result);
		}
		//Vehicle
		Vehicle v = new Vehicle(textField.getText(), d);
		// weight
		result = textField_1.getText();
		if (! Utilities.isWordFromDigits(result)) {
			JOptionPane.showMessageDialog(this,
				    "Wight must be number.",
				    "Customs system warning",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if (result != null && result.length() > 0) {
			v.setWeight(Integer.parseInt(result));
		}
		// description
		result = textArea.getText();
		if (result != null && result.length() > 0) {
			v.setCargoDescription(result);
		}
		v.setType((VehicleType) comboBox.getSelectedItem());
		
		return v;
	}
	
	
	
	public String toString() {
		return NAME;
	}
	
	public void setCheck(int a) {
		//System.out.println(lblCheck);
		lblCheck.setEnabled(true);
		
		switch(a) {
			case 0: {
				lblCheck.setBackground(Color.GREEN);
				lblCheck.setText("Inspection unnecessary");
				break;
			}
			case 1: {
				lblCheck.setBackground(Color.YELLOW);
				lblCheck.setText("Inspection optional");
				break;
			}
			case 2: {
				lblCheck.setBackground(Color.RED);
				lblCheck.setText("Inspection required");
				break;
			}
		}
		
	}
}
