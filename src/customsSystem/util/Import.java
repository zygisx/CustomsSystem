package customsSystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import customsSystem.Customs;
import customsSystem.gui.MainFrame;

public class Import extends Thread {

	private final File fileName;
	private final MainFrame main;
	
	public Import (File fileName, MainFrame main) {
		this.fileName = fileName;
		this.main = main;
	}
	
	public void run()  {
		ObjectInputStream inputStream;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(fileName));
			main.setCustoms( (Customs) (inputStream.readObject()));
			
			main.setHeader("");
			JOptionPane.showMessageDialog(null,
				    "Import succesfull.");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
				    "Fatal error: " + e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		} 

		 
		 
	}
}
