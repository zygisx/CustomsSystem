package customsSystem.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.Vehicle;
import customsSystem.exceptions.CustomsException;
import customsSystem.exceptions.CustomsIllegalArgumentException;
import customsSystem.exceptions.CustomsNullArgumentException;
import customsSystem.gui.inspectionTabComponents.AllInspections;
import customsSystem.gui.inspectionTabComponents.MainPanel;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel1;
import customsSystem.gui.inspectionTabComponents.NewInspectionPanel2;
import customsSystem.gui.inspectionTabComponents.TodaysInspections;
import customsSystem.util.Export;
import customsSystem.util.Import;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame implements ActionListener {

	public static final String DEFAULT_FILE_NAME = "customs.dat";
	public static final String ICON_FILE = "/img/customs.gif";
	
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	private ButtonsPanel bPanel;
	private SearchPanel searchPanel;
	private InspectionPanel inspectionPanel;
	private OfficersPanel officersPanel;
	private Random rand;
	private Vehicle vehicle;
	
	
	private Customs customs = null;
	
	private int possibility = 30; // by default 30% possibility of yellow inspection 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		super("Customs system");
		//System.setProperty("file.encoding", "UTF-8");
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
		
		JMenuItem mntmCustomsName = new JMenuItem("Customs name");
		mntmCustomsName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = JOptionPane.showInputDialog(
	                    MainFrame.this,
	                    "Enter new customs name:",
	                    "Customs name",
	                    JOptionPane.PLAIN_MESSAGE);
				if (s == null || s.equals("")) return;
				try {
					MainFrame.this.customs.setCustomsName(s);
					MainFrame.this.inspectionPanel.getMainPanel().updateLabel();
				} catch (CustomsNullArgumentException e1) {
					JOptionPane.showMessageDialog(MainFrame.this,
						    "Wrong value. " + e1.getMessage(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
	             
				
			}
		});
		mnSettings.add(mntmCustomsName);
		
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
			@Override
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

		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		bPanel = new ButtonsPanel(this);
		contentPane.add(bPanel, BorderLayout.SOUTH);
		bPanel.setOk(false);
		bPanel.setConfirm(true);
		bPanel.setCancel(false);
		
		
		inspectionPanel = new InspectionPanel(this.customs);
		tabbedPane.addTab("Inspections", null, inspectionPanel, null);
		
		officersPanel = new OfficersPanel(this.customs);
		tabbedPane.addTab("Officers", null, officersPanel, null);
		
		searchPanel = new SearchPanel(this.customs);
		tabbedPane.addTab("Search", null, searchPanel, null);
		
		
		tabbedPane.addChangeListener(new ChangeListener() {
		    // This method is called whenever the selected tab changes
		    @Override
			public void stateChanged(ChangeEvent evt) {
		        JTabbedPane pane = (JTabbedPane)evt.getSource();
		        int sel = pane.getSelectedIndex();
		        if (sel == 0) {
		        	bPanel.setVisible(true);
		        }
		        else if (sel == 1) {
		        	bPanel.setVisible(false);
		        }
		        else if (sel == 2) {
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
				if (e.getActionCommand().equals(ButtonsPanel.NEXT)) { 
					String result = inspectionPanel.getMainPanel().getSelectedRadioButtonCommand();
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
		this.searchPanel.setCustoms(this.customs);
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
