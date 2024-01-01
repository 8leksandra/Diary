package notatnik.menu;

import java.awt.FileDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import notatnik.utils.CustomTextPane;
import notatnik.windows.Window;

public class ClassFile {

	private Window window;
	private String fileName, filePath;
	private String filename = null; 

    final CustomTextPane textPane = new CustomTextPane();
	
	public ClassFile(Window window) {
		this.window = window;//acces- dostęp do wszystkiego z klasy Window
	}
	
	public void file_New() {
		window.textPane.setText("");//nowy czysty plik - puste pole tekstowe
		window.frame.setTitle("New");
		fileName = null;//jak tworzymy nowy plik musimy zresetowac filename i filepath
		filePath = null;
	} 
	
	public void file_Open() {

		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		String filePath = file.getAbsolutePath();
		try {
			FileReader reader = new FileReader(filePath);
			BufferedReader br = new BufferedReader(reader);
			window.frame.setTitle(filePath);
			window.textPane.read(br, null);
			window.textPane.requestFocus();
			br.close();
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found: " + file,
			        							"Error", 
			        							JOptionPane.ERROR_MESSAGE);
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "There is a problem with the file!" + file,
			        							"Error", 
			        							JOptionPane.ERROR_MESSAGE);
		}
	}

	public void file_Save() {

		if (filename == null) { 
			file_SaveAs();
		}
		
		if (filename != null) {
			try {
				FileOutputStream fos = new FileOutputStream(filename + ".rtf");
				RTFEditorKit kit = (RTFEditorKit) window.textPane.getEditorKit();
				StyledDocument doc = window.textPane.getStyledDocument();
				int len = doc.getLength();
				kit.write(fos, doc, 0, len);
				fos.close();
				JOptionPane.showMessageDialog(null, "Saved to " + filename,
						"Save File", 
						JOptionPane.PLAIN_MESSAGE);
			} 
			catch (IOException | BadLocationException e) {
				JOptionPane.showMessageDialog(null, "Failed to save the file!" + filename,
						"Error", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void file_SaveAs() {
	
		FileDialog fd = new FileDialog(window.frame, "Save", FileDialog.SAVE);
	    fd.setVisible(true);
	    String filePath = fd.getDirectory();
	    String fileName = fd.getFile();
	    filename = filePath + fileName;
		try {
			FileOutputStream fos = new FileOutputStream(filename + ".rtf");
			RTFEditorKit kit = (RTFEditorKit) window.textPane.getEditorKit();
			StyledDocument doc = window.textPane.getStyledDocument();
			int len = doc.getLength();
			kit.write(fos, doc, 0, len);
			fos.close();
			JOptionPane.showMessageDialog(null, "Saved to " + filename,
					"Save File", 
					JOptionPane.PLAIN_MESSAGE);
			window.frame.setTitle(fileName);
		} 
		catch (IOException | BadLocationException e) {
			JOptionPane.showMessageDialog(null, "Failed to save the file!" + filename,
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void file_Print() {
		try {
            window.textPane.setContentType("text/html");
            boolean printed = window.textPane.print();
            if (printed) {
                JOptionPane.showMessageDialog(null, "Printing is done");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Printing in progress");
            }
        } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, "Error while printing");
        }
	}
	
	public void file_Exit() {
		System.exit(0);
	}
}
