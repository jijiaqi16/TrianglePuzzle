package example.triangle.controller;

import example.triangle.boundary.TrianglePuzzleApp;
import example.triangle.boundary.UpdataButton;
import example.triangle.model.Model;

public class ResetController {

	Model model;
	TrianglePuzzleApp app;
	
	public ResetController(Model model, TrianglePuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void reset() {
		model.Reset();
		
		app.getSwapScoreLabel().setText(""+model.getScore());
		app.getMovesLabel().setText(""+model.getMoves());
		UpdataButton.disableSwap(app);
		UpdataButton.disableUnselect(app);
		app.getWinner().setVisible(false);
		app.repaint();
	}
}
