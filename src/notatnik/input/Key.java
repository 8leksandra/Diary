package notatnik.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import notatnik.windows.Window;

public class Key implements KeyListener {

	Window window;
	
	public Key(Window window) {
		this.window = window;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {//jak wcisniety ctrl n to utworzy nowy plik
			window.classfile.file_New();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {//jak wcisniety ctrl o to otworzy
			window.classfile.file_Open();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {//jak wcisniety ctrl s to zapisze
			window.classfile.file_Save();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Q) {//jak wcisniety ctrl q to zamknie
			window.classfile.file_Exit();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
			window.file.doClick();//doClick oznacza ze zrobi nam kliknięcie w menu na file bez klikania tylko klawiszem kliknie
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
