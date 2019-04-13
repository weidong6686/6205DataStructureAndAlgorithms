import java.util.ArrayList;

/**
 * File Name: GraphDfs.java 
 * All routines that builds Graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphDfs.java
 */

class GraphDfs{
	private String t ;
	private Graph g ;
	String start;
	//Output
	boolean [] cycle;
	int [] work ;
	ArrayList<String> ans;
	//You can have any number of private variables
	//Data used to solve the problem
	

	GraphDfs(String t, Graph g, String start, boolean [] cycle, int [] work, ArrayList<String> ans) {
		this.t = t ;
		this.g = g ;
		this.start = start;
		this.cycle = cycle ;
		this.work = work ;
		this.ans = ans ;

		dfs() ;
		printDFS();
		assertDFS() ;
	}

	private void printDFS(){
		//WRITE CODE
	}

	private void assertDFS() {
		//WRITE CODE
	}

	private void dfs() {
	//WRITE CODE
	}

	public static void main(String[] args) {
		System.out.println("GraphDfs.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDfs.java Ends");
	}
}