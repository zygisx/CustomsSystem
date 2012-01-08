package customsSystem.gui.inspectionTabComponents;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import customsSystem.Inspection;
import javax.swing.JTextArea;

public class DetailInspectionInfo extends JFrame {

	private JPanel contentPane;
	private Inspection inspection;

	/**
	 * Create the frame.
	 */
	public DetailInspectionInfo(Inspection inspection) {
		super("Detail information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.inspection = inspection;
		
		setBounds(100, 100, 500, 450);
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
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(41dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblOfficerName = new JLabel("Officer name: ");
		panel.add(lblOfficerName, "2, 2");
		
		JLabel labelOfficerName = new JLabel(this.inspection.getOfficer().getName());
		panel.add(labelOfficerName, "4, 2");
		
		JLabel lblVehicleNo = new JLabel("Vehicle no.:");
		panel.add(lblVehicleNo, "8, 2");
		
		JLabel labelVehicleNo = new JLabel(this.inspection.getVehicle().getVehicleNumber());
		panel.add(labelVehicleNo, "10, 2");
		
		JLabel lblOfficerSurname = new JLabel("Officer surname: ");
		panel.add(lblOfficerSurname, "2, 4");
		
		JLabel labelOfficerSurname = new JLabel(this.inspection.getOfficer().getSurname());
		panel.add(labelOfficerSurname, "4, 4");
		
		JLabel lblVehicleType = new JLabel("Vehicle type: ");
		panel.add(lblVehicleType, "8, 4");
		
		JLabel labelVehicleType = new JLabel(this.inspection.getVehicle().getType().name());
		panel.add(labelVehicleType, "10, 4");
		
		
		JLabel lblOfficerNum = new JLabel("Officer employee no.:");
		panel.add(lblOfficerNum, "2, 6");
		
		
		JLabel labelOfficerNum = new JLabel(
				(this.inspection.getOfficer().getEmployeeNumber() != null) ? 
						this.inspection.getOfficer().getEmployeeNumber() : "" );
		panel.add(labelOfficerNum, "4, 6");
		
		JLabel lblNewLabel = new JLabel("Vehicle weight: ");
		panel.add(lblNewLabel, "8, 6");
		
		JLabel labelVehilceWeight = new JLabel(Integer.toString(this.inspection.getVehicle().getWeight() ));
		panel.add(labelVehilceWeight, "10, 6");
		
		JLabel lblOfficerExperience = new JLabel("Officer experience: ");
		panel.add(lblOfficerExperience, "2, 8");
		
		JLabel labelOfficerExperience = new JLabel(
				this.inspection.getOfficer().getExperience() != null ?
						this.inspection.getOfficer().getExperience().name() : "" );
		panel.add(labelOfficerExperience, "4, 8");
		
		JLabel lblInspectionDate = new JLabel("Inspection date: ");
		panel.add(lblInspectionDate, "8, 8");
		
		JLabel labelInspectionDate = new JLabel((this.inspection.getDate() != null) ?
				this.inspection.getDateAsString() : "");
		panel.add(labelInspectionDate, "10, 8");
		
		JLabel lblDriverName = new JLabel("Driver name: ");
		panel.add(lblDriverName, "2, 10");
		
		JLabel labelDriverName = new JLabel(this.inspection.getVehicle().getDriver().getName());
		panel.add(labelDriverName, "4, 10");
		
		JLabel lblPass = new JLabel("Pass: ");
		panel.add(lblPass, "8, 10");
		
		JLabel labelPass = new JLabel(
				this.inspection.isSuccessful() ? 
						"YES" : "NO" );
		panel.add(labelPass, "10, 10");
		
		JLabel lblDriverSurname = new JLabel("Driver surname: ");
		panel.add(lblDriverSurname, "2, 12");
		
		JLabel labelDriverSurname = new JLabel(this.inspection.getVehicle().getDriver().getSurname());
		panel.add(labelDriverSurname, "4, 12");
		
		JLabel lblCargoDescription = new JLabel("Cargo description: ");
		panel.add(lblCargoDescription, "8, 12");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setText(this.inspection.getVehicle().getCargoDescription());
		JScrollPane scrollPane = new JScrollPane(textArea_1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "8, 14, 5, 7, fill, fill");
		
		JLabel lblDriverPersonalId = new JLabel("Driver personal ID:");
		panel.add(lblDriverPersonalId, "2, 14");
		
		JLabel labelDriverPersonalId = new JLabel(this.inspection.getVehicle().getDriver().getPersonalID());
		panel.add(labelDriverPersonalId, "4, 14");
		
		
		
		JLabel lblDriverLicense = new JLabel("Driver license no.:");
		panel.add(lblDriverLicense, "2, 16");
		
		JLabel labelDriverLicense = new JLabel(
				this.inspection.getVehicle().getDriver().getDriverLicenseNumber() != null ?
						this.inspection.getVehicle().getDriver().getDriverLicenseNumber() : "");
		panel.add(labelDriverLicense, "4, 16");
		
		JLabel lblDriverNationality = new JLabel("Driver nationality:");
		panel.add(lblDriverNationality, "2, 18");
		
		JLabel labelDriverNationality = new JLabel(
				this.inspection.getVehicle().getDriver().getNationality() != null ?
						this.inspection.getVehicle().getDriver().getNationality() : "");
		panel.add(labelDriverNationality, "4, 18");
		
		JLabel lblOfficerInspection = new JLabel("Inspection description: ");
		panel.add(lblOfficerInspection, "2, 20");
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setText(this.inspection.getDescription());
		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane_1, "2, 22, 11, 1, fill, fill");
		
		
		JLabel lblDetailInformation = new JLabel("Detail information");
		lblDetailInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDetailInformation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDetailInformation, BorderLayout.NORTH);
		setVisible(true);
	}
}
