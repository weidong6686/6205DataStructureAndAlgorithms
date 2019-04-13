

/**
+++ * File Name: KruskalBase.java 
 * Kruskal Algorithm
 * 
 * To Compile: IntUtil.java RandomInt.java SFSU.java KruskalBase.java Kruskal.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * YOU CANNOT CHANGE ANYTHING IN THIS FILE. READ ONLY
 */

abstract class KruskalBase{
	class data {
		//input
		protected String inFileName ;
		protected boolean show ;
	}
	
	//data members of KruskalBase class
	protected String base;
	protected IntUtil u;
	protected data d ;
	
	KruskalBase(String b) {
		base = new String(b) ;
		d = new data() ;
		u = new IntUtil();
	}
	
	protected boolean display() {
		return d.show ;
	}
	
	protected void testBench() {
		simpleTests()	;
	}
	
	//I don't know how to write it
  //Override by the concrete class
  abstract protected double getMSTCost() ;

  private void init(String t, String s, final boolean show) {
  	System.out.println("-------------------- " + t + " -------------------------------------") ;
  	d.inFileName = base + s ;
		d.show = show ;
	}

  private  void simpleTests() {
  	boolean show = true ;
    {

    	init("uw1.txt  MST OF 63","uw1.txt",true) ;
    	double x = getMSTCost() ;
      u.myassert(x == 63);
    }
    {

    	init("uw2.txt  MST OF 93","uw2.txt",true) ;
    	double x = getMSTCost() ;
      u.myassert(x == 93);
    }
    {
    	//https://github.com/geftimov/java-algorithms/blob/master/src/main/resources/tinyEWD.txt
    	init("tinyEWD.txt  MST OF 2.4699999999999998","tinyEWD.txt",true) ;
    	double x = getMSTCost() ;
      u.myassert(x == 2.24);
    }
    {
    	//https://github.com/georgicodes/algorithmics/blob/master/java/algs4-data/tinyEWG.txt
    	init("tinyEWG.txt MST OF 1.81","tinyEWG.txt",true) ;
    	double x = getMSTCost() ;
      u.myassert(x == 1.81);
    }
    if (false)
    {
    	//https://github.com/georgicodes/algorithmics/blob/master/java/algs4-data/mediumEWD.txt
    	init("mediumEWD.txt MST OF 7.279219999999996","mediumEWD.txt",false) ;
    	double x = getMSTCost() ;
      u.myassert(x > 7.27 && x < 7.28);
    }
    {
    	long startTime = System.nanoTime();
    	init("largeEWD MST OF 647.6347342400023","largeEWD.txt",false) ;
    	double x = getMSTCost() ;
      u.myassert(x > 647.63 && x < 647.64);
      long endTime = System.nanoTime();
      double d = u.timeInSec(endTime,startTime) ;
  		System.out.println("Run time for largeEWD MST = " + d + " secs" );
    }
  }
  
	public static void main(String[] args) {
		System.out.println("KruskalBase.java STARTS");
		System.out.println("You cannot instantiate KruskalBase class: KruskalBase p = new KruskalBase() ; ");
		//KruskalBase p = new KruskalBase() ;
		System.out.println("KruskalBase.java ENDS");
	}
}