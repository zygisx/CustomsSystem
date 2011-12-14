package customsSystem.gui.inspectionTabComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import customsSystem.Customs;
import customsSystem.exceptions.CustomsIllegalArgumentException;

public class AllInspections extends JPanel {

	public static final String NAME = "all";
	private JTable table;
	private Customs customs;
	/**
	 * Create the panel.
	 */
	public AllInspections(Customs customs) {
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
					try {
						new DetailInspectionInfo(AllInspections.this.customs.getInspection(rowSelected));
					} catch (CustomsIllegalArgumentException e) {
						JOptionPane.showMessageDialog(null,
							    "Error. " + e.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		panel_1.add(btnDetailInformation);
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		TableModel dataModel = new AbstractTableModel() {
			String[] columnNames = {"Officer name",
	                "Officer surname",
	                "Vehicle no.",
	                "Vehicle Type",
	                "Driver name",
	                "Driver surname",
	                "Driver ID",
	                "Date",
	                "Pass"};
			
			@Override
			public int getColumnCount() {
				return columnNames.length;
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
						case 7: return  getCustoms().getInspection(arg1).getDateAsString();
						case 8: return (getCustoms().getInspection(arg1).isSuccessful()) ? "YES" : "NO";
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
		// pareguliuoju dydzius
		TableColumn col = table.getColumnModel().getColumn(7);
		col.setPreferredWidth(80);
		col = table.getColumnModel().getColumn(8);
		col.setPreferredWidth(40);
		panel.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);

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
	
	public void setCustoms(Customs cust) {
		this.customs = cust;
	}

}
