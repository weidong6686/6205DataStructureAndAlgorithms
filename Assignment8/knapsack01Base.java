/**
 * File Name: knapsack01Base.java 
 * Dynamic programming
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

//NOTHING CAN BE CHANGED IN THIS FILE
abstract class knapsack01Base{
	//I don't know how to write it
  //Override by the concrete class
	abstract protected void knapsack(int bagsize, int [] weight, int [] value, int[] ans) ;
  protected static final IntUtil u = new IntUtil();

  protected void testBench() {
    {
      System.out.println("------------knapsack2(k2)---------------------");
      int[] w = {3,2,1};
      int[] v = {5,3,4};
      int[] ans = {0};
      knapsack(5,w,v,ans) ;
      //u.myassert(ans[0] == 9);
    }
    {
      System.out.println("------------knapsack1(animal)---------------------");
      int[] w = {2,1,3,2};
      int[] v = {12,10,20,15};
      int[] ans = {0};
      knapsack(5,w,v,ans) ;
      u.myassert(ans[0] == 37);
    }
    {
      System.out.println("------------knapsack3---------------------");
      int[] w = {2,3,4,5};
      int[] v = {3,4,5,6};
      int[] ans = {0};
      knapsack(5,w,v,ans) ;
      u.myassert(ans[0] == 7);
    }
    {
      System.out.println("------------knapsack4(k1)---------------------");
      int[] w = {5,4,6,3};
      int[] v = {10,40,30,50};
      int[] ans = {0};
      knapsack(10,w,v,ans) ;
      u.myassert(ans[0] == 90);
    }
    System.out.println("------------END---------------------");
  }

  public static void main(String[] args) {
    System.out.println("knapsack01Base.java STARTS");
		System.out.println("You cannot instantiate knapsack01Base class: knapsack01Base p = new knapsack01Base() ; ");
		//knapsack01Base p = new knapsack01Base() ;
		System.out.println("knapsack01Base.java ENDS");
  }
}