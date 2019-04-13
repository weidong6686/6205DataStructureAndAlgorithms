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
	//You can add any number of private data members
	//You can add any number of private functions
	private double cost;

	Kruskal() {
		super("C:\\work\\java\\graphexamples\\") ; //Change to directory where U have input graph files
		testBench();
	}

	@Override
	protected double getMSTCost() {
		//WRITE CODE
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