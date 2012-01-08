package customsSystem.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RandomInspectionSettingFrame extends JFrame {

	public static final int MIN = 0;
    public static final int MAX = 100;
	
    private JLabel lblPossibility;
	private JPanel contentPane;
	private JSlider slider;
	private MainFrame frame;

	/**
	 * Create the frame.
	 */
	public RandomInspectionSettingFrame(MainFrame frame, int init) {
		this.frame = frame;
		this.frame.setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Random inspection possibility");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
	
		
		slider = new JSlider(JSlider.HORIZONTAL,
                MIN, MAX, init);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblPossibility.setText("Possibility: " + slider.getValue());			
			}
		});
		
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
		panel.add(slider);
		
		lblPossibility = new JLabel("Possibility: " + init);
		lblPossibility.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblPossibility);
		

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RandomInspectionSettingFrame.this.frame.setEnabled(true);
				dispose();
			}
		});
		panel_1.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RandomInspectionSettingFrame.this.frame.setPossibility(slider.getValue());
				RandomInspectionSettingFrame.this.frame.setEnabled(true);
				dispose();
			}
		});
		panel_1.add(btnOk);
		
		setVisible(true);
	}

}
