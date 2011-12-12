package customsSystem.gui.inspectionTabComponents;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.Vehicle;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.exceptions.CustomsNullArgumentException;
import customsSystem.persons.CustomsOfficer;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class NewInspectionPanel2 extends JPanel {
	
	public final static String NAME = "endInspection";
	
	private JTable table;
	
	private Customs customs = null;
	private NewInspectionPanel1 panel;
	private JPanel panelOfficer;
	private JPanel panelInspection;
	private JSpinner spinner;
	private JLabel lblYear;
	private JLabel lblMonth;
	private JSpinner spinner_1;
	private JLabel lblNewLabel;
	private JSpinner spinner_2;
	private JComboBox comboBox;
	private JLabel lblInspectionEnd;
	private JLabel lblExtraDescription;
	private JTextArea textArea;
	private JLabel lblCheck;

	/**
	 * Create the panel.
	 */
	public NewInspectionPanel2(NewInspectionPanel1 panel, Customs customs) {
		this.panel = panel;
		this.customs = customs;
		String[] columnNames = {"Name",
                "Surname",
                "Personal ID",
                "Employee no.",
                "Experience"};
		/*
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		*/
		CustomsOfficer officer;
		Object[][] data = new Object[customs.getOfficersNum()][5];
		for (int i = 0; i < customs.getOfficersNum(); i++) {
			
			try {
				officer = customs.getOfficer(i);
				data[i][0] = officer.getName();
				data[i][1] = officer.getSurname();
				data[i][2] = officer.getPersonalID();
				data[i][3] = officer.getEmployeeNumber();
				data[i][4] = officer.getExperience();
			} catch (CustomsIllegalArgumentException e) {
				// never get here.
				e.printStackTrace();
			}
		}
		
		lblCheck = new JLabel("");
		lblCheck.setOpaque(true);
		lblCheck.setFont(new Font("Verdana", Font.BOLD, 20));
		lblCheck.setEnabled(true);
		lblCheck.setBackground(Color.WHITE);
		add(lblCheck);
		
		
		panelInspection = new JPanel();
		add(panelInspection);
		panelInspection.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("40px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("50px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("40px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("40px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("35px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("40px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("90px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("111px"),},
			new RowSpec[] {
				RowSpec.decode("25px"),
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(8dlu;pref):grow"),
				RowSpec.decode("default:grow"),
				RowSpec.decode("max(23dlu;default)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblYear = new JLabel("Year");
		panelInspection.add(lblYear, "2, 2, left, center");
		
		spinner = new JSpinner();
		spinner.setVerifyInputWhenFocusTarget(false);
		Calendar calendar = Calendar.getInstance();
		int init = calendar.get(Calendar.YEAR);
		calendar.add(Calendar.YEAR, -5);
		int first = calendar.get(Calendar.YEAR);
		spinner.setModel(new SpinnerNumberModel(init ,first, init, Calendar.YEAR));
		((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
		panelInspection.add(spinner, "4, 2, left, top");
		lblYear.setLabelFor(spinner);
		calendar = Calendar.getInstance();	
		spinner.setValue(calendar.get(Calendar.YEAR));
		
		
		
		
		
		panelOfficer = new JPanel();
		add(panelOfficer);
		panelOfficer.setBorder(BorderFactory.createTitledBorder("Officers"));
		panelInspection.setBorder(BorderFactory.createTitledBorder("Inspection"));
		
		lblMonth = new JLabel("Month");
		panelInspection.add(lblMonth, "6, 2, left, center");
		
		spinner_1 = new JSpinner();
		panelInspection.add(spinner_1, "8, 2, left, top");
		spinner_1.setModel(new SpinnerNumberModel(1 ,1, 12, 1));
		spinner_1.setValue(calendar.get(Calendar.MONTH) + 1);
		
		lblNewLabel = new JLabel("Day");
		panelInspection.add(lblNewLabel, "10, 2, left, center");
		
		spinner_2 = new JSpinner();
		panelInspection.add(spinner_2, "12, 2, left, top");
		spinner_2.setModel(new SpinnerNumberModel(1 ,1, 31, 1));
		spinner_2.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		
		lblInspectionEnd = new JLabel("Inspection end: ");
		panelInspection.add(lblInspectionEnd, "14, 2, left, center");
		
		comboBox = new JComboBox();
		panelInspection.add(comboBox, "16, 2, left, top");
		comboBox.addItem("Successful");
		comboBox.addItem("Unsuccessful");
		
		lblExtraDescription = new JLabel("Extra description: ");
		panelInspection.add(lblExtraDescription, "2, 4, 6, 1");
		
		textArea = new JTextArea(6, 0);
		textArea.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(textArea);
		panelInspection.add(scroll, "2, 6, 15, 5, fill, fill");
		
		
		
		table = new JTable(data, columnNames) {  
			  public boolean isCellEditable(int row,int column){  
				    return false;  
				  }  
				};  
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelOfficer.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelOfficer.add(scrollPane);
		
	}
	
	public void clearAll() {
		textArea.setText("");
		Calendar calendar = Calendar.getInstance();
		spinner.setValue(calendar.get(Calendar.YEAR));
		spinner_1.setValue(calendar.get(Calendar.MONTH) + 1);
		spinner_2.setValue(calendar.get(Calendar.DAY_OF_MONTH));
		lblCheck.setText("");
		table.clearSelection();
	}
	
	public Inspection getInspection(Vehicle v) 
			throws CustomsIllegalArgumentException {
		Inspection i;
		int rowSelected = table.getSelectedRow();
		if (rowSelected < 0) {
			JOptionPane.showMessageDialog(this,
				    "Error. No customs officer selected.",
				    "New inspection error",
				    JOptionPane.ERROR_MESSAGE);
			return null;
		}
		else if (table.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(this,
				    "Please select only one officer",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
			return null;
		}
		else {
			i = new Inspection(customs.getOfficer(rowSelected), v);
			i.setDate(
				((Integer) (spinner.getValue())), 
				((Integer) (spinner_1.getValue())),
				((Integer) (spinner_2.getValue()))
				);
			i.setDescription(textArea.getText());
			i.setSuccessful((comboBox.getSelectedItem().equals("Successful")) ? true : false );
			
		}
		
		
		
		return i;
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
	
	public String toString() {
		return NAME;
	}
	
	

}
