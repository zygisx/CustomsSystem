package customsSystem.gui;

import javax.naming.directory.SearchResult;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import customsSystem.Customs;
import customsSystem.Inspection;
import customsSystem.gui.searchTabComponents.SearchEnterPanel;
import customsSystem.gui.searchTabComponents.SearchResultPanel;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.util.ArrayList;

public class SearchPanel extends JPanel implements ActionListener {
	
	public final static String SEARCH_ENTER = "enter";
	public final static String SEARCH_RESULT = "result";
	public final static String BUTTON_CLEAR = "clear";
	public final static String BUTTON_SEARCH = "search";
	
	private SearchEnterPanel panel1;
	private SearchResultPanel panel2;
	
	private Customs customs;
	
	/**
	 * Create the panel.
	 * @param customs 
	 */
	public SearchPanel(Customs customs) {
		this.customs = customs;
		setLayout(new CardLayout(0, 0));
		
		panel1 = new SearchEnterPanel(this.customs, this);
		panel2 = new SearchResultPanel(this, new ArrayList<Inspection>());
		
		add(panel1, SEARCH_ENTER);
		add(panel2, SEARCH_RESULT);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(BUTTON_CLEAR)) {
			panel1.clearAll();
		}
		else if (e.getActionCommand().equals(BUTTON_SEARCH)) {
			panel2.setSearchResult(panel1.getSearchResults());
			((CardLayout) getLayout()).next(this);
		}
		
	}

	public void backToFirst() {
		
		((CardLayout) getLayout()).first(this);
	}
	
	public void setCustoms(Customs customs) {
		this.customs = customs;
		this.panel1.update(this.customs);
	}

}
