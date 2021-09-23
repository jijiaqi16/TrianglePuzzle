package example.triangle.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

import example.triangle.boundary.TrianglePuzzleApp;
import example.triangle.boundary.UpdataButton;
import example.triangle.model.Edge;
import example.triangle.model.Model;
import example.triangle.model.Node;

public class SwapController {
	Model model;
	TrianglePuzzleApp app;
	
	public SwapController(Model model, TrianglePuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	public void Swap() {
		model.edgeSwap();
		
		app.getSwapScoreLabel().setText(""+model.getScore());
		app.getMovesLabel().setText(""+model.getMoves());
		
		if(model.isWinnerCondition()) {
			System.out.println("You are Winner!"); 
			app.getWinner().setVisible(true);
			UpdataButton.disableSwap(app);
			UpdataButton.disableUnselect(app);
			app.repaint();
		}else {
			UpdataButton.disableSwap(app);
			UpdataButton.disableUnselect(app);
			app.repaint();
		}
		
		
		
		
	
	}
}
