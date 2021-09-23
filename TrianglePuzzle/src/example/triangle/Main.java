package example.triangle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;


import example.triangle.controller.ExitController;
import example.triangle.boundary.TrianglePuzzleApp;
import example.triangle.model.Edge;
import example.triangle.model.Model;
import example.triangle.model.Node;
import example.triangle.model.Puzzle;
import example.triangle.model.Triangle;


public class Main {
	
	public static void main(String[] args) {
		
		Model model = new Model();
		
//node
		Puzzle puzzle = new Puzzle();
		puzzle.add(new Node(242,60,16,16,0));
		
		puzzle.add(new Node(192,147,16,16,1));
		puzzle.add(new Node(292,147,16,16,2));
		
		puzzle.add(new Node(142,234,16,16,3));
		puzzle.add(new Node(242,234,16,16,4));
		puzzle.add(new Node(342,234,16,16,5));
		
		puzzle.add(new Node(92,321,16,16,6));
		puzzle.add(new Node(192,321,16,16,7));
		puzzle.add(new Node(292,321,16,16,8));
		puzzle.add(new Node(392,321,16,16,9));
//edges
		//normal edges
		ArrayList<Node> nodes = puzzle.getNodes();
		puzzle.addEdges("01", new Edge(nodes.get(0), nodes.get(1), "red","left"));
		puzzle.addEdges("02", new Edge(nodes.get(0), nodes.get(2), "red","right"));
		puzzle.addEdges("12", new Edge(nodes.get(1), nodes.get(2), "green","bottom"));
		puzzle.addEdges("13", new Edge(nodes.get(1), nodes.get(3), "red","left"));
		puzzle.addEdges("14", new Edge(nodes.get(1), nodes.get(4), "blue","right"));
		puzzle.addEdges("24", new Edge(nodes.get(2), nodes.get(4), "blue","left"));
		puzzle.addEdges("25", new Edge(nodes.get(2), nodes.get(5), "red","right"));
		puzzle.addEdges("34", new Edge(nodes.get(3), nodes.get(4), "green","bottom"));
		puzzle.addEdges("45", new Edge(nodes.get(4), nodes.get(5), "green","bottom"));
		puzzle.addEdges("36", new Edge(nodes.get(3), nodes.get(6), "red","left"));
		puzzle.addEdges("37", new Edge(nodes.get(3), nodes.get(7), "blue","right"));
		puzzle.addEdges("47", new Edge(nodes.get(4), nodes.get(7), "blue","left"));
		puzzle.addEdges("48", new Edge(nodes.get(4), nodes.get(8), "blue","right"));
		puzzle.addEdges("58", new Edge(nodes.get(5), nodes.get(8), "blue","left"));
		puzzle.addEdges("59", new Edge(nodes.get(5), nodes.get(9), "red","right"));
		puzzle.addEdges("67", new Edge(nodes.get(6), nodes.get(7), "green","bottom"));
		puzzle.addEdges("78", new Edge(nodes.get(7), nodes.get(8), "green","bottom"));
		puzzle.addEdges("89", new Edge(nodes.get(8), nodes.get(9), "green","bottom"));
		//template edges
		puzzle.addEdgesTemplate("01", new Edge(nodes.get(0), nodes.get(1), "red","left"));
		puzzle.addEdgesTemplate("02", new Edge(nodes.get(0), nodes.get(2), "red","right"));
		puzzle.addEdgesTemplate("12", new Edge(nodes.get(1), nodes.get(2), "green","bottom"));
		puzzle.addEdgesTemplate("13", new Edge(nodes.get(1), nodes.get(3), "red","left"));
		puzzle.addEdgesTemplate("14", new Edge(nodes.get(1), nodes.get(4), "blue","right"));
		puzzle.addEdgesTemplate("24", new Edge(nodes.get(2), nodes.get(4), "blue","left"));
		puzzle.addEdgesTemplate("25", new Edge(nodes.get(2), nodes.get(5), "red","right"));
		puzzle.addEdgesTemplate("34", new Edge(nodes.get(3), nodes.get(4), "green","bottom"));
		puzzle.addEdgesTemplate("45", new Edge(nodes.get(4), nodes.get(5), "green","bottom"));
		puzzle.addEdgesTemplate("36", new Edge(nodes.get(3), nodes.get(6), "red","left"));
		puzzle.addEdgesTemplate("37", new Edge(nodes.get(3), nodes.get(7), "blue","right"));
		puzzle.addEdgesTemplate("47", new Edge(nodes.get(4), nodes.get(7), "blue","left"));
		puzzle.addEdgesTemplate("48", new Edge(nodes.get(4), nodes.get(8), "blue","right"));
		puzzle.addEdgesTemplate("58", new Edge(nodes.get(5), nodes.get(8), "blue","left"));
		puzzle.addEdgesTemplate("59", new Edge(nodes.get(5), nodes.get(9), "red","right"));
		puzzle.addEdgesTemplate("67", new Edge(nodes.get(6), nodes.get(7), "green","bottom"));
		puzzle.addEdgesTemplate("78", new Edge(nodes.get(7), nodes.get(8), "green","bottom"));
		puzzle.addEdgesTemplate("89", new Edge(nodes.get(8), nodes.get(9), "green","bottom"));
//triangle
		HashMap<String, Edge> edges = puzzle.getEdges();
		puzzle.InitTriangle(new Triangle(edges.get("01"),edges.get("02"),edges.get("12")),"01","02","12","red");
		puzzle.InitTriangle(new Triangle(edges.get("13"),edges.get("14"),edges.get("34")),"13","14","34","blue");
		puzzle.InitTriangle(new Triangle(edges.get("24"),edges.get("25"),edges.get("45")),"24","25","45","green");
		puzzle.InitTriangle(new Triangle(edges.get("36"),edges.get("37"),edges.get("67")),"36","37","67","green");
		puzzle.InitTriangle(new Triangle(edges.get("47"),edges.get("48"),edges.get("78")),"47","48","78","red");
		puzzle.InitTriangle(new Triangle(edges.get("58"),edges.get("59"),edges.get("89")),"58","59","89","blue");
		model.setPuzzle(puzzle);
//score
		model.setEachTriangleScore(10);
		
		TrianglePuzzleApp app = new TrianglePuzzleApp(model);
		
		app.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		app.getWinner().setVisible(false);
		app.setVisible(true);
	}

}
