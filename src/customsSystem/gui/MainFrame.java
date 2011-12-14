package customsSystem.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.Vehicle;
import customsSystem.Vehicle.VehicleType;
import customsSystem.exceptions.CustomsEmptyListException;
import customsSystem.exceptions.CustomsException;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.exceptions.CustomsNullArgumentException;
import customsSystem.exceptions.CustomsUnknownOfficerException;
import customsSystem.gui.inspectionTabComponents.AllInspections;
import customsSystem.gui.inspectionTabComponents.MainPanel;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel1;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel2;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;
import customsSystem.persons.CustomsOfficer;
import customsSystem.persons.Passenger;
import customsSystem.persons.VehicleDriver;
import customsSystem.persons.CustomsOfficer.Experience;
import customsSystem.util.Export;
import customsSystem.util.Import;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame implements ActionListener {

	public static final String DEFAULT_FILE_NAME = "customs.dat";
	
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	private ButtonsPanel bPanel;
	private InspectionPanel inspectionPanel;
	private OfficersPanel officersPanel;
	private Random rand;
	private Vehicle vehicle;
	
	
	private Customs customs = null;
	
	private int possibility = 30; // by default 30% possibility of yellow inspection 

	
	
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
			CustomsOfficer c2 = new CustomsOfficer("Justas", "Sinkevièius", "123458");
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
			this.customs = new Customs("PL", "Lazdijø pasienio punktas.");
			customs.addOfficer(p);
			customs.addOfficer(c1);
			customs.addOfficer(c2);
			customs.addOfficer(c3);
			
			customs.addInspection(i);
			customs.addInspection(i);
			i.setDate(2011, 12, 10);
			customs.addInspection(i1);
			customs.addInspection(i2);
			customs.addInspection(i3);
			customs.addInspection(i4);
			customs.addInspection(i5);
			customs.addInspection(i6);
			
			//System.out.println(customs.getInspectionsNum());
			
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
		//niekas(); //TODO delete this shit
		try {
			this.customs = new Customs("PL", "Lazdijø pasienio punktas.");
			
		} catch (CustomsNullArgumentException e) {
			JOptionPane.showMessageDialog(this,
				    "Unexpected error:\n" + e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		} 
		
		/* uncomment to have windows look
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,
				    "Unexpected error:\n" + e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}*/
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 700, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnFile);
		menuBar.add(mnSettings);
		
		JMenuItem mntmSetting = new JMenuItem("Random inspection setting");
		mntmSetting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RandomInspectionSettingFrame(MainFrame.this, possibility);
				
			}
		});
		mnSettings.add(mntmSetting);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mntmImport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser(new File(DEFAULT_FILE_NAME));
				int returnVal = fc.showDialog(MainFrame.this, "Import");
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					new Import(fc.getSelectedFile(), MainFrame.this).start();
				}
			}
		});
		mnFile.add(mntmImport);
		
		JMenuItem mExport = new JMenuItem("Export");
		mExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser(new File(DEFAULT_FILE_NAME));
				int returnVal = fc.showSaveDialog(MainFrame.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = new File(fc.getSelectedFile().getPath());
					if (! file.isFile())
						try {
							file.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					new Export(file, MainFrame.this.customs).start();
				}	
			}
		});
		mnFile.add(mExport);
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

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		bPanel = new ButtonsPanel((ActionListener) this);
		contentPane.add(bPanel, BorderLayout.SOUTH);
		bPanel.setOk(false);
		bPanel.setConfirm(true);
		bPanel.setCancel(false);
		
		
		inspectionPanel = new InspectionPanel(this.customs);
		tabbedPane.addTab("Inspections", null, inspectionPanel, null);
		
		officersPanel = new OfficersPanel(this.customs);
		tabbedPane.addTab("Officers", null, officersPanel, null);
		tabbedPane.addChangeListener(new ChangeListener() {
		    // This method is called whenever the selected tab changes
		    public void stateChanged(ChangeEvent evt) {
		        JTabbedPane pane = (JTabbedPane)evt.getSource();
		        int sel = pane.getSelectedIndex();
		        if (sel == 0) {
		        	bPanel.setVisible(true);
		        }
		        else if (sel == 1) {
		        	bPanel.setVisible(false);
		        }
		    }
		});
		
		rand = new Random();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// work
		if (tabbedPane.getSelectedIndex() == 0) {
			if (inspectionPanel.getCurrentPanel().toString() == MainPanel.NAME) {
				// persoku i langa kurio reikia
				if (e.getActionCommand().equals(ButtonsPanel.NEXT)) { /* +- veikia neturetu gliucint */
					String result = ((MainPanel) ((InspectionPanel) inspectionPanel).getMainPanel()).getSelectedRadioButtonCommand();
					((CardLayout)inspectionPanel.getLayout()).show(inspectionPanel, result);
				}
				
				
	
			}
			//NewInspectionPanel1
			else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel1.NAME) {
				if (e.getActionCommand().equals(ButtonsPanel.BACK)) {
					
					((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
					//inspectionPanel.getNewInspectionPanel().setCheck(1);
				}
				else if (e.getActionCommand().equals(ButtonsPanel.NEXT)) {
					
					vehicle = null;
					try {
						vehicle = inspectionPanel.getNewInspectionPanel1().getVehicle();
						if (! customs.checkVehicle(vehicle) || ! customs.checkDriver(vehicle.getDriver())) 
							inspectionPanel.getNewInspectionPanel2().setCheck(2);
						else if (rand.nextInt(100) < possibility) 
							inspectionPanel.getNewInspectionPanel2().setCheck(1);
						else 
							inspectionPanel.getNewInspectionPanel2().setCheck(0);
						
					} catch (CustomsIllegalArgumentException e1) {
						JOptionPane.showMessageDialog(this,
							    "Wrong parametres for driver or vehicle:\n" + e1.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						vehicle = null;
						
						
					}				
					if (vehicle != null) {
						//System.out.println(v + "\n" + v.getDriver());
						((CardLayout)inspectionPanel.getLayout()).show(inspectionPanel, InspectionPanel.ADD_INSPECTION_2);
					}
				}
			}
			// NewInspectionPanel2
			else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel2.NAME) {
				if (e.getActionCommand().equals(ButtonsPanel.BACK)) {
					
					((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
				}
				else if (e.getActionCommand().equals(ButtonsPanel.OK)) {	
					Inspection i;
					try {
						i = inspectionPanel.getNewInspectionPanel2().getInspection(vehicle);
						if (i != null) customs.addInspection(i);
						System.out.println(i);
					} catch (CustomsIllegalArgumentException e1) {
						JOptionPane.showMessageDialog(this,
							    "Wrong parametres inspection:\n" + e1.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						i = null;
					} catch (CustomsException e2) {
						JOptionPane.showMessageDialog(this,
							    "Error:\n" + e2.getMessage(),
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
						i = null;
					}
					if (i != null) {
						inspectionPanel.getNewInspectionPanel1().clearAll();
						inspectionPanel.getNewInspectionPanel2().clearAll();
						((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
					}
					
				}
				
			}
			
			else if (inspectionPanel.getCurrentPanel().toString() == TodaysInspections.NAME) {
				
				if (e.getActionCommand().equals(ButtonsPanel.BACK)) {
					//inspectionPanel.getTodaysInspections().update();
					((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
					//inspectionPanel.getNewInspectionPanel().setCheck(1);
				}
			}
			
			else if (inspectionPanel.getCurrentPanel().toString() == AllInspections.NAME) {
				if (e.getActionCommand().equals(ButtonsPanel.BACK)) {
					((CardLayout)inspectionPanel.getLayout()).first(inspectionPanel);
					//inspectionPanel.getNewInspectionPanel().setCheck(1);
				}
			}
		}
		else if (tabbedPane.getSelectedIndex() == 1) {
			
			// code for officers tab
			//officersPanel.update();
			
			
		}
		
		if (tabbedPane.getSelectedIndex() == 1) {
			officersPanel.update();
		}
		
		else if (inspectionPanel.getCurrentPanel().toString() == MainPanel.NAME) {
			
			bPanel.setOk(false);
			bPanel.setConfirm(true);
			bPanel.setCancel(false);
		}
		
		else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel1.NAME) {
			
			bPanel.setOk(false);
			bPanel.setConfirm(true);
			bPanel.setCancel(true);
		}
		else if (inspectionPanel.getCurrentPanel().toString() == NewInspectionPanel2.NAME) {
			inspectionPanel.getNewInspectionPanel2().update();
			
			bPanel.setOk(true);
			bPanel.setConfirm(false);
			bPanel.setCancel(true);
		}
		else if (inspectionPanel.getCurrentPanel().toString() == TodaysInspections.NAME) {
			
			inspectionPanel.getTodaysInspections().update();
			
			
			bPanel.setOk(false);
			bPanel.setConfirm(false);
			bPanel.setCancel(true);
		}
		else if (inspectionPanel.getCurrentPanel().toString() == AllInspections.NAME) {
			inspectionPanel.getAllInspections().update();
			
			
			bPanel.setOk(false);
			bPanel.setConfirm(false);
			bPanel.setCancel(true);
		}
		
	}
	
	public void setCustoms(Customs cust) {
		this.customs = cust;
		this.inspectionPanel.setCustoms(this.customs);
		this.officersPanel.setCustoms(this.customs);
		updateTables();
	}
	
	public void updateTables() {
		inspectionPanel.getTodaysInspections().update();
		inspectionPanel.getAllInspections().update();
		inspectionPanel.getNewInspectionPanel2().update();
		officersPanel.update();
	}
	
	public void setPossibility(int possibility) {
		this.possibility = possibility;
	}
	
}
