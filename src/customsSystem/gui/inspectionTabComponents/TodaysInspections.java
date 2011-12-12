package customsSystem.gui.inspectionTabComponents;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

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

public class TodaysInspections extends JPanel {

	public static final String NAME = "today";
	private JTable table;
	private Customs customs;
	/**
	 * Create the panel.
	 */
	private Object Customs;
	public TodaysInspections(Customs customs) {
		this.customs = customs;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		/*
		String[] columnNames = {"Officer name",
                "Officer surname",
                "Vehicle no.",
                "Vehicle Type",
                "Driver name",
                "Driver surname",
                "Driver ID",
                "Succesful"};
		Inspection inspection;
		Object[][] data = new Object[customs.getInspectionsNum()][8];
		
		for (int i = 0; i < customs.getOfficersNum(); i++) {
			System.out.println(customs.getOfficersNum());
			try {
				inspection = customs.getInspection(i);
					data[i][0] = inspection.getOfficer().getName();
				data[i][1] = inspection.getOfficer().getSurname();
				data[i][2] = inspection.getVehicle().getVehicleNumber();
				data[i][3] = inspection.getVehicle().getType();
				data[i][4] = inspection.getVehicle().getDriver().getName();
				data[i][5] = inspection.getVehicle().getDriver().getSurname();
				data[i][6] = inspection.getVehicle().getDriver().getPersonalID();
				//data[i][7] = (inspection.isSuccessful()) ? "YES" : "NO"; 
				//System.out.println(i + ((inspection.isSuccessful()) ? " YES" : " NO") );
			} catch (CustomsIllegalArgumentException e) {
				// never get here.
				e.printStackTrace();
			}
		}
	*/
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
				return getCustoms().getInspectionsNum();
			}

			@Override
			public Object getValueAt(int arg1, int arg0) {
				try {
					switch(arg0) {
						case 0: return getCustoms().getInspection(arg1).getOfficer().getName();
						case 1: return getCustoms().getInspection(arg1).getOfficer().getSurname();
						case 2: return getCustoms().getInspection(arg1).getVehicle().getVehicleNumber();
						case 3: return getCustoms().getInspection(arg1).getVehicle().getType();
						case 4: return getCustoms().getInspection(arg1).getVehicle().getDriver().getName();
						case 5: return getCustoms().getInspection(arg1).getVehicle().getDriver().getSurname();
						case 6: return getCustoms().getInspection(arg1).getVehicle().getDriver().getPersonalID();
						case 7: return (getCustoms().getInspection(arg1).isSuccessful()) ? "YES" : "NO";
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
		
		JLabel lblNiekoNezinau = new JLabel("Nieko nezinau...");
		panel.add(lblNiekoNezinau, BorderLayout.SOUTH);

	}
	
	public void update() {
		((AbstractTableModel) table.getModel()).fireTableDataChanged();
	}
	
	public String toString() {
		return NAME;
	}
	
	public Customs getCustoms() {
		return customs;
	}
}
