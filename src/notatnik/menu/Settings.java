package notatnik.menu;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import notatnik.windows.Window;

public class Settings {

	Window window;
	
	public Settings(Window window) {
		this.window = window;
	}
	//w ponizszym kodzie tu gdzie jest Window czyli nazwa naszej klasy main wpisujemy zawsze nazwe klasy main jakbysmi chcieli w jakims innym programie zrobic tez look and feel

	public void chooseLookAndFeel(String LookAndFeelSettings) {
		switch(LookAndFeelSettings) {
		
		case "Graphite Look And Feel": 
	          try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		      //UIManager.put("TextPane.font", new Font("Arial", Font.PLAIN, 22));//defoltowa czcionka!!!!!!!!!! Moge sobie to zmieniać
			} catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }	
			SwingUtilities.updateComponentTreeUI(window.frame);//dzieki tej linijce dziela do calego okna!!!
		break;
		case "Luna Look And Feel":  
			  try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			  //UIManager.put("TextPane.font", new Font("Pacifico", Font.PLAIN, 22));//defoltowa czcionka!!!!!!!!!! Moge sobie to zmieniać
			} catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
			SwingUtilities.updateComponentTreeUI(window.frame);
	    break;
		
		case "Noire Look And Feel": 
	          try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			  //UIManager.put("TextPane.font", new Font("Times New Roman", Font.PLAIN, 22));//defoltowa czcionka!!!!!!!!!! Moge sobie to zmieniać
			} catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
			SwingUtilities.updateComponentTreeUI(window.frame);
	    break;
		case "Texture Look And Feel":  
	          try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			  //UIManager.put("TextPane.font", new Font("Comic Sans MS", Font.PLAIN, 22));//defoltowa czcionka!!!!!!!!!! Moge sobie to zmieniać
			} catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
			SwingUtilities.updateComponentTreeUI(window.frame);
		break;
		case "Nimbus":
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(window.frame);
		break;
		case "Motif":
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(window.frame);
		break;
		}
	}
}
