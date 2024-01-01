package notatnik.toolbars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import notatnik.windows.Window;

public class ClassColorToolBar implements MouseListener {

	Window window;
	JToolBar colorToolBar;
	JLabel lBlack, lBlue1, lBlue2, lBrown1, lBrown2, lGold1, lGold2, lViolet, lOrange, lGreen1, lGreen2, lBeige, lCream, lPink, lRed, lWhite;
	
	public ClassColorToolBar(Window window) {
		this.window = window;
	}
	
	public void createColorToolBar() {
		colorToolBar = new JToolBar();
		colorToolBar.setFloatable(false);
		colorToolBar.setLayout(new FlowLayout());
		
		lBlack = new JLabel();
		lBlack.setPreferredSize(new Dimension(30, 30));
		lBlack.setBackground(Color.BLACK);
		lBlack.setOpaque(true);
		lBlack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBlack.addMouseListener(this);
		
		lBlue1 = new JLabel();
		lBlue1.setPreferredSize(new Dimension(30, 30));
		lBlue1.setBackground(new Color(0, 128, 255));
		lBlue1.setOpaque(true);
		lBlue1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBlue1.addMouseListener(this);
		
		lBlue2 = new JLabel();
		lBlue2.setPreferredSize(new Dimension(30, 30));
		lBlue2.setBackground(new Color(115, 194, 251));
		lBlue2.setOpaque(true);
		lBlue2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBlue2.addMouseListener(this);
		
		lGreen1 = new JLabel();
		lGreen1.setPreferredSize(new Dimension(30, 30));
		lGreen1.setBackground(new Color(46, 103, 84));
		lGreen1.setOpaque(true);
		lGreen1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lGreen1.addMouseListener(this);
		
		lGreen2 = new JLabel();
		lGreen2.setPreferredSize(new Dimension(30, 30));
		lGreen2.setBackground(new Color(65, 163, 23));
		lGreen2.setOpaque(true);
		lGreen2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lGreen2.addMouseListener(this);
		
		lBrown1 = new JLabel();
		lBrown1.setPreferredSize(new Dimension(30, 30));
		lBrown1.setBackground(new Color(74, 38, 0));
		lBrown1.setOpaque(true);
		lBrown1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBrown1.addMouseListener(this);
		
		lBrown2 = new JLabel();
		lBrown2.setPreferredSize(new Dimension(30, 30));
		lBrown2.setBackground(new Color(100, 70, 36));
		lBrown2.setOpaque(true);
		lBrown2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBrown2.addMouseListener(this);
		
		lGold1 = new JLabel();
		lGold1.setPreferredSize(new Dimension(30, 30));
		lGold1.setBackground(new Color(212, 175, 55));
		lGold1.setOpaque(true);
		lGold1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lGold1.addMouseListener(this);
		
		lGold2 = new JLabel();
		lGold2.setPreferredSize(new Dimension(30, 30));
		lGold2.setBackground(new Color(208, 153, 59));
		lGold2.setOpaque(true);
		lGold2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lGold2.addMouseListener(this);
		
		lOrange = new JLabel();
		lOrange.setPreferredSize(new Dimension(30, 30));
		lOrange.setBackground(new Color(231, 132, 0));
		lOrange.setOpaque(true);
		lOrange.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lOrange.addMouseListener(this);
		
		lViolet = new JLabel();
		lViolet.setPreferredSize(new Dimension(30, 30));
		lViolet.setBackground(new Color(201, 71, 245));
		lViolet.setOpaque(true);
		lViolet.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lViolet.addMouseListener(this);
		
		lCream = new JLabel();
		lCream.setPreferredSize(new Dimension(30, 30));
		lCream.setBackground(new Color(255, 252, 216));
		lCream.setOpaque(true);
		lCream.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lCream.addMouseListener(this);
		
		lBeige = new JLabel();
		lBeige.setPreferredSize(new Dimension(30, 30));
		lBeige.setBackground(new Color(207, 185, 151));
		lBeige.setOpaque(true);
		lBeige.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lBeige.addMouseListener(this);
		
		lPink = new JLabel();
		lPink.setPreferredSize(new Dimension(30, 30));
		lPink.setBackground(new Color(222, 165, 164));
		lPink.setOpaque(true);
		lPink.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lPink.addMouseListener(this);
		
		lRed = new JLabel();
		lRed.setPreferredSize(new Dimension(30, 30));
		lRed.setBackground(new Color(196, 44, 72));
		lRed.setOpaque(true);
		lRed.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lRed.addMouseListener(this);
		
		lWhite = new JLabel();
		lWhite.setBackground(Color.WHITE);
		lWhite.setOpaque(true);
		lWhite.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lWhite.setPreferredSize(new Dimension(30, 30));
		lWhite.addMouseListener(this);
		
		colorToolBar.add(lBlack);
		colorToolBar.add(lBlue1);
		colorToolBar.add(lBlue2);
		colorToolBar.add(lGreen1);
		colorToolBar.add(lGreen2);
		colorToolBar.add(lBrown1);
		colorToolBar.add(lBrown2);
		colorToolBar.add(lBeige);
		colorToolBar.add(lCream);
		colorToolBar.add(lGold1);
		colorToolBar.add(lGold2);
		colorToolBar.add(lOrange);
		colorToolBar.add(lViolet);
		colorToolBar.add(lPink);
		colorToolBar.add(lRed);
		colorToolBar.add(lWhite);

		window.frame.add(colorToolBar, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		Object color = e.getSource();

		if(color.equals(lBlack)) {
	        MutableAttributeSet cB = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cB, Color.BLACK);
			window.textPane.setCharacterAttributes(cB, true);
		}
		else if(color.equals(lBlue1)) {
	        MutableAttributeSet cBlue1 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cBlue1, new Color(0, 128, 255));
			window.textPane.setCharacterAttributes(cBlue1, true);
		}
		else if(color.equals(lBlue2)) {
	        MutableAttributeSet cBlue2 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cBlue2, new Color(115, 194, 251));
			window.textPane.setCharacterAttributes(cBlue2, true);
		}
		else if(color.equals(lGreen1)) {
	        MutableAttributeSet cG = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cG, new Color(46, 103, 84));
			window.textPane.setCharacterAttributes(cG, true);
		}
		else if(color.equals(lGreen2)) {
	        MutableAttributeSet cGG = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cGG, new Color(65, 163, 23));
			window.textPane.setCharacterAttributes(cGG, true);
		}
		else if(color.equals(lBrown1)) {
	        MutableAttributeSet cBrown1 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cBrown1, new Color(74, 38, 0));
			window.textPane.setCharacterAttributes(cBrown1, true);
		}
		else if(color.equals(lBrown2)) {
	        MutableAttributeSet cBrown2 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cBrown2, new Color(100, 70, 36));
			window.textPane.setCharacterAttributes(cBrown2, true);
		}
		else if(color.equals(lBeige)) {
	        MutableAttributeSet cBeige = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cBeige, new Color(207, 185, 151));
			window.textPane.setCharacterAttributes(cBeige, true);
		}
		else if(color.equals(lCream)) {
	        MutableAttributeSet cC = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cC, new Color(255, 252, 216));
			window.textPane.setCharacterAttributes(cC, true);
		}
		else if(color.equals(lGold1)) {
	        MutableAttributeSet cGo1 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cGo1, new Color(212, 175, 55));
			window.textPane.setCharacterAttributes(cGo1, true);
		}
		else if(color.equals(lGold2)) {
	        MutableAttributeSet cGo2 = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cGo2, new Color(208, 153, 59));
			window.textPane.setCharacterAttributes(cGo2, true);
		}
		else if(color.equals(lOrange)) {
	        MutableAttributeSet cO = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cO, new Color(231, 132, 0));
			window.textPane.setCharacterAttributes(cO, true);
		}
		else if(color.equals(lViolet)) {
	        MutableAttributeSet cV = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cV, new Color(201, 71, 245));
			window.textPane.setCharacterAttributes(cV, true);
		}
		else if(color.equals(lPink)) {
	        MutableAttributeSet cP = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cP, new Color(222, 165, 164));
			window.textPane.setCharacterAttributes(cP, true);
		}
		else if(color.equals(lRed)) {
	        MutableAttributeSet cR = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cR, new Color(196, 44, 72));
			window.textPane.setCharacterAttributes(cR, true);
		}
		else if(color.equals(lWhite)) {
	        MutableAttributeSet cW = new SimpleAttributeSet(window.textPane.getInputAttributes());
			StyleConstants.setForeground(cW, Color.WHITE);
			window.textPane.setCharacterAttributes(cW, true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object color = e.getSource();

		if(color.equals(lBlack)) {
			lBlack.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lBlue1)) {
			lBlue1.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lBlue2)) {
			lBlue2.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lGreen1)) {
			lGreen1.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lGreen2)) {
			lGreen2.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lBrown1)) {
			lBrown1.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lBrown2)) {
			lBrown2.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lBeige)) {
			lBeige.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lCream)) {
			lCream.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lGold1)) {
			lGold1.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lGold2)) {
			lGold2.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lOrange)) {
			lOrange.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lViolet)) {
			lViolet.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lPink)) {
			lPink.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lRed)) {
			lRed.setSize(new Dimension(33, 33));
		}
		else if(color.equals(lWhite)) {
			lWhite.setSize(new Dimension(33, 33));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object color = e.getSource();

		if(color.equals(lBlack)) {
			lBlack.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lBlue1)) {
			lBlue1.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lBlue2)) {
			lBlue2.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lGreen1)) {
			lGreen1.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lGreen2)) {
			lGreen2.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lBrown1)) {
			lBrown1.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lBrown2)) {
			lBrown2.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lBeige)) {
			lBeige.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lCream)) {
			lCream.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lGold1)) {
			lGold1.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lGold2)) {
			lGold2.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lOrange)) {
			lOrange.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lViolet)) {
			lViolet.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lPink)) {
			lPink.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lRed)) {
			lRed.setSize(new Dimension(30, 30));
		}
		else if(color.equals(lWhite)) {
			lWhite.setSize(new Dimension(30, 30));
		}
	}
}
