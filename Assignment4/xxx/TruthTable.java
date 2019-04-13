

/**
 * File Name: TruthTable.java 
 * Print 'n' input truth table
 * 
 * To compile: RandomInt.java IntUtil.java TruthTable.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

class TruthTable{
  private int n ;
  private boolean display ;
  static IntUtil u = new IntUtil() ;
 
  /*
   * ---------WRITE CODE HERE -------------------
   */
  public TruthTable(int n, boolean display){
	  StringBuilder sb = new StringBuilder();
	  truthTable(n, sb ,display);
	  }  
  public static void truthTable(int n, StringBuilder sb, boolean display ) {
	  if (n == 0) { 
		  if (display)
			  System.out.println(sb.toString());
		  }
	  else {
		  sb.append('0');
		  truthTable (n-1, sb, display);
		  sb.deleteCharAt(sb.length( )-1);
		  sb.append('1');
		  truthTable(n-1, sb, display);
		  sb.deleteCharAt(sb.length( )-1);
		  }
	  }
  
  /*
   * ----------  YOU CANNOT CHANGE ANYTHING BELOW--------------------------
   */
  private static void testBench() { 
    for (int i = 1 ; i < 31; ++i) {
    	boolean display = (i > 10) ? false : true ;
      System.out.println("------------Truth table of " + i + " inputs function --------------");
      long startTime = System.nanoTime();
      //If display is true, you should print like this:
      //------------Truth table of 2 inputs function --------------
      //00
      //01
      //10
      //11
      //For 2 inputs, table size is 4
      
      
      //If display is false, you must go through the same procedure
      //buy you should print only the last line like this
      //------------Truth table of 29 inputs function --------------
      //For 29 inputs, table size is 536870912
      
      TruthTable t = new TruthTable(i,display) ;
      long endTime = System.nanoTime();
      double d = u.timeInSec(endTime,startTime) ;
      System.out.println("Cpu time for n = " + i + " is " + d + " seconds");
    }
  }

  public static void main(String[] args) {
    System.out.println("TruthTable.java Starts");
    testBench();
    System.out.println("YOU CANNOT USE bigInteger class");
    System.out.println("Must use only basic java to solve this problem");
    System.out.println("Attach TruthTable.java and output of this program as a pdf file for full grade");
    System.out.println("TruthTable.java ends");
  }
}