package main;

public class ShortestPath {

	private Edge[] shortestPath;
	private int startingVertex;
	
	public ShortestPath(int[][] graph, int numberOfVertices, int startingVertex) {
		this.shortestPath = new Edge[numberOfVertices];
		this.startingVertex = startingVertex;
		init();
		build(graph, numberOfVertices, startingVertex);
	}
	
	private void init() {
		for (int i = 0; i < shortestPath.length; i++) {
			shortestPath[i] = new Edge();
		}

		for (int i = 0; i < shortestPath.length; i++) {
			shortestPath[i].setWeight(Integer.MAX_VALUE);
			shortestPath[i].setKnown(false);
			shortestPath[i].setVertexV(-1);
			shortestPath[i].setVertexU(i);
		}		
		shortestPath[startingVertex].setWeight(0);
	}
	
	private int computeMinEdge(Edge[] shortestPath) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < shortestPath.length; i++) {
			if (!shortestPath[i].isKnown() && shortestPath[i].getWeight() <= min) {
				min = shortestPath[i].getWeight();
				minIndex = i;
			}
		}
		return minIndex;
	}

	private void build(int graph[][], int numberOfVertices, int startingVertex) {		
		
		for (int i = 0; i < numberOfVertices; i++) {

			int min = computeMinEdge(shortestPath);
			shortestPath[min].setKnown(true);

			for (int v = 0; v < numberOfVertices; v++) {
				
				if (!shortestPath[v].isKnown() && graph[min][v] != 0
						&&shortestPath[v].getWeight() > shortestPath[min].getWeight() + graph[min][v]) {
					shortestPath[v].setWeight(shortestPath[min].getWeight() + graph[min][v]);
					shortestPath[v].setVertexV(min);
				}
			}

		}		
	}

	
	public void print() {
		System.out.println("All Shortest Paths from " + startingVertex + " (right to left): ");
		for (int i = 0; i < shortestPath.length; i++) {
			if (shortestPath[i].getVertexV() == -1 && i != startingVertex) {
				System.out.println("\t\t" + "No Path");
				continue;
			} else if (shortestPath[i].getVertexV() == -1 && i == startingVertex) {
				System.out.println("\t\t" + i);
				continue;
			}
			System.out.print("\t\t" + shortestPath[i].getVertexU());
			int v = i;
			while (shortestPath[v].getVertexV() != -1) {
				v = shortestPath[v].getVertexV();
				System.out.print(" <- " + v);
			}
			System.out.println();
		}
	}
}
