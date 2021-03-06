package customsSystem.gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonsPanel extends JPanel {
	
	public final static String BACK = "back";
	public final static String NEXT = "next";
	public final static String OK = "ok";

	
	private ActionListener listener = null;
	private JButton btnCancel;
	private JButton btnConfirm;
	private JButton btnOk;
	/**
	 * Create the panel.
	 */
	public ButtonsPanel(ActionListener main) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.listener = main; 
		//setBorder(BorderFactory.createTitledBorder("Mygtukai"));
		btnCancel = new JButton("Back");
		btnCancel.addActionListener(listener);
		btnCancel.setActionCommand(BACK);
		add(btnCancel);
		
		btnConfirm = new JButton("Next");
		btnConfirm.addActionListener(listener);
		btnConfirm.setActionCommand(NEXT);
		add(btnConfirm);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(listener);
		btnOk.setActionCommand(OK);
		add(btnOk);

	}
	
	public void setCancel(boolean a){
		btnCancel.setEnabled(a);
	}
	public void setCancelName(String a) {
		btnCancel.setText(a);
	}
	
	public void setOk(boolean a){
		btnOk.setEnabled(a);
	}
	public void setOkName(String a) {
		btnOk.setText(a);
	}
	
	public void setConfirm(boolean a){
		btnConfirm.setEnabled(a);
	}
	public void setConfirmName(String a) {
		btnConfirm.setText(a);
	}

}
