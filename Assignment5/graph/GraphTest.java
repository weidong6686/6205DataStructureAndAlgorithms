import java.util.ArrayList;

/**
 * File Name: GraphTest.java 
 * Tests Graph object
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */
/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.java
 */

class GraphTest{
	private static final String outputFileBase = "C:\\work\\java\\fig\\";
	/*----------YOU CANNOT CHANGE ANYTHING BELOW ----------------------------*/
	private static final IntUtil u = new IntUtil();
	public enum GraphType {
		NONE, UNDIRECTED , DIRECTED, WEIGHTED_UNDIRECTED, WEIGHTED_DIRECTED 
	}
	
	GraphTest() {
		testBed() ;
	}
	
	private String[][] getGraphSpec(int i) {
		String [][] g0 = { 
				{"1","2"}, 
				{"1","3"},
				{"1","4"},
				{"2","5"},
				{"2","4"},
				{"3","6"},
				{"3","4"},
				{"4","5"},
				{"4","7"},
				{"7","5"},
				{"7","6"},
				{"6","4"},

		} ;
		String [][] g1 = { 
				{"0","5"}, 
				{"2","4"},
				{"2","3"},
				{"2","5"},
				{"1","2"},
				{"0","1"},
				{"3","4"},
				{"3","5"},
				{"0","2"},

		} ;
		String [][] g2 = { 
				{"1","2","6.2"}, 
				{"1","3","1.2"},
				{"1","4","5"},
				{"2","3","5.2"},
				{"2","5","3.2"},
				{"3","4","5"},
				{"3","5","4"},
				{"3","6","4"},
				{"4","6","2"},
				{"5","6","6"},
		} ;
		String [][] g3 = {
				{"A","B"}, 
				{"E","F"},
				{"E","D"},
				{"C","E"},
				{"B","C"},
				{"D","B"},
		} ;
		String [][] g4 = {
				{"A","C","12.8"}, 
				{"A","D","60"},
				{"B","A","10"},
				{"C","B","20"},
				{"C","D","32.9"},
				{"E","A","7"},
		} ;
		String [][] g5 = {
				{"1","2"}, 
				{"1","3"},
				{"2","4"},
				{"3","4"},
				{"4","5"},
		} ;
		
		
		String [][][] g = {g0,g1,g2,g3,g4,g5} ;
		return g[i] ;
	}

	private void u1() {
		Graph g = new Graph() ;
		GraphTest.GraphType t = GraphTest.GraphType.UNDIRECTED ;
		g.buildGraph(t,getGraphSpec(0));
		g.writeDot(outputFileBase + "0.dot") ;
	}

	private void uw1() {
		Graph g = new Graph() ;
		GraphTest.GraphType t = GraphTest.GraphType.WEIGHTED_UNDIRECTED ;
		g.buildGraph(t,getGraphSpec(2));
		g.writeDot(outputFileBase + "2.dot") ;
	}

	private void d1() {
		Graph g = new Graph() ;
		GraphTest.GraphType t = GraphTest.GraphType.DIRECTED ;
		g.buildGraph(t,getGraphSpec(3));
		g.writeDot(outputFileBase + "3.dot") ;
	}

	private void dw1() {
		Graph g = new Graph() ;
		GraphTest.GraphType t = GraphTest.GraphType.WEIGHTED_DIRECTED ;
		g.buildGraph(t,getGraphSpec(4));
		g.writeDot(outputFileBase + "4.dot") ;
	}
	
	private void testGraphRepresentation() {
		u1() ;
		uw1() ;
		d1() ;
		dw1() ;
	}

	private void testDFS() {
		{
			//DAG
			Graph g = new Graph() ;
			String [][] e = {
					{"1","2"}, 
					{"1","3"},
					{"2","4"},
					{"3","4"},
					{"4","5"},
			} ;
			GraphTest.GraphType t = GraphTest.GraphType.DIRECTED ;
			g.buildGraph(t,e);
			g.writeDot("dfs1.dot") ;

			String s = "1" ; //Starting city
			ArrayList<String> ans = new ArrayList<String>() ;
			boolean[] cycle = {false} ;
			int[] work = {0} ;
			g.dfs("Example 1",s,cycle,work,ans) ;
			//g.dfs("",s,cycle,work,ans) ; //This will not print
		}
		{
			//Directed graph with cycle
			Graph g = new Graph() ;
			String [][] e = {
					{"0","1"}, 
					{"0","2"},
					{"1","3"},
					{"2","3"},
					{"3","4"},
					{"4","2"},
			} ;
			GraphTest.GraphType t = GraphTest.GraphType.DIRECTED ;
			g.buildGraph(t,e);
			g.writeDot("dfs1.dot") ;

			String s = "0" ; //Starting city
			ArrayList<String> ans = new ArrayList<String>() ;
			boolean[] cycle = {false} ;
			int[] work = {0} ;
			g.dfs("Example 2",s,cycle,work,ans) ;
		}

		{
			//UnDirected graph with cycle
			Graph g = new Graph() ;
			String [][] e = {
					{"1","0"}, 
					{"1","2"},
					{"0","3"},
					{"0","2"},
					{"3","4"},
			} ;
			GraphTest.GraphType t = GraphTest.GraphType.UNDIRECTED ;
			g.buildGraph(t,e);
			g.writeDot("dfs3.dot") ;

			String s = "1" ; //Starting city
			ArrayList<String> ans = new ArrayList<String>() ;
			boolean[] cycle = {false} ;
			int[] work = {0} ;
			g.dfs("Example 3",s,cycle,work,ans) ;
			//g.dfs("",s,cycle,work,ans) ; //This will not print
		}

		{
			//UnDirected graph with NO cycle
			Graph g = new Graph() ;
			String [][] e = {
					{"1","2"}, 
					{"1","4"},
					{"1","3"},
			} ;
			GraphTest.GraphType t = GraphTest.GraphType.UNDIRECTED ;
			g.buildGraph(t,e);
			g.writeDot("dfs4.dot") ;

			String s = "1" ; //Starting city
			ArrayList<String> ans = new ArrayList<String>() ;
			boolean[] cycle = {false} ;
			int[] work = {0} ;
			g.dfs("Example 4",s,cycle,work,ans) ;
			//g.dfs("",s,cycle,work,ans) ; //This will not print
		}

		{
			//Directed weighted Acyclic graph
			Graph g = new Graph() ;
			String [][] e = { 
					{"0","2","5"},
					{"0","3","3"},
					{"0","1","14"},
					{"1","6","6"},
					{"1","4","7"},
					{"2","5","2"},
					{"2","4","3"},
					{"3","2","11"},
					{"3","4","7"},
					{"3","1","6"},
					{"4","6","5"},
					{"5","6","7"},      

			} ;
			GraphTest.GraphType t = GraphTest.GraphType.WEIGHTED_DIRECTED ;
			g.buildGraph(t,e);
			g.writeDot("dfs5.dot") ;
			String s = "0" ; //Starting city
			ArrayList<String> ans = new ArrayList<String>() ;
			boolean[] cycle = {false} ;
			int[] work = {0} ;
			g.dfs("Example 5",s,cycle,work,ans) ;
		}
	}
	
	private void testBed() {
		testGraphRepresentation() ;
		//testDFS() ;
	}
	
	public static void main(String[] args) {
    System.out.println("GraphTest.java starts");
    GraphTest g = new GraphTest() ;
    System.out.println("GraphTest.java Ends");
  }
}