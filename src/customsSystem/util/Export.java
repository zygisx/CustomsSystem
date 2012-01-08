package customsSystem.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import customsSystem.Customs;
import customsSystem.gui.MainFrame;

public class Export extends Thread {

	private final File fileName;
	private final MainFrame parent;
	
	public Export(File fileName, MainFrame parent) {
		this.fileName = fileName;
		this.parent = parent;
	}
	
	public void run() {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(this.parent.getCustoms());
			
			parent.setHeader("");
			JOptionPane.showMessageDialog(null,
			    "Export succesfull.");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
				    e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                parent.setHeader("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
		
		 
	}
}
