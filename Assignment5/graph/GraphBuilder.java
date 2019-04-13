/**
 * File Name: GraphBuilder.java 
 * All routines that builds Graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphBuilder.java
 */

class GraphBuilder{
	private Graph g ;
	//You can have any number of private variables
	private String[][] e ;

	GraphBuilder(Graph g, String[][] e) {
		this.g = g ;
		this.e = e ;
		buildGraph() ;
	}

	private void buildGraph() {
		//WRITE GRAPH
	}

	public static void main(String[] args) {
		System.out.println("GraphBuilder.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphBuilder.java Ends");
	}
}