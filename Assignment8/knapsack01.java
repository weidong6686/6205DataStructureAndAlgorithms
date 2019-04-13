/**
 * File Name: knapsack01.java 
 * Dynamic programming
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */
class knapsack01 extends knapsack01Base{
  //given
  private int s ; //Bag size Given
  private int[] wa ; //weight array: Given
  private int[] ca; //cost array: Given
  private int[] maxans ; //Final value of items stolen. You need to compute and fill this.
  
  //You can use as many private data structure you want
  
  knapsack01() {
  	//Nothing can be added here
		testBench();
	}

  @Override
  protected void knapsack(int bagSize, int[] weightArray, int[] costArray, int[] maxans){
    s= bagSize;
    n = weightArray.length ;
    u.myassert(n == costArray.length);
    wa = weightArray;
    ca = costArray ;
    this.maxans = maxans;
    //Initialize all your private data structures
    //call dynamic programming algorithm
    //1. You need to print vmatrix
    /*
	    ------------ V matrix ----------------
	    0   0   0   0   0   0
	    0   0   0   5   5   5
	    0   0   3   5   5   8
	    0   4   4   7   9   9
	  */
    //2. you need to print kmatrix
    /*
	    ------------ k matrix ----------------
	    0   0   0   0   0   0
	    0   0   0   1   1   1
	    0   0   1   0   0   1
	    0   1   1   1   1   1
	  */
    //3. you need to print what are all the items you stole and total value
    /*
    		i =    1   2   3
    		w =    3   2   1
    		v =    5   3   4
    		Max Value of 9 can obtained from items {3,1} that has values {4+5=9}
    */
    //4. Populate maxans[0] = 9 ; //In the above example
  
    //WRITE AS MANY PRIVATE FUNCTIONS YOU WANT
    //DO NOT CRAM ALL CODE HERE
  }
  
 
 

  public static void main(String[] args) {
    System.out.println("knapsack01.java starts");
    knapsack01 m = new knapsack01() ;
    System.out.println("You are amazing. Bring me a bar of Chocolate");
    System.out.println("knapsack01.java ends");
  }
}