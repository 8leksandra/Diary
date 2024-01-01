package notatnik.menu;

import notatnik.windows.Window;

public class Edit {

	Window window;
		
	public Edit(Window window) {
		this.window = window;
	}
	
	public void undo() {
		window.undoManager.undo();
	}
	
	public void redo() {
		window.undoManager.redo();
	}
}
