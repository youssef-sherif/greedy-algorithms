package main;

public class Edge {
		
	private int vertexU;
	private int vertexV;
	private boolean known;
	private int weight;	
		
	public int getVertexU() {
		return vertexU;
	}	
	public void setVertexU(int vertexU) {
		this.vertexU = vertexU;
	}
	public int getVertexV() {
		return vertexV;
	}
	public void setVertexV(int vertexV) {
		this.vertexV = vertexV;
	}	
	public boolean isKnown() {
		return known;
	}
	public void setKnown(boolean known) {
		this.known = known;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}		

}
