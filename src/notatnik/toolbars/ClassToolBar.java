package notatnik.toolbars;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import notatnik.windows.Window;

public class ClassToolBar {

	Window window;
	boolean clicked = false;

	public ClassToolBar(Window window) {
		this.window = window;//robimy tym dostep do wszystkiego z klasy window
	}
	
	public void chooseStyle(String style) {
		
		switch(style) {
		case "B": 
			if(clicked == false) {
				clicked = true;
				window.bBold.setText("B");
				window.bBold.setFont(new Font("Arial", Font.BOLD, 22));
				MutableAttributeSet attribute1 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setBold(attribute1, true);
				window.textPane.setCharacterAttributes(attribute1, true);
			}
			else {
				clicked = false;
				window.bBold.setText("B");
				window.bBold.setFont(new Font("Arial", Font.PLAIN, 20));
				MutableAttributeSet attribute1 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setBold(attribute1, false);
				window.textPane.setCharacterAttributes(attribute1, true);
			}
		break;
		case "/": 
			if(clicked == false) {
				clicked = true;
				window.bItalic.setText(" / ");
				window.bItalic.setFont(new Font("Arial", Font.BOLD, 22));
				MutableAttributeSet attribute2 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setItalic(attribute2, true);
				window.textPane.setCharacterAttributes(attribute2, true);
			}
			else {
				clicked = false;
				window.bItalic.setText(" / ");
				window.bItalic.setFont(new Font("Arial", Font.PLAIN, 20));
				MutableAttributeSet attribute2 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setItalic(attribute2, false);
				window.textPane.setCharacterAttributes(attribute2, true);
			}
		break;
		case "U": 
			if(clicked == false) {
				clicked = true;
				window.bUnderline.setText("U");
				window.bUnderline.setFont(new Font("Arial", Font.BOLD, 22));
				MutableAttributeSet attribute3 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setUnderline(attribute3, true);
				window.textPane.setCharacterAttributes(attribute3, true);
			}
			else {
				clicked = false;
				window.bUnderline.setText("U");
				window.bUnderline.setFont(new Font("Arial", Font.PLAIN, 20));
				MutableAttributeSet attribute3 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setUnderline(attribute3, false);
				window.textPane.setCharacterAttributes(attribute3, true);
			}
		break;
		case "CM": 
			if(clicked == false) {
				clicked = true;
				MutableAttributeSet attribute4 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setBackground(attribute4, new Color(255, 215, 0));
				window.textPane.setCharacterAttributes(attribute4, true);
			}
			else {
				clicked = false;
				MutableAttributeSet attribute4 = new SimpleAttributeSet(window.textPane.getInputAttributes());
				StyleConstants.setBackground(attribute4, new Color(0, 0, 0, 0));
				window.textPane.setCharacterAttributes(attribute4, true);
			}
		break;
		}
	}
	
	public void chooseParagraph(String paragraph) {
		
		switch(paragraph) {
		case "Left": 
			MutableAttributeSet mutAtr1 = window.textPane.getInputAttributes();//tu robie to getInputAttribute zeby czcionka byla poierana z tego co juz wczeniej wybralismy bo jak dam new to da nowy rozmiar czcionki 
			StyleConstants.setAlignment(mutAtr1, StyleConstants.ALIGN_LEFT);
			window.textPane.setParagraphAttributes(mutAtr1, true);
		break;
		case "Right": 
			MutableAttributeSet mutAtr2 = window.textPane.getInputAttributes();
			StyleConstants.setAlignment(mutAtr2, StyleConstants.ALIGN_RIGHT);
			window.textPane.setParagraphAttributes(mutAtr2, true);
		break;
		case "Center": 
			MutableAttributeSet mutAtr3 = window.textPane.getInputAttributes();
			StyleConstants.setAlignment(mutAtr3, StyleConstants.ALIGN_CENTER);
			window.textPane.setParagraphAttributes(mutAtr3, true);
		break;
		case "Justify": 
			MutableAttributeSet mutAtr4 = window.textPane.getInputAttributes();
			StyleConstants.setAlignment(mutAtr4, StyleConstants.ALIGN_JUSTIFIED);
			window.textPane.setParagraphAttributes(mutAtr4, true);
		break;
		}
	}
}
