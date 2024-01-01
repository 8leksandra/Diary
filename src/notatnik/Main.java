package notatnik;

import javax.swing.SwingUtilities;

import notatnik.utils.PlayMusic;
import notatnik.windows.OpeningWindow;
import notatnik.windows.Window;

public class Main {

	public static PlayMusic playMusic;
	
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
			 
			@SuppressWarnings("unused")
			OpeningWindow ow = new OpeningWindow();
			
	            public void run() {
	                new Window().frame.setVisible(true);
	            }
	        });
		playMusic = new PlayMusic();
	}
}
