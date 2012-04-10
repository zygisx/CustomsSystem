package customsSystem.gui.inspectionTabComponents;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TodaysInspections extends JPanel {

	public static final String NAME = "today";
	private JTable table;
	private Customs customs;
	private ArrayList<Inspection> todaysInspections;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * Create the panel.
	 */
	public TodaysInspections(Customs customs) {
		this.customs = customs;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnDetailInformation = new JButton("Detail information");
		btnDetailInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowSelected = table.getSelectedRow();
				if (rowSelected < 0) {
					JOptionPane.showMessageDialog(null,
						    "Error. No inspection selected.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					new DetailInspectionInfo(TodaysInspections.this.todaysInspections.get(rowSelected));
				}
				
			}
		});
		panel_1.add(btnDetailInformation);
		
		JPanel panel = new JPanel();
		add(panel);
		

		todaysInspections = new ArrayList<Inspection>();
		todaysListUpdate();
		
		TableModel dataModel = new AbstractTableModel() {
			String[] columnNames = {"Officer name",
	                "Officer surname",
	                "Vehicle no.",
	                "Vehicle Type",
	                "Driver name",
	                "Driver surname",
	                "Driver ID",
	                "Succesful"};
			
			@Override
			public int getColumnCount() {
				return 8;
			}
			
			@Override
			public String getColumnName(int col) {
	            return columnNames[col];
	        }
			
			@Override 
			public int getRowCount() {
				return todaysInspections.size();
			}

			@Override
			public Object getValueAt(int arg1, int arg0) {
				try {
					switch(arg0) {
						case 0: return todaysInspections.get(arg1).getOfficer().getName();
						case 1: return todaysInspections.get(arg1).getOfficer().getSurname();
						case 2: return todaysInspections.get(arg1).getVehicle().getVehicleNumber();
						case 3: return todaysInspections.get(arg1).getVehicle().getType();
						case 4: return todaysInspections.get(arg1).getVehicle().getDriver().getName();
						case 5: return todaysInspections.get(arg1).getVehicle().getDriver().getSurname();
						case 6: return todaysInspections.get(arg1).getVehicle().getDriver().getPersonalID();
						case 7: return todaysInspections.get(arg1).isSuccessful() ? "YES" : "NO";
						default : return null;
					} 
				} catch (Exception e) {}
				return null;
			}
	         
	      };
	      
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable(dataModel) {  
			public boolean isCellEditable(int row,int column){  
				return false;  
			}  
			
		}; 

		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);

	}
	
	public void update() {
		this.todaysListUpdate();
		((AbstractTableModel) table.getModel()).fireTableDataChanged();
	}
	
	public void todaysListUpdate() {
		Calendar c1 = Calendar.getInstance();
		todaysInspections = new ArrayList<Inspection>();
		for (int i = 0; i < customs.getInspectionsNum(); i++) {
			try {
				Inspection inspection = customs.getInspection(i);
				if (inspection.getDate() != null) {
					if (inspection.getDateAsString().equals(dateFormat.format(c1.getTime()) )) {
						todaysInspections.add(inspection);
					}
				}
				
			} catch (CustomsIllegalArgumentException e) {
				// never get here.
				e.printStackTrace();
			}	
		}
	}
	
	public String toString() {
		return NAME;
	}
	
	public Customs getCustoms() {
		return customs;
	}
	
	public void setCustoms(Customs cust) {
		this.customs = cust;
	}
}
