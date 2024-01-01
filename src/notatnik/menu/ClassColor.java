package notatnik.menu;
import java.awt.Color;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import notatnik.windows.Window;

public class ClassColor {

	Window window;
	
	public ClassColor(Window window) {
		this.window = window;
	}
	
	public void chooseColor(String color) {
		
		switch(color) {
		case "Black": 
					  //window.frame.getContentPane().setBackground(Color.BLACK);
	        		  MutableAttributeSet cB = new SimpleAttributeSet(window.textPane.getInputAttributes());
					  StyleConstants.setForeground(cB, Color.BLACK);
					  window.textPane.setCharacterAttributes(cB, true);
		break;
		case "Blue":  
					  //window.frame.getContentPane().setBackground(Color.BLUE);
					  MutableAttributeSet cBlue = new SimpleAttributeSet(window.textPane.getInputAttributes());
					  StyleConstants.setForeground(cBlue, Color.BLUE);
					  window.textPane.setCharacterAttributes(cBlue, true);
		break;
		case "Green": 
					  //window.frame.getContentPane().setBackground(Color.GREEN);
			  		  MutableAttributeSet cG = new SimpleAttributeSet(window.textPane.getInputAttributes());
			  		  StyleConstants.setForeground(cG, Color.GREEN);
			  		  window.textPane.setCharacterAttributes(cG, true);
		break;
		case "Red":  
			          //window.frame.getContentPane().setBackground(Color.RED);
					  MutableAttributeSet cR = new SimpleAttributeSet(window.textPane.getInputAttributes());
					  StyleConstants.setForeground(cR, Color.RED);
					  window.textPane.setCharacterAttributes(cR, true);
		break;
		case "White": 
					  //window.frame.getContentPane().setBackground(Color.WHITE);
			  		  MutableAttributeSet cW = new SimpleAttributeSet(window.textPane.getInputAttributes());
					  StyleConstants.setForeground(cW, Color.WHITE);
					  window.textPane.setCharacterAttributes(cW, true);
		break;
		case "Sky Blue": 
					  //window.frame.getContentPane().setBackground(new Color(51, 153, 255));
					  MutableAttributeSet cSb = new SimpleAttributeSet(window.textPane.getInputAttributes());
			  		  StyleConstants.setForeground(cSb, new Color(51, 153, 255));
					  window.textPane.setCharacterAttributes(cSb, true);
		break;
		case "Grass Green": 
					  //window.frame.getContentPane().setBackground(new Color(51, 102, 0));
			  		  MutableAttributeSet cGG = new SimpleAttributeSet(window.textPane.getInputAttributes());
			  		  StyleConstants.setForeground(cGG, new Color(51, 102, 0));
					  window.textPane.setCharacterAttributes(cGG, true);
		break;
		case "Brown": //window.frame.getContentPane().setBackground(new Color(102, 51, 0));
					  MutableAttributeSet cBrown = new SimpleAttributeSet(window.textPane.getInputAttributes());
			  		  StyleConstants.setForeground(cBrown, new Color(102, 51, 0));
					  window.textPane.setCharacterAttributes(cBrown, true);
		break;
		}
	}
}
