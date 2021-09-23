package example.triangle.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

	Puzzle puzzle;
	ArrayList<Node> selectedNodes = new ArrayList<Node>();
	HashMap<String, Edge> swapingEdges = new HashMap<String, Edge>();

	int score = 0;
	int EachTriangleScore = 0;
	int moves = 0;

	boolean availableSwap;
	String swapType = "";

	boolean isWinner;

	public void Model() {

	}

// get/set
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	public void setEachTriangleScore(int score) {
		EachTriangleScore = score;
	}

	public boolean getAvailableSwap() {
		return availableSwap;
	}

	public HashMap<String, Edge> getswapingEdges() {
		return swapingEdges;
	}

	public String getSwapType() {
		return swapType;
	}

	public int getMoves() {
		return moves;
	}

//puzzle
	public void setPuzzle(Puzzle p) {
		puzzle = p;
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}
//node

	// selected node
	public void setSelectedNode(Node node) {
		selectedNodes.add(node);
		setAvailableSwap();
	}

	public ArrayList<Node> getSelectedNode() {
		return selectedNodes;
	}

	public void clearSelectedNode() {
		selectedNodes.clear();
	}

	public void unSelectNode(Node node) {
		selectedNodes.remove(node);
		setAvailableSwap();
	}

	public void setAvailableSwap() {
		if (selectedNodes.size() == 3) {

			String edge1 = "" + selectedNodes.get(0).nodeIndex + selectedNodes.get(1).nodeIndex;
			String edge2 = "" + selectedNodes.get(1).nodeIndex + selectedNodes.get(2).nodeIndex;
			String edge3 = "" + selectedNodes.get(0).nodeIndex + selectedNodes.get(2).nodeIndex;

			String edge1Reverse = "" + selectedNodes.get(1).nodeIndex + selectedNodes.get(0).nodeIndex;
			String edge2Reverse = "" + selectedNodes.get(2).nodeIndex + selectedNodes.get(1).nodeIndex;
			String edge3Reverse = "" + selectedNodes.get(2).nodeIndex + selectedNodes.get(0).nodeIndex;

			HashMap<String, Edge> edges = puzzle.getEdges();
			int edgeCounter = 0;

			for (Map.Entry<String, Edge> entry : edges.entrySet()) {
				if (entry.getKey().equals(edge1) || entry.getKey().equals(edge1Reverse) || entry.getKey().equals(edge2)
						|| entry.getKey().equals(edge2Reverse) || entry.getKey().equals(edge3)
						|| entry.getKey().equals(edge3Reverse)) {
					edgeCounter++;
					swapingEdges.put(entry.getKey(), entry.getValue());
				}
			}

			if (edgeCounter < 2) {
				swapType = "";
				availableSwap = false;
				swapingEdges.clear();

			} else if (edgeCounter == 2) {
				swapType = "normal";
				availableSwap = true;
			} else {
				swapType = "triangle";
				availableSwap = true;
			}
		} else {
			swapType = "";
			swapingEdges.clear();
			availableSwap = false;
		}
	}

	public void edgeSwap() {

		int scoreChangebefore = 0;
		int scoreChangeafter = 0;

		ArrayList<Triangle> triangles = puzzle.triangles;
		HashMap<String, Edge> edges = puzzle.getEdges();
		ArrayList<String> swapEdgeName = new ArrayList<String>();

		scoreChangebefore = calculateScore(triangles);

		for (Map.Entry<String, Edge> swap : swapingEdges.entrySet()) {
			swapEdgeName.add(swap.getKey());
		}

		if (swapType.equals("normal")) {

			String colorTempString = "";
			Edge NormalEdge1 = edges.get(swapEdgeName.get(0));
			Edge NormalEdge2 = edges.get(swapEdgeName.get(1));
			colorTempString = NormalEdge1.getColor();
			NormalEdge1.setColor(NormalEdge2.getColor());
			NormalEdge2.setColor(colorTempString);

			moves++;
		} else if (swapType.equals("triangle")) {
			String colorTempString1 = "";
			String colorTempString2 = "";

			EdgesSort(swapEdgeName.get(0), swapEdgeName.get(1));
			EdgesSort(swapEdgeName.get(1), swapEdgeName.get(2));
			EdgesSort(swapEdgeName.get(0), swapEdgeName.get(1));
			Edge TriEdge1 = edges.get(swapEdgeName.get(0));
			Edge TriEdge2 = edges.get(swapEdgeName.get(1));
			Edge TriEdge3 = edges.get(swapEdgeName.get(2));

			colorTempString1 = TriEdge1.getColor();
			colorTempString2 = TriEdge2.getColor();
			TriEdge1.setColor(TriEdge3.getColor());
			TriEdge2.setColor(colorTempString1);
			TriEdge3.setColor(colorTempString2);

			moves++;
		}

		scoreChangeafter = calculateScore(triangles);
		score += scoreChangeafter - scoreChangebefore - 1;

		selectedNodes.clear();
		swapingEdges.clear();

		isWinnerCondition();

	}

	public void EdgesSort(String edgeName1, String edgeName2) {
		int edge1 = (int) edgeName1.charAt(0) + (int) edgeName1.charAt(1);
		int edge2 = (int) edgeName2.charAt(0) + (int) edgeName2.charAt(1);
		if (edge1 > edge2) {
			String tempString = "";
			tempString = edgeName1;
			edgeName1 = edgeName2;
			edgeName2 = tempString;
		}

	}

	public void Reset() {
		selectedNodes.clear();
		swapingEdges.clear();
		HashMap<String, Edge> edges = puzzle.getEdges();
		edges.clear();
		ArrayList<Triangle> triangles = puzzle.triangles;
		triangles.clear();

		for (Map.Entry<String, Edge> entry : puzzle.getEdgesTemplate().entrySet()) {
			edges.put(entry.getKey(), new Edge(entry.getValue().startNode, entry.getValue().endNode,
					entry.getValue().getColor(), entry.getValue().dir));
		}

		for (int i = 0; i < puzzle.triangleTemplate.size(); i = i + 3) {
			String edge1 = puzzle.triangleTemplate.get(i);
			String edge2 = puzzle.triangleTemplate.get(i + 1);
			String edge3 = puzzle.triangleTemplate.get(i + 2);
			puzzle.addTriangle(new Triangle(edges.get(edge1), edges.get(edge2), edges.get(edge3)));

		}

		availableSwap = false;
		swapType = "";
		score = 0;
		moves = 0;
	}

	public int calculateScore(ArrayList<Triangle> triangles) {

		ArrayList<String> winnerColor = puzzle.winnerTemplate;
		int sum = 0;
		int winnerColorIndex = 0;
		for (Triangle triangle : triangles) {

			if (triangle.left.getColor().equals(triangle.right.getColor())
					&& triangle.right.getColor().equals(triangle.bottom.getColor())
					&& triangle.left.getColor().equals(triangle.bottom.getColor())
					) {
				sum += EachTriangleScore;
			}
			winnerColorIndex++;
		}
		return sum;
	}

	public boolean isWinnerCondition() {

		int winnerTriInx = 0;

		for (Triangle triangle : puzzle.triangles) {
			if (triangle.left.getColor().equals(triangle.right.getColor())
					&& triangle.left.getColor().equals(triangle.bottom.getColor())
					&& triangle.right.getColor().equals(triangle.bottom.getColor())
					) {
				winnerTriInx++;
			} else {
				return false;
			}
		}
		return true;

	}

}
