import java.io.FileWriter;
import java.io.IOException;


/**
 * File Name: GraphDot.java 
 * Writes graph as a dot file
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphDot.java
 */

class GraphDot{
	private Graph g ;
	private String fname;
	//You can have any number of private variables
	private String[][] e ;

	GraphDot(Graph g, String s) {
		this.g = g ;
		this.fname = s ;
		writeDot() ;
	}

	private void writeDot() {
		//WRITE CODE
	}

	public static void main(String[] args) {
		System.out.println("GraphDot.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDot.java Ends");
	}
}