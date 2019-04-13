import java.util.ArrayList;

/**
 * File Name: CoinChange.java 
 * Dynamic programming
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2014
 */

/*
 * NOTHING CAN BE CHANGED IN THIS FILE
 */
abstract class CoinChangeBase{
	//I don't know how to write it
  //Override by the concrete class
	abstract protected void computeChange(int n, int [] arrayOfCoinsAvailable) ;
	
	 protected void testBench() {
    {
      System.out.println("------------test1---------------------");
      int[] w = {1,3,4};
      computeChange(6,w) ;
    }
    {
      System.out.println("------------test2---------------------");
      int[] w = {1,2,6,10,24,30,90};
      computeChange(100,w) ;
    }
    {
      System.out.println("------------Amazon stamp--------------------");
      int[] w = {1,2,6,10,24,30,90};
      computeChange(34,w) ;
    }
    {
      System.out.println("------------US coins--------------------");
      int[] w = {1,5,10,25};
      computeChange(24,w) ;
    }
    {
      System.out.println("------------Weird Coins--------------------");
      int[] w = {1,5,10,12};
      computeChange(16,w) ;
    }
  }

  public static void main(String[] args) {
  	System.out.println("CoinChangeBase.java STARTS");
		System.out.println("You cannot instantiate CoinChangeBase class: CoinChangeBase p = new CoinChangeBase() ; ");
		//CoinChangeBase p = new CoinChangeBase() ;
		System.out.println("CoinChangeBase.java ENDS");
  }
}