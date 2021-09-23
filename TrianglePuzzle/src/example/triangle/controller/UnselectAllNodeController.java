package example.triangle.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import example.triangle.boundary.TrianglePuzzleApp;
import example.triangle.boundary.UpdataButton;
import example.triangle.model.Edge;
import example.triangle.model.Model;
import example.triangle.model.Node;

public class UnselectAllNodeController {

	Model model;
	TrianglePuzzleApp app;

	public UnselectAllNodeController(Model model, TrianglePuzzleApp app) {
		this.model = model;
		this.app = app;
	}

	public void UnselectAll() {

		ArrayList<Node> selectedNodes = model.getSelectedNode();
		HashMap<String, Edge> swapEdges = model.getswapingEdges();

		selectedNodes.clear();
		swapEdges.clear();
		
		UpdataButton.disableUnselect(app);
		UpdataButton.disableSwap(app);
		
		app.repaint();
	}
}
