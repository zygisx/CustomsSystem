package customsSystem.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.Vehicle;
import customsSystem.Vehicle.VehicleType;
import customsSystem.exceptions.CustomsEmptyListException;
import customsSystem.exceptions.CustomsException;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.exceptions.CustomsNullArgumentException;
import customsSystem.exceptions.CustomsUnknownOfficerException;
import customsSystem.gui.inspectionTabComponents.MainPanel;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;
import customsSystem.persons.CustomsOfficer;
import customsSystem.persons.Passenger;
import customsSystem.persons.VehicleDriver;
import customsSystem.persons.CustomsOfficer.Experience;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ButtonsPanel bPanel;
	private InspectionPanel inspectionPanel;
	
	
	private Customs customs = null;

	
	
	public void niekas() {
		try {
			
			// clone CustomsOfficer
			CustomsOfficer p = new CustomsOfficer("Jonas", "Jonaitis", "12345");
			
		
			
			// clone Vehicle
			Vehicle v = new Vehicle("ABC526" ,new VehicleDriver("Jonas", "Jonukas", "5846846"));
			v.addPassenger(new Passenger("Indre", "Gatelyte", "35648618"));
			
			
			// clone Inspection
			Inspection i = new Inspection(p, v);
			i.setDate(2011, 11, 20);
			
			
			
			// creation of few more objects 
			CustomsOfficer c1 = new CustomsOfficer("Jonas", "Petraitis", "123456");
			CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevi�ius", "123458");
			CustomsOfficer c3 = new CustomsOfficer("Ilona", "Jusyte", "123459");
			c1.setExperience(Experience.JUNIOR);
			c2.setExperience(Experience.HEAD);
			c3.setExperience(Experience.TRAINEE);
			
			Inspection i1 = new Inspection(c1, v);
			Inspection i2 = new Inspection(c2, v);
			Inspection i3 = new Inspection(c1, v);
			Inspection i4 = new Inspection(c2, v);
			Inspection i5 = new Inspection(c3, v);
			Inspection i6 = new Inspection(c1, v);
			
			// Customs 
			customs = new Customs("PL", "Lazdij� pasienio punktas.");
			customs.addOfficer(p);
			customs.addOfficer(c1);
			customs.addOfficer(c2);
			customs.addOfficer(c3);
			
			customs.addInspection(i);
			customs.addInspection(i);
			customs.addInspection(i1);
			customs.addInspection(i2);
			customs.addInspection(i3);
			customs.addInspection(i4);
			customs.addInspection(i5);
			customs.addInspection(i6);
			
		}
		catch (CustomsUnknownOfficerException ex) {
			System.out.println("Unknown officer: " + ex);
		}
		catch (CustomsNullArgumentException ex) {
			System.out.println("Null argument: " + ex);
		}
		catch (CustomsIllegalArgumentException ex) {
			System.out.println("Illegal argument: " + ex);
		}
		catch (CustomsEmptyListException ex) {
			System.out.println(ex);
		}
		catch (CustomsException ex) {
			System.out.println("Customs exception: " + ex);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		niekas(); //TODO delete this shit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		JMenuItem Export = new JMenuItem("Export");
		mnFile.add(Export);
		mnFile.addSeparator();
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
		        System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		bPanel = new ButtonsPanel((ActionListener) this);
		contentPane.add(bPanel, BorderLayout.SOUTH);
		bPanel.setOk(false);
		bPanel.setConfirm(true);
		bPanel.setCancel(false);
		
		
		inspectionPanel = new InspectionPanel(customs);
		tabbedPane.addTab("Inspections", null, inspectionPanel, null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// work
		if (inspectionPanel.getCurrentPanel().toString() == MainPanel.NAME) {
			// persoku i langa kurio reikia
			if (e.getActionCommand().equals(ButtonsPanel.CONFIRM)) { /* +- veikia neturetu gliucint */
				String result = ((MainPanel) ((InspectionPanel) inspectionPanel).getMainPanel()).getSelectedRadioButtonCommand();
				((CardLayout)inspectionPanel.getLayout()).show(inspectionPanel, result);
			}
			
			

		}
		
		else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel.NAME) {
			if (e.getActionCommand().equals(ButtonsPanel.CANCEL)) {
				
				((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
				//inspectionPanel.getNewInspectionPanel().setCheck(1);
			}
			else if (e.getActionCommand().equals(ButtonsPanel.CONFIRM)) {
				
				Vehicle v = null;
				try {
					v = inspectionPanel.getNewInspectionPanel().getVehicle();
				} catch (CustomsIllegalArgumentException e1) {
					JOptionPane.showMessageDialog(this,
						    "Wrong parametres for driver or vehicle:\n" + e1.getMessage(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
					v = null;
					//e1.printStackTrace();
					
				}
				if (v != null) {
					System.out.println(v + "\n" + v.getDriver());
					((CardLayout)inspectionPanel.getLayout()).show(inspectionPanel, InspectionPanel.ADD_END_INSPECTION);
				}
	
			}

		}
		
		else if (inspectionPanel.getCurrentPanel().toString() == TodaysInspections.NAME) {
			if (e.getActionCommand().equals(ButtonsPanel.CANCEL)) {
				
				((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
				//inspectionPanel.getNewInspectionPanel().setCheck(1);
			}
		}
		
		
		// set buttons;
		if (inspectionPanel.getCurrentPanel().toString() == MainPanel.NAME) {
			
			bPanel.setOk(false);
			bPanel.setConfirm(true);
			bPanel.setCancel(false);
		}
		
		else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel.NAME) {
			
			bPanel.setOk(false);
			bPanel.setConfirm(true);
			bPanel.setCancel(true);
		}
		else if (inspectionPanel.getCurrentPanel().toString() == TodaysInspections.NAME) {
			
			bPanel.setOk(false);
			bPanel.setConfirm(false);
			bPanel.setCancel(true);
		}

		
		
	}
	
	

}
