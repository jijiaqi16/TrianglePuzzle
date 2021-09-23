package example.triangle.model;

import java.awt.Point;

public class Node {
	
	public final int width;
	public final int height;
	
	int row;
	int col;
	
	int nodeIndex;
	
	public Node(int row,int col,int width,int height,int index) {
		this.row = row;
		this.col = col;
		this.width = width;
		this.height = height;
		nodeIndex = index;
	
	}
	
	public void SetRow(int r) {this.row = r;}
	public int GetRow() {return row;}
	public void SetCol(int c) {this.col = c;}
	public int GetCol() {return col;}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {return true;}
		if(!(obj instanceof Node)) {return false;}
		
		Node node = (Node)obj;
		
		return (width == node.width)&&(height==node.height)&&(row==node.GetRow())&&(col == node.GetCol());
	}
	
	public boolean contains(Point point) {
		int pointX = point.x;
		int pointY = point.y;
		return (pointX>=row)&&(pointX<=row+width)&&(pointY>=col)&&(pointY<=col+height);
	}
}
