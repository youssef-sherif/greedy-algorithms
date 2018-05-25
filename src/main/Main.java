package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		try {
		System.out.println("Enter size of graph: ");
		int numberOfVertices = input.nextInt();

		System.out.println("Enter 1 for MST and 2 for Shortest Path: ");		
		int choice = input.nextInt();

		if (choice == 1 || choice == 2) {
			int[][] graph = new int[numberOfVertices][numberOfVertices];
			for(int i = 0; i < numberOfVertices; i++) {
				for(int j = 0; j < numberOfVertices; j++) {
					System.out.println("Enter location " + i + " " + j + ": ");
					graph[i][j] = input.nextInt();					
				}
			}
			
			if (choice == 1) {							
				MinimumSpanningTree mst = new MinimumSpanningTree(graph, numberOfVertices);
				mst.print();
			} else if (choice == 2) {
				System.out.println("Enter Start Vertex: ");
				int startVertex = input.nextInt();
				ShortestPath shortestPath = new ShortestPath(graph, numberOfVertices, startVertex);
				shortestPath.print();
			}
		} else {
			System.out.println("Invalid Choice");
		}
		
		} catch(Exception e) {
			System.out.println("error");
		}

		System.out.println("Bye");
		
		
		
//	    { 
//		{ 0, 0, 1, 7, 0, 0, 0, 0 },
//		{ 0, 0, 0, 1, 0, 9, 1, 0 },
//		{ 1, 0, 0, 0, 2, 0, 0, 0 }, 
//		{ 7, 1, 0, 0, 0, 0, 0, 6 }, 
//		{ 0, 0, 2, 0, 0, 0, 0, 0 },
//		{ 0, 9, 0, 0, 0, 0, 1, 8 }, 
//		{ 0, 1, 0, 0, 0, 1, 0, 0 }, 
//		{ 0, 0, 0, 6, 0, 8, 0, 0 } 
//		};

//		 {
//		 {0, 0, 9, 1, 0, 0, 0, 0},
//		 {0, 0, 9, 7, 0, 1, 0, 0},
//		 {9, 9, 0, 0, 0, 0, 0, 0},
//		 {1, 7, 0, 0, 0, 0, 0, 0},
//		 {0, 0, 0, 0, 0, 0, 0, 6},
//		 {0, 1, 0, 0, 0, 0, 0, 0},
//		 {0, 0, 0, 0, 0, 0, 0, 0},
//		 {0, 0, 0, 0, 6, 0, 0, 0}
//		 };

//		 {
//		 {0, 0, 0, 1, 7, 0, 0, 0},
//		 {0, 0, 0, 0, 0, 0, 9, 0},
//		 {0, 0, 0, 0, 0, 0, 0, 0},
//		 {1, 0, 0, 0, 0, 0, 0, 0},
//		 {7, 0, 0, 0, 0, 0, 0, 0},
//		 {0, 0, 0, 0, 0, 0, 3, 1},
//		 {0, 9, 0, 0, 0, 3, 0, 0},
//		 {0, 0, 0, 0, 0, 1, 0, 0}
//		 };
		
	}
}
