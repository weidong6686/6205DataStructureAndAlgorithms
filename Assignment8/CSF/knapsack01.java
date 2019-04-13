import java.util.ArrayList;

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
  
  private int n;
  
  
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
    
    
//	  v[i,j] = max{v[i-1, j], v[i-1, j-wa[i]] + ca[i]}
//    we can optimize the DP function from 2-d matrix to 1-d array here
    int[] v = new int[s + 1];
//	  matrix k[i][j] stores if we use the ith item at the size of j
    boolean[][] k = new boolean[n][s + 1];
    // calculate the DP function and print v matrix by each row
	System.out.println("------------ V matrix ----------------");
	for (int j = 0; j <= s; j++) {
		System.out.print(v[j] + "\t");
	}
	System.out.println();
	for (int i = 0; i < n; i++) {
		for (int j = s; j >= 0; j--) {
			boolean flag = true;
			if (j >= wa[i])
				if (v[j] < v[j - wa[i]] + ca[i]) {
					flag = false;
					v[j] = v[j - wa[i]] + ca[i];
					k[i][j] = true;
				}
			if (flag) 
				k[i][j] = false;
		}
		for (int j = 0; j <= s; j++) {
			System.out.print(v[j] + "\t");
		}
		System.out.println();
	}
	//print k matrix
	System.out.println("------------ k matrix ----------------");
	for (int j = 0; j <= s; j++) {
		System.out.print("0" + "\t");
	}
	System.out.println();
	for (int i = 0; i <= n - 1; i++) {
		for (int j = 0; j <= s; j++) {
			System.out.print((k[i][j] ? 1 : 0) + "\t");
		}
		System.out.println();
	}
	
	// output what are all the items you stole and total value 
	ArrayList<Integer> ans = new ArrayList<>(); 
	{
		int j = s, i = n - 1;
		while ((j >= 0) && (i >= 0)) {
			if (k[i][j]) {
				ans.add(i);
				j -= wa[i];
				i--;
			} else {
				i--;
			}
		}
	}
	System.out.print("\r\ni = ");
	for (int i = ans.size() - 1; i >= 0; i--) {
		System.out.print("\t" + (ans.get(i) + 1));	
	}
	System.out.print("\r\nw = ");
	for (int i = ans.size() - 1; i >= 0; i--) {
		System.out.print("\t" + wa[ans.get(i)]);		
	}
	System.out.print("\r\nv = ");
	for (int i = ans.size() - 1; i >= 0; i--) {
		System.out.print("\t" + ca[ans.get(i)]);		
	}
	System.out.println();
	maxans[0] = v[s];
	
  }
  
 
 

  public static void main(String[] args) {
    System.out.println("knapsack01.java starts");
    knapsack01 m = new knapsack01() ;
    System.out.println("You are amazing. Bring me a bar of Chocolate");
    System.out.println("knapsack01.java ends");
  }
}