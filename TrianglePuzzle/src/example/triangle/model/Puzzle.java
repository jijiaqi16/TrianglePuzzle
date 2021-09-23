package example.triangle.model;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Puzzle implements Iterable<Node> {

	HashMap<String, Edge> edges = new HashMap<String, Edge>();

	ArrayList<Node> nodes = new ArrayList<Node>();

	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
	
	HashMap<String, Edge> edgesTemplate = new HashMap<String, Edge>();
	
	ArrayList<String> triangleTemplate = new ArrayList<String>(); 
	
	ArrayList<String> winnerTemplate = new ArrayList<String>(); 

	public Puzzle() {

	}

	public void add(Node node) {
		nodes.add(node);
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	@Override
	public Iterator<Node> iterator() {
		return nodes.iterator();
	}

	public void addEdges(String index, Edge edge) {
		if (nodes != null) {
			edges.put(index, edge);

		}
	}

	public void addEdgesTemplate(String index, Edge edge) {
		if (nodes != null) {
			edgesTemplate.put(index, edge);

		}
	}

	public HashMap<String, Edge> getEdges() {
		if (nodes == null) {
			return null;
		}
		return edges;
	}

	public HashMap<String, Edge> getEdgesTemplate() {
		return edgesTemplate;
	}
	
	public void InitTriangle(Triangle triangle,String edge1,String edge2,String edge3,String WinnerColor) {
		triangles.add(triangle);
		triangleTemplate.add(edge1);
		triangleTemplate.add(edge2);
		triangleTemplate.add(edge3);
		winnerTemplate.add(WinnerColor);
	}
	
	public void addTriangle(Triangle triangle) {
		triangles.add(triangle);
	}
}
