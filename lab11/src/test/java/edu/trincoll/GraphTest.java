package edu.trincoll;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GraphTest {
	static final int UNVISITED = 0;
	static final int VISITED = 1;
	static StringBuffer out = new StringBuffer("");
	static StringBuffer output = new StringBuffer("");

	public static void main(String args[]) throws FileNotFoundException, IOException {

		String file_name = "src\\test\\java\\edu\\trincoll\\testfile.in";
		// Create an object of Graphm
		Graph G = new Graphm();
		// Create a BufferedReader object to read the file
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(file_name)));

		G = createGraph(file, G);

		// Perform DFS and BFS
		DFS(G, 0);


		file = new BufferedReader(new InputStreamReader(new FileInputStream(file_name)));
		G = new Graphm();
		G = createGraph(file, G);
		BFS(G, 0);


		// Close the file
		file.close();
	}

	static Graph createGraph(BufferedReader file, Graph G) throws IOException {
		// To do: Complete this

		// Read files line by line
		// Initialize graph with input from line 2
		// Read the details (edges,wt) and call.setEdge

		// File format:
		// 1. First line: Title
		// 2. Second line: Number of vertices
		// 3. Third line: Type of graph (directed/undirected)
		// 4. Fourth line on: list of edges

		String line = file.readLine();
		// Read the first line (title)
		System.out.println("Line 1: " + line);

		// Read the second line (number of vertices)
		line = file.readLine();
		// System.out.println(line);
		StringTokenizer st = new StringTokenizer(line);
		int numVertices = Integer.parseInt(st.nextToken());
		// Check if the number of vertices is valid
		System.out.println("Number of vertices: " + numVertices);
		// Initialize the graph with the number of vertices
		G.Init(numVertices);

		// Read the third line (type of graph)
		line = file.readLine();
		st = new StringTokenizer(line);
		System.out.println("Graph type: " + st.nextToken());

		line = file.readLine();
		// Read the edges and weights
		while (line != null) {
			// System.out.println(line);
			st = new StringTokenizer(line);
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int wt = Integer.parseInt(st.nextToken());

			System.out.println("Vertex 1: " + v1 + ", Vertex 2: " + v2 + ", Weight: " + wt);
			// Call the setEdge method to add the edge to the graph
			G.setEdge(v1, v2, wt);

			line = file.readLine();
		}

		System.out.println("Graph created successfully!");

		return G;

	}

	/** Depth first search */
	static void DFS(Graph G, int v) {
		out = new StringBuffer("");

		out = DFSHelp(G, v);
		System.out.println("DFS output: " + out.toString());
	}

	/** Breadth first (queue-based) search */
	static void BFS(Graph G, int start) {
		out = new StringBuffer("");

		out = BFSHelp(G, start);
		System.out.println("BFS output: " + out.toString());
	}

	// You may implement additional helped methods to complete the methods above
	static StringBuffer DFSHelp(Graph G, int v){

		// Mark the vertex as visited
		G.setMark(v, VISITED);
		out.append(v + " ");

		// Visit all the neighbors of the vertex
		for (int w = G.first(v); w < G.n(); w = G.next(v, w)) {
			if (G.isEdge(v, w) && G.getMark(w) == UNVISITED) {
				DFSHelp(G, w);

			}
		}
		return out;
	}

	static StringBuffer BFSHelp(Graph G, int v) {
		// System.out.println("mark v:" + G.getMark(v));
		// mark the vertex as visited
		G.setMark(v, VISITED);
		out.append(v + " ");


		// Create a queue to hold the vertices to be visited
		Queue<Integer> queue = new AQueue<Integer>();
		queue.enqueue(v);

		// While the queue is not empty
		while (queue.length() != 0) {
			// System.out.println("Queue length: " + queue.length());
			int w = queue.dequeue();
			// for each unvisited vertex u adjacent to w
			// breadth first search
			// expected order 0 2 1 5 3 4
			for (int u = G.first(w); u < G.n(); u = G.next(w, u)) {
				// System.out.println("u: " + u);
				// check if there is an edge between w and u
				// and if u is unvisited
				// System.out.println("Mark U: " + G.getMark(u));
				if (G.isEdge(w, u) && G.getMark(u) == UNVISITED) {
				
					// mark u as visited
					G.setMark(u, VISITED);
					out.append(u + " ");
					// enqueue u
					queue.enqueue(u);
				}
			
			}
			
			// System.out.println("Queue length: " + queue.length());
			
		}

		return out;
	}


}
