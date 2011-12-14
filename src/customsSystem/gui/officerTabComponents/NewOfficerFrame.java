package customsSystem.gui.officerTabComponents;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customsSystem.Customs;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.gui.OfficersPanel;
import customsSystem.persons.CustomsOfficer;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import customsSystem.Vehicle.VehicleType;
import customsSystem.persons.CustomsOfficer.Experience;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewOfficerFrame extends JFrame {

	private JPanel contentPane;

	private Customs customs;
	private OfficersPanel main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	/**
	 * Create the frame.
	 * @param customs 
	 * @param officersPanel 
	 */
	public NewOfficerFrame(Customs customs, OfficersPanel officersPanel) {
		this.customs = customs;
		this.main = officersPanel;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblName, "2, 4, right, default");
		
		textField = new JTextField();
		panel.add(textField, "4, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname: ");
		panel.add(lblSurname, "2, 6, right, default");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "4, 6, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblPersonalId = new JLabel("Personal ID: ");
		panel.add(lblPersonalId, "2, 8, right, default");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "4, 8, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblEmployeeNo = new JLabel("Employee no.:");
		panel.add(lblEmployeeNo, "2, 10, right, default");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "4, 10, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblExperiance = new JLabel("Experiance: ");
		panel.add(lblExperiance, "2, 12, right, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Experience.values()));
		panel.add(comboBox, "4, 12, fill, default");
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewOfficerFrame.this.dispose();
			}
		});
		panel_1.add(btnCancel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CustomsOfficer newOfficer = new CustomsOfficer(
							textField.getText(),
							textField_1.getText(),
							textField_2.getText());
					newOfficer.setEmployeeNumber(textField_3.getText());
					newOfficer.setExperience((Experience) comboBox.getSelectedItem());
					NewOfficerFrame.this.customs.addOfficer(newOfficer);
					NewOfficerFrame.this.dispose();
					NewOfficerFrame.this.main.update();
				} catch (CustomsIllegalArgumentException e1) {
					JOptionPane.showMessageDialog(NewOfficerFrame.this,
						    "Error. " + e1,
						    "New officer error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel_1.add(btnAdd);
		
		setVisible(true);
	}
	
	public CustomsOfficer getOfficer() {
		return null;
	}

}
