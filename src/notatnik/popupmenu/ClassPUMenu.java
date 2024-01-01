package notatnik.popupmenu;

import notatnik.windows.Window;

public class ClassPUMenu {

	Window window;
	
	public ClassPUMenu(Window window) {
		this.window = window;
	}
	
	public void puMenu(String menu) {
		
		switch(menu) {
		case "Copy": 
			window.textPane.copy();
		break;
		case "Paste": 
			window.textPane.paste();
		break;
		case "Cut": 
			window.textPane.cut();
		break;
		case "Select All": 
			window.textPane.selectAll();
		break;
		}
	}
}
