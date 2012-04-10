package customsSystem.gui.searchTabComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.gui.SearchPanel;
import customsSystem.gui.inspectionTabComponents.DetailInspectionInfo;

public class SearchResultPanel extends JPanel {

	
	private JTable table;
	private ArrayList<Inspection> list;
	private SearchPanel parent;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Customs customs;
	/**
	 * Create the panel.
	 */
	public SearchResultPanel(SearchPanel parent, ArrayList<Inspection> list) {
		this.list = list; 
		this.parent = parent;
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
					new DetailInspectionInfo(SearchResultPanel.this.list.get(rowSelected));
				}
				
			}
		});
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchResultPanel.this.parent.backToFirst();
			}
		});
		panel_1.add(btnBack);
		panel_1.add(btnDetailInformation);
		
		
		JPanel panel = new JPanel();
		add(panel);
		

		list = new ArrayList<Inspection>();
		//listUpdate();
		
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
				if (SearchResultPanel.this.list != null)
					return SearchResultPanel.this.list.size();
				else
					return 0;
			}

			@Override
			public Object getValueAt(int arg1, int arg0) {
				try {
					switch(arg0) {
						case 0: return SearchResultPanel.this.list.get(arg1).getOfficer().getName();
						case 1: return SearchResultPanel.this.list.get(arg1).getOfficer().getSurname();
						case 2: return SearchResultPanel.this.list.get(arg1).getVehicle().getVehicleNumber();
						case 3: return SearchResultPanel.this.list.get(arg1).getVehicle().getType();
						case 4: return SearchResultPanel.this.list.get(arg1).getVehicle().getDriver().getName();
						case 5: return SearchResultPanel.this.list.get(arg1).getVehicle().getDriver().getSurname();
						case 6: return SearchResultPanel.this.list.get(arg1).getVehicle().getDriver().getPersonalID();
						case 7: return SearchResultPanel.this.list.get(arg1).isSuccessful() ? "YES" : "NO";
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
	
	public void setSearchResult(ArrayList<Inspection> list) {
		this.list = list;
		((AbstractTableModel) table.getModel()).fireTableDataChanged();
	}
	


}
