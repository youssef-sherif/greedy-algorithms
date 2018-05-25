package main;

public class MinimumSpanningTree {

	private static int TOTAL_WEIGHT;
	private Edge[] mst;

	public MinimumSpanningTree(int[][] graph, int numberOfVertices) {
		this.mst = new Edge[numberOfVertices];
		init();
		build(graph, numberOfVertices);
	}

	private void init() {
		for (int i = 0; i < mst.length; i++) {
			mst[i] = new Edge();
		}

		for (int i = 0; i < mst.length; i++) {
			mst[i].setWeight(Integer.MAX_VALUE);
			mst[i].setKnown(false);
			mst[i].setVertexV(-1);
		}

		mst[0].setWeight(0);
	}

	private int computeMinEdge(Edge[] mst) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < mst.length; i++)
			if (!mst[i].isKnown() && mst[i].getWeight() <= min) {
				min = mst[i].getWeight();
				minIndex = i;
			}

		return minIndex;
	}

	private void build(int graph[][], int numberOfVertices) {

		for (int i = 0; i < numberOfVertices; i++) {
			int min = computeMinEdge(mst);
			mst[min].setKnown(true);

			for (int adjacent = 0; adjacent < numberOfVertices; adjacent++) {
				if (graph[min][adjacent] != 0 && !mst[adjacent].isKnown()
						&& graph[min][adjacent] < mst[adjacent].getWeight()) {
					mst[adjacent].setVertexU(min);
					mst[adjacent].setVertexV(adjacent);
					mst[adjacent].setWeight(graph[min][adjacent]);
					TOTAL_WEIGHT += mst[adjacent].getWeight();
				}
			}
		}
	}

	public void print() {
		System.out.println("Edge Total: " + TOTAL_WEIGHT);
		System.out.println("Minimum Spanning Tree: ");
		for (int i = 1; i < mst.length; i++) {
			System.out.println("\t\t" + mst[i].getVertexU() + " - " + mst[i].getVertexV());
		}
	}

}
