import java.io.FileWriter;
import java.io.IOException;

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
    /* You can initialize any variables here */
    /* you can call any private functions here */
  }
  /*
   *       WRITE YOUR CODE BELOW
   *       MUST SOLVE FROM FUNDAMENTALS
   *       CANNOT USE SOME WEIRD FORMULAS FROM INTERNET
   */
  
  
  
  /*
   * NOTHING CAN BE CHANGED BELOW
   */
  private static void test() {
    int n =  100000000 ;
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

