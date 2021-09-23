package example.triangle.controller;

import java.awt.Point;
import java.util.ArrayList;

import example.triangle.boundary.TrianglePuzzleApp;
import example.triangle.boundary.UpdataButton;
import example.triangle.model.Model;
import example.triangle.model.Node;
import example.triangle.model.Puzzle;

public class selectedNodeController {

	Model model;
	TrianglePuzzleApp app;

	public selectedNodeController(Model model, TrianglePuzzleApp app) {
		this.model = model;
		this.app = app;
	}

	public void ClickNode(Point point) {

		Puzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = model.getSelectedNode();

		if (!model.isWinnerCondition()) {
			for (Node node : puzzle) {
				if (node.contains(point)) {

					boolean isSelected = false;
					for (Node selectednode : selectedNodes) {
						if (selectednode.equals(node)) {
							model.unSelectNode(node);
							
							if(selectedNodes.size()==0) {
								UpdataButton.disableUnselect(app);
							}
							
							if (model.getAvailableSwap()) {
								UpdataButton.enableSwap(app);
							} else {
								UpdataButton.disableSwap(app);
							}
							isSelected = true;
							break;
						}
					}

					if (!isSelected) {
						if(selectedNodes.size()==0) {
							UpdataButton.enableUnselect(app);;
						}
						model.setSelectedNode(node);
						if (model.getAvailableSwap()) {
							UpdataButton.enableSwap(app);
						} else {
							UpdataButton.disableSwap(app);
						}
					}

					app.repaint();
				}
			}
		}

	}
}
