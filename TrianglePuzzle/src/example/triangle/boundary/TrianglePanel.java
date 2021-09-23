package example.triangle.boundary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import example.triangle.model.Edge;
import example.triangle.model.Model;
import example.triangle.model.Node;
import example.triangle.model.Puzzle;

public class TrianglePanel extends JPanel {
	
	Model model;
	
	public TrianglePanel(Model model) {
		this.model = model;
	}
	
	public void edgePainting(Edge edge,Graphics2D g) {
		if(edge.getColor().equals("red")) {
			g.setColor(Color.red);
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}else if(edge.getColor().equals("green")) {
			g.setColor(new Color(0,153,76));
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}else if(edge.getColor().equals("blue")) {
			g.setColor(new Color(0,128,255));
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if(model==null) {return;}

		Puzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = model.getSelectedNode();
		
//edges drawing
		HashMap<String, Edge> edges = puzzle.getEdges();
		
		g2.setStroke(new BasicStroke(3.5f));
		for(Edge edge:edges.values()) {
			edgePainting(edge, g2);
		}
		
		HashMap<String, Edge> swapEdges = model.getswapingEdges();
		if(swapEdges.size()>=2) {
			g2.setStroke(new BasicStroke(15f));
			for(Edge edge:swapEdges.values()) {
				edgePainting(edge, g2);
			}
			
		}
//nodes drawing
		for(Node node:puzzle) {
			g2.setColor(new Color(0,76,153));
			Rectangle rectBack = new Rectangle(node.GetRow(),node.GetCol(),node.width,node.height);
			g2.fillRect(rectBack.x, rectBack.y, rectBack.width, rectBack.height);
			
			Rectangle rect = new Rectangle(node.GetRow()+1,node.GetCol()+1,node.width-2,node.height-2);
			boolean isSelected = false;
			for(Node selectnode:selectedNodes) {
				if(node.equals(selectnode)) {
					g.setColor(Color.black);
					isSelected = true;
					break;
				}
			}
			
			if(!isSelected) {
				g2.setColor(Color.white);
			}
			
			g2.fillRect(rect.x, rect.y, rect.width, rect.height);
		}

	}

}
