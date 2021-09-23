package example.triangle.model;

public class Edge {
	
	int x1,x2,y1,y2;
	String colorString;
	Node startNode;
	Node endNode;
	String dir;
	
	
	

	public Edge(Node startNode,Node endNode,String color,String dir) {
		
		if(dir.equals("left")) {
			this.x1 = startNode.GetRow();
			this.y1 = startNode.GetCol()+startNode.height;
			this.x2 = endNode.GetRow()+endNode.width/2;
			this.y2 = endNode.GetCol();
		}else if(dir.equals("right")) {
			this.x1 = startNode.GetRow()+startNode.width;
			this.y1 = startNode.GetCol()+startNode.height;
			this.x2 = endNode.GetRow()+endNode.width/2;
			this.y2 = endNode.GetCol();
		}else if(dir.equals("bottom")) {
			this.x1 = startNode.GetRow()+startNode.width;
			this.y1 = startNode.GetCol()+startNode.height/2;
			this.x2 = endNode.GetRow();
			this.y2 = endNode.GetCol()+endNode.height/2;
		}
		
		this.startNode = startNode;
		this.endNode = endNode;
		this.colorString = color;
		this.dir = dir;
	}
	
	public String getColor() {return colorString;}
	public int getX1() {return x1;}
	public int getY1() {return y1;}
	public int getX2() {return x2;}
	public int getY2() {return y2;}

	public void setColor(String color) {
		this.colorString = color;
	}
}
