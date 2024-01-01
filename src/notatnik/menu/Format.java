package notatnik.menu;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import notatnik.windows.Window;

public class Format {

	Window window;
	String selectedFont, selectedSize;

	public Format(Window window) {
		this.window = window;
	}
	
	public void setSize(String size) {

		selectedSize = size;
		
		switch(selectedSize) {
		case "8": 
			MutableAttributeSet S8 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S8, 8);
			window.textPane.setCharacterAttributes(S8, true);
		break;
		case "10": 
			MutableAttributeSet S10 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S10, 10);
			window.textPane.setCharacterAttributes(S10, true);
		break;
		case "12": 
			MutableAttributeSet S12 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S12, 12);
			window.textPane.setCharacterAttributes(S12, true);
		break;
		case "14": 
			MutableAttributeSet S14 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S14, 14);
			window.textPane.setCharacterAttributes(S14, true);
		break;
		case "16": 
			MutableAttributeSet S16 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S16, 16);
			window.textPane.setCharacterAttributes(S16, true);
		break;
		case "18": 
			MutableAttributeSet S18 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S18, 18);
			window.textPane.setCharacterAttributes(S18, true);
		break;
		case "20": 
			MutableAttributeSet S20 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S20, 20);
			window.textPane.setCharacterAttributes(S20, true);
		break;
		case "22": 
			MutableAttributeSet S22 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontSize(S22, 22);
			window.textPane.setCharacterAttributes(S22, true);
		break;
		}
	}
	
	public void setFont(String font) {

		selectedFont = font;
		
		switch(selectedFont) {
		case "Arial": 
			MutableAttributeSet a = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontFamily(a, "Arial");
			window.textPane.setCharacterAttributes(a, true);
		break;
		case "Comic Sans MS": 
			MutableAttributeSet c = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontFamily(c, "Comic Sans MS");
			window.textPane.setCharacterAttributes(c, true);
		break;
		case "Pacifico": 
			MutableAttributeSet p = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontFamily(p, "Pacifico");
			window.textPane.setCharacterAttributes(p, true);
		break;
		case "Times New Roman": 
			MutableAttributeSet t = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setFontFamily(t, "Times New Roman");
			window.textPane.setCharacterAttributes(t, true);
		break;
		}
	}
}
