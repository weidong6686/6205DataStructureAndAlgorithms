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
  
  //You can use as many private data structure you want
  
  knapsack01() {
  	//Nothing can be added here
		testBench();
	}

  @Override
  protected void knapsack(int bagSize, int[] weightArray, int[] costArray, int[] maxans){
    s= bagSize;
    int n = weightArray.length ;
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

    

    int[] v = new int[s + 1]; //  0/1 Knapsack problem: v[i,j] = max{v[i-1, j], v[i-1, j-wa[i]] + ca[i]}
    boolean[][] k = new boolean[n][s + 1];
// outptut v matrix;
    System.out.println("------------ V matrix ----------------");
    for (int j = 0; j <= s; j++) {
    	System.out.print(v[j] + "\t");
    	}
    System.out.print("\n");
    for (int i = 0; i < n; i++) {
    	for (int j = s; j >= 0; j--) {
    		boolean flag = true;
    		if (j >= wa[i])
    			if (v[j] < v[ j - wa[i] ] + ca[i]) {
    				v[j] = v[ j - wa[i] ] + ca[i];
    				flag = false;
    				k[i][j] = true;
    				}
    		if (flag)
    			k[i][j] = false;
    		}
    	for (int j = 0; j <= s; j++) {
    		System.out.print(v[j] + "\t");
    		}
	System.out.print("\n");
	}
   //output  k matrix;
    System.out.println("------------ K matrix ----------------");
    for (int i = 0; i <= s; i++) {
    	System.out.print("0" + "\t");
    	}
	System.out.print("\n");
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j <= s; j++) {
    		System.out.print((k[i][j] ? 1 : 0) + "\t");
    		}
    	System.out.println();
    	}
// output i , w, v;
    ArrayList<Integer> res = new ArrayList<>(); 
    int  i = n - 1, j = s;
    while ((j >= 0) && (i >= 0)) {
    	if (k[i][j]) {
    		res.add(i);
    		j -= wa[i];
    		i--;
    		}
    	else i--;
    	}    	
    System.out.print("i = ");
    for (int l = res.size() - 1; l >= 0;l--) {
    	System.out.print((res.get(l) + 1)+"\t" );
    	}
    System.out.print("\n");
    System.out.print("w = ");
    for (int l = res.size() - 1; l >= 0; l--) {
    	System.out.print( wa[res.get(l)]+"\t");
    	}
    System.out.print("\n");
    System.out.print("v = ");
    for (int l = res.size() - 1; l >= 0; l--) {
    	System.out.print(ca[res.get(l)]+"\t");
    	}
	System.out.print("\n");
    maxans[0] = v[s];
    }
 

  public static void main(String[] args) {
    System.out.println("knapsack01.java starts");
    knapsack01 m = new knapsack01() ;
    System.out.println("You are amazing. Bring me a bar of Chocolate");
    System.out.println("knapsack01.java ends");
  }
}