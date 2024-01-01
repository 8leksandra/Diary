package notatnik.utils;

import java.awt.Color;

import javax.swing.JTextPane;

public class CustomTextPane extends JTextPane {
	
	private static final long serialVersionUID = 1L;

    public CustomTextPane() {
        super();
        setOpaque(false);//must not be opaque
        this.setBackground(new Color(0, 0, 0, 0));
    }
}
