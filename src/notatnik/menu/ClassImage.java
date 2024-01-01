package notatnik.menu;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import notatnik.windows.Window;

public class ClassImage {

	Window window;

	public ClassImage(Window window) {
		this.window = window;
	}
	
	public void addImage() {

	//otwiera pliki png i jpg w textpane ale nie zapisuje w rtf ani pdf
		JFileChooser open = new JFileChooser();
        open.showOpenDialog(null);
        File file = open.getSelectedFile();
        Icon image = new ImageIcon(String.valueOf(file));
        window.textPane.insertIcon(image);
	}
}
