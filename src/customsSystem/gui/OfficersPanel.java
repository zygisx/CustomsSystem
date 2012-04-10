package customsSystem.gui;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import customsSystem.Customs;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.gui.officerTabComponents.NewOfficerFrame;
import customsSystem.persons.CustomsOfficer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OfficersPanel extends JPanel {

	private Customs customs;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public OfficersPanel(Customs customs) {
		this.customs = customs;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnDetailInformation = new JButton("Add officer");
		btnDetailInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewOfficerFrame(OfficersPanel.this.customs, OfficersPanel.this);
			}
		});
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowSelected = table.getSelectedRow();
				if (rowSelected < 0) {
					JOptionPane.showMessageDialog(OfficersPanel.this,
						    "Error. No officer selected.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						int n = JOptionPane.showConfirmDialog(
							    OfficersPanel.this,
							    "Do you really want to delete " + 
							    		OfficersPanel.this.customs.getOfficer(rowSelected).getName() + " " +
							    		OfficersPanel.this.customs.getOfficer(rowSelected).getSurname() + " ?",
							    "Are you sure?",
							    JOptionPane.YES_NO_OPTION);
						if (n == JOptionPane.YES_OPTION) {
							OfficersPanel.this.customs.removeOfficer(rowSelected);
							update();
						}
					} catch (CustomsIllegalArgumentException e1) {
						JOptionPane.showMessageDialog(OfficersPanel.this,
							    "Error." + e1.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		panel_1.add(btnRemove);
		
		panel_1.add(btnDetailInformation);
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		TableModel dataModel = new AbstractTableModel() {
			String[] columnNames = {"Name",
	                "Surname",
	                "Personal ID",
	                "Employee no.",
	                "Experiance"
	        };
			
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
				return getCustoms().getOfficersNum();
			}

			@Override
			public Object getValueAt(int arg1, int arg0) {
				try {
					switch(arg0) {
						case 0: return getCustoms().getOfficer(arg1).getName();
						case 1: return getCustoms().getOfficer(arg1).getSurname();
						case 2: return getCustoms().getOfficer(arg1).getPersonalID();
						case 3: return getCustoms().getOfficer(arg1).getEmployeeNumber();
						case 4: return getCustoms().getOfficer(arg1).getExperience();
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
		((AbstractTableModel) table.getModel()).fireTableDataChanged();
	}
	
	public Customs getCustoms() {
		return this.customs;
	}
	
	public void setCustoms(Customs customs) {
		this.customs = customs;
	}

}
