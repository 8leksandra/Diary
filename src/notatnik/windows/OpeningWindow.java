package notatnik.windows;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel {

	private static final long serialVersionUID = -2013409094847063528L;
	
	JFrame openingWindow = new JFrame();
	
	public OpeningWindow(){
				
		openingWindow.add(this);
		openingWindow.setSize(250, 200);
		openingWindow.setBackground(Color.WHITE);
		openingWindow.setUndecorated(true);
		openingWindow.setLocationRelativeTo(null);
		openingWindow.setVisible(true);
		
		try {
			Thread.sleep(3000);
			openingWindow.dispose();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void paint(Graphics g) {
		ImageIcon background = new ImageIcon("res/BirdIcon.png");
		g.drawImage(background.getImage(), 30, 0, null);
	}
}
