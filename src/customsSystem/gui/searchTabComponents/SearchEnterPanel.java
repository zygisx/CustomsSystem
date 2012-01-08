package customsSystem.gui.searchTabComponents;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.gui.SearchPanel;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class SearchEnterPanel extends JPanel {
	private JTextField textFieldName;
	private JTextField textFieldSurname;
	private JTextField textFieldID;
	private JTextField textFieldVehicleNum;
	private JTextField textFieldOName;
	private JTextField textFieldOSurname;
	private JTextField textFieldNum;
	private JSpinner spinner;
	private JComboBox comboBox;
	private JCheckBox chckbxSearchByDate;
	private JCheckBox chckbxSearchBySuccesfully;
	
	private Customs customs;

	
	
	/**
	 * Create the panel.
	 */
	public SearchEnterPanel(Customs customs, ActionListener parent) {
		this.customs = customs;
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("97dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblName = new JLabel("Name: ");
		add(lblName, "2, 4, right, default");
		
		textFieldName = new JTextField();
		add(textFieldName, "4, 4, fill, default");
		textFieldName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname: ");
		add(lblSurname, "2, 6, right, default");
		
		textFieldSurname = new JTextField();
		add(textFieldSurname, "4, 6, fill, default");
		textFieldSurname.setColumns(10);
		
		JLabel lblPersonalId = new JLabel("Personal ID: ");
		add(lblPersonalId, "2, 8, right, default");
		
		textFieldID = new JTextField();
		add(textFieldID, "4, 8, fill, default");
		textFieldID.setColumns(10);
		
		JLabel lblVehicleNo = new JLabel("Vehicle no.:");
		add(lblVehicleNo, "2, 10, right, default");
		
		textFieldVehicleNum = new JTextField();
		add(textFieldVehicleNum, "4, 10, fill, default");
		textFieldVehicleNum.setColumns(10);
		
		JLabel lblOfficerName = new JLabel("Officer name:");
		add(lblOfficerName, "2, 14, right, default");
		
		textFieldOName = new JTextField();
		add(textFieldOName, "4, 14, fill, default");
		textFieldOName.setColumns(10);
		
		JLabel lblOfficerSurname = new JLabel("Officer surname: ");
		add(lblOfficerSurname, "2, 16, right, default");
		
		textFieldOSurname = new JTextField();
		add(textFieldOSurname, "4, 16, fill, default");
		textFieldOSurname.setColumns(10);
		
		JLabel lblOfficerNo = new JLabel("Officer no.:");
		add(lblOfficerNo, "2, 18, right, default");
		
		textFieldNum = new JTextField();
		add(textFieldNum, "4, 18, fill, default");
		textFieldNum.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		add(lblDate, "2, 22, right, default");
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, "4, 22, fill, fill");
		
		

		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.set(Calendar.YEAR, 1990);
		Date earliestDate = calendar.getTime();
		calendar = Calendar.getInstance();
		Date latestDate = calendar.getTime();
		SpinnerDateModel model = new SpinnerDateModel(initDate,
		                             earliestDate,
		                             latestDate,
		                             Calendar.YEAR);
		spinner = new JSpinner(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
		spinner.setModel(model);
		spinner.setEnabled(false);
		panel.add(spinner);
		
		chckbxSearchByDate = new JCheckBox("Search by date");
		chckbxSearchByDate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (SearchEnterPanel.this.chckbxSearchByDate.isSelected() ) 
					spinner.setEnabled(true);
				else spinner.setEnabled(false);	
			}
		});
		add(chckbxSearchByDate, "6, 22");
		
		JLabel lblPass = new JLabel("Pass: ");
		add(lblPass, "2, 24, right, default");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "4, 24, fill, fill");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBox = new JComboBox();
		panel_1.add(comboBox);
		comboBox.setEnabled(false);
		comboBox.addItem("Yes");
		comboBox.addItem("No");
		
		JButton btnCancel = new JButton("Clear all");
		btnCancel.setActionCommand(SearchPanel.BUTTON_CLEAR);
		btnCancel.addActionListener(parent);
		
		chckbxSearchBySuccesfully = new JCheckBox("Search by succesfully");
		add(chckbxSearchBySuccesfully, "6, 24");
		chckbxSearchBySuccesfully.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (SearchEnterPanel.this.chckbxSearchBySuccesfully.isSelected() ) 
					comboBox.setEnabled(true);
				else comboBox.setEnabled(false);	
			}
		});
		add(btnCancel, "10, 26");
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setActionCommand(SearchPanel.BUTTON_SEARCH);
		btnSearch.addActionListener(parent);
		add(btnSearch, "12, 26");
	}

	public void clearAll() {
		textFieldName.setText("");
		textFieldSurname.setText("");
		textFieldID.setText("");
		textFieldVehicleNum.setText("");
		textFieldOName.setText("");
		textFieldOSurname.setText("");
		textFieldNum.setText("");
		spinner.setValue(new Date());
	}
	
	public ArrayList<Inspection> getSearchResults() {
		ArrayList<Inspection> list = new ArrayList<Inspection>();
		ArrayList<Inspection> tmpList = new ArrayList<Inspection>();
		for (int i = 0; i < customs.getInspectionsNum(); i++) {
			try {
				list.add(this.customs.getInspection(i) );
			} catch (CustomsIllegalArgumentException e) {
				JOptionPane.showMessageDialog(null,
					    "Unknown error.",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (! textFieldName.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getVehicle().getDriver().getName().indexOf(textFieldName.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			
			
			list = new ArrayList(tmpList);
			tmpList.clear();
		}
		if (! textFieldSurname.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
			
				if (list.get(i).getVehicle().getDriver().getSurname().indexOf(textFieldSurname.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (! textFieldID.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getVehicle().getDriver().getPersonalID().indexOf(textFieldID.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (! textFieldVehicleNum.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getVehicle().getVehicleNumber().indexOf(textFieldVehicleNum.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (! textFieldOName.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getOfficer().getName().indexOf(textFieldOName.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (! textFieldOSurname.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getOfficer().getSurname().indexOf(textFieldOSurname.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (! textFieldNum.getText().trim().equals("")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getOfficer().getPersonalID().indexOf(textFieldNum.getText().trim()) != -1) {
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (chckbxSearchByDate.isSelected()) {
			Date d = (Date)spinner.getValue();
		    Calendar c = Calendar.getInstance();
		    Calendar c0 = Calendar.getInstance();
		    c.setTime(d);
			for (int i = 0; i < list.size(); i++) {
				c0.setTime(list.get(i).getDate());
				if (c.get(Calendar.YEAR) == c0.get(Calendar.YEAR) &&
		                  c.get(Calendar.DAY_OF_YEAR) == c0.get(Calendar.DAY_OF_YEAR) ){
					tmpList.add(list.get(i));
				}
			}
			list = new ArrayList(tmpList);
			tmpList.clear();
		}

		if (chckbxSearchBySuccesfully.isSelected()) {
			for (int i = 0; i < list.size(); i++) {
				boolean a;
				if (comboBox.getSelectedIndex() == 0) a = true;
				else a = false;
				if (list.get(i).isSuccessful() == a){
					tmpList.add(list.get(i));
				}
			}
			list = tmpList;

		}
		return list;
		
	}
	
	public void update(Customs customs) {
		this.customs = customs;
	}

}
