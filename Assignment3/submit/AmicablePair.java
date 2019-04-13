import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * File Name: AmicablePair.java 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 * 
 * To compile: RandomInt.java IntUtil.java AmicablePair.java
 */
public class AmicablePair{
  private int max ;
  //YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES HERE
  static IntUtil u = new IntUtil() ;
  
  /*
   * Constructor
   */
  AmicablePair(int n) {
    max = n ;
    factorsSum(n);  // implement the method
    
    /* You can initialize any variables here */
    /* you can call any private functions here */
 }  
  /*
   *       WRITE YOUR CODE BELOW
   *       MUST SOLVE FROM FUNDAMENTALS
   *       CANNOT USE SOME WEIRD FORMULAS FROM INTERNET
   */
  
  //AmicablePair sum compute method
  private int  factorsSum(int n) {
	  long startTime = System.nanoTime();//count time
	  int j, sum = 0, num = 0;
	  int[] sums = new int [n+1];
	  for (int i = 1; i <=n/2; i++) {
		  j = i*2;
		  while (j <= n) {
		  sums[j] = sums[j]+i; // add  factor i to  every sums in the list
		  j = j+i;
		  }
	  }
	  for (int i = 2; i <= n; i++) {
		  sum = sums[i];
		  if (sum > n || sum <= i)// avoid sum out of n and delete repeating such as "284-220" from"220-284 "
			  continue;
		  else {
			  if (sums[sum] == i) {// Judge Amicable Pair
				  System.out.println(num+": "+i+" and "+sum); //output Judge Amicable Pair
				  num++;
				  }
			  }
		  }
	 long endTime = System.nanoTime();// Time count
	 double d2 = u.timeInSec(endTime,startTime) ;// Time count
	 System.out.println("AmicablePair "  + " CPU time = " + d2 + " seconds"); // Time count
	 return num;
  }
  
  /*
   * NOTHING CAN BE CHANGED BELOW
   */
  private static void test() {
    int n =  100000000;
    AmicablePair a = new AmicablePair(n) ;
  }
  
  public static void main(String[] args) {
    System.out.println("AmicablePair.java starts") ;
    test() ;
    System.out.println("If you can do in less than 20 secs, you will get FULL points") ;
    System.out.println("Attach AmicablePair.java, output of your program as a pdf file") ;
    System.out.println("Attach a word file, explaining why your method is fast") ;
    System.out.println("AmicablePair.java ends") ;
  }
}

