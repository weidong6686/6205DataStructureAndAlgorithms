import java.util.ArrayList;
import java.util.Collections;

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
		System.out.println("Num Verticaes = "+ g.getnumV( ));
		System.out.println("Num Edges = "+ g.getnumE( ));
		System.out.println("Work done = "+ this.work[0]);
		if (this.cycle[0]) 
			System.out.println("Has cycle = YES" );	
		else
			System.out.println("Has cycle = NO" );	
		System.out.print("DFS topological order = ");
		StringBuilder sb = new StringBuilder( );
		for (String s : ans) {
			sb.append(s+" ");
		}
		System.out.println(sb.reverse( ).toString( ).trim( )); // reverse and output the order forward
	} 

	private void assertDFS() {
		if (!this.cycle[0]) {
			for (int i = ans.size( )-1; i >= 0 ; i-- ) {
				int id = g.insertOrFind(ans.get(i), true);
				g.setTemp(id, 0); //  set the node visited with the 0 value;
				for (int j = 0; j < g.numFanin(id); j++) {
					if (g.getTemp(g.getNodeFanin(id, j)) != 0) { // Fanin out visited means  dfs failed
						System.out.println("assert failed");
						break;
					} 	
				}
			}	
			System.out.println("dfs assert passed");
		}
		else {
			System.out.println("This order has no meaning");   
		}
	}

	private void dfs() {
	//WRITE CODE
		work(g.insertOrFind(this.start, true));
	}
	private void work(int id) {
	g.setTemp(id, 1);// set value 1 means node is visited 
	this.work[0]++;   //count the visit step
	for (int i = 0; i < g.numFanout(id); i++) {
		int flag = g.getTemp(g.getNodeFanout(id, i));
		this.work[0]++;  // count the step judging
		if(flag == 1) { // judge this fanout node was visited or not to decide cycle or not
			this.cycle[0] = true;
		}
		if (flag == 0) work (g.getNodeFanout(id, i));
	}
	g.setTemp(id, 2);//set value 2 means neighbor nodes are visited 
	ans.add(g.getRealName(id));
}
	public static void main(String[] args) {
		System.out.println("GraphDfs.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDfs.java Ends");
	}
}