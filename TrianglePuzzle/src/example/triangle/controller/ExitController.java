package example.triangle.controller;

import javax.swing.JOptionPane;

import example.triangle.boundary.TrianglePuzzleApp;

public class ExitController {
	
	TrianglePuzzleApp app;
	
	public ExitController(TrianglePuzzleApp app) {
		this.app = app;
	}
	
	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you want to exit application?");
		if(c==JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
