package customsSystem.gui.inspectionTabComponents;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TodaysInspections extends JPanel {

	public static final String NAME = "today";

	/**
	 * Create the panel.
	 */
	public TodaysInspections() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNiekoNaujoia = new JLabel("Nieko naujo \u010Dia....");
		lblNiekoNaujoia.setHorizontalAlignment(SwingConstants.CENTER);
		lblNiekoNaujoia.setFont(new Font("Tahoma", Font.PLAIN, 56));
		add(lblNiekoNaujoia, BorderLayout.CENTER);

	}
	
	public String toString() {
		return NAME;
	}

}
