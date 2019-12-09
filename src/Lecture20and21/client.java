package Lecture20and21;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs graph = new Graphs();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 10);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 8);
		graph.addEdge("F", "G", 3);
		graph.addEdge("E", "G", 3);
		
		graph.display();
	//	System.out.println(graph.numEdges());
		
	//	graph.removeEdge("D", "E");
	//	graph.removeEdge("F", "E");
	//	graph.display();
//		System.out.println("****************");
//		graph.removeVertex("A");
//		graph.display();
//		
//		System.out.println(graph.hasPath("A", "G"));
//		System.out.println(graph.isConnected());
//		System.out.println(graph.getCC());
//		
//		System.out.println(graph.isBipartite());
		graph.Dijkstras("A");
		
	}

}
