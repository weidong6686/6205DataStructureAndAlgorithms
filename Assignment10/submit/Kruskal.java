import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * File Name: Kruskal.java 
 * Implementation of Kruskal algorithm
 * 
 * To Compile: IntUtil.java RandomInt.java SFSU.java KruskalBase.java Kruskal.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */


class Kruskal extends KruskalBase{
	private int edgeNum;
	private int nodeNum0;
	private int nodeNum;
	private  ArrayList<Edge> E; // use arraylist to save edges
	private HashSet<Integer>set; // saving and count nodes, if the nodes is not continuous;
	SUSF sf; 
	//You can add any number of private data members
	//You can add any number of private functions
	private double cost;
	
	public class Edge {
		public int i, j;
		double w;
		public Edge(int i, int j, double w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
	}
	
	Kruskal() {
		super("C:\\Users\\Thinkpad\\Desktop\\CS Study\\6205\\Assignment10\\graphexamples\\") ; //Change to directory where U have input graph files
		testBench();
	}


	public void readFile(String inFileName)  {
		try {
			FileReader file = new FileReader(inFileName);
			BufferedReader br=new BufferedReader(file);
			String s=null;
			nodeNum0 = Integer.parseInt(br.readLine());
			edgeNum = Integer.parseInt(br.readLine());
			int k = 0;
			E = new ArrayList<>();
			set = new HashSet<>();
			while((s=br.readLine())!= null){
				String[] arr=s.split(" ");
				if (arr.length != 3)  // filter error data
					continue;
				Edge e = new Edge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
				E.add(e);
				set.add(Integer.parseInt(arr[0]));
				set.add(Integer.parseInt(arr[1]));
				nodeNum = set.size();  // count practical node numbers if not continuous
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}	
	
	private void printEdge() {
		for (Edge e : E) {
			System.out.println(e.i + " " + e.j + " " + e.w);
		}
	}
	
	private void spanTree() {
		sf = new SUSF (nodeNum0+1, nodeNum);
		cost = 0;
		for (int k = 0; k < E.size(); k++) {
			int start=E.get(k).i, end=E.get(k).j;
			double weight = E.get(k).w;
			if (sf.F(start, end)) {
				if (d.show) {
					System.out.println(start+" -> "+end+" creates a loop");
					}
				}
			else {
				sf.U(start, end);
				cost += weight;
				if (d.show) 
					System.out.println(start+" -> "+end+" "+weight+"  Total cost "+cost);	
			}
		}
	}
	
	
	@Override
	protected double getMSTCost() {
		readFile(d.inFileName);
		if (d.show) {
			System.out.println("-------- Before Sort ---------------");
			printEdge();
		}
		E.sort((a, b) ->((a.w > b.w) ? 1 : -1));// sort by weight;
		if (d.show) {
			System.out.println("-------- After Sort ---------------");
			printEdge();
		}
		spanTree();
		System.out.println("Num cities     = "+nodeNum);
		System.out.println("Num Road built    = "+(nodeNum-1));
		System.out.println("MST COST    = "+cost);
		sf.P();
		return cost ;
	}

	public static void main(String[] args) {
		System.out.println("Kruskal problem STARTS");
		Kruskal m = new Kruskal() ;
		System.out.println("All tests passed");
		System.out.println("If you have enjoyed solving this interview problem write a review for me on linkedln");
		System.out.println("Kruskal problem ENDS");
	}
}