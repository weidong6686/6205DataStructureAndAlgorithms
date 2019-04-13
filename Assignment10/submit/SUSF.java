/**
 * File Name: SFSU.java 
 * UnionFind problem that works on basic data type int
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */
import java.util.HashMap;
import java.util.Random;
class SUSF {
	private int[] id ; //id array. Can be changed. id[] marks id[i]'s root,  is root?  and height of root(-x);
	private int length ;
	private long numFind ;
	private long numUnion;
	private long maxHeight ; //max height of tree while chasing 
	private static final IntUtil u = new IntUtil();
	private int  height;
	private int reallength;

	SUSF(int n) {
		length = n ; // nodes number;
		id = new int[n] ;
		//The true identity of parent is in a node that has negative weight
		for (int i = 0; i < n; ++i) {
			id[i] = -1 ;
		}
		numFind = 0 ;
		numUnion = 0 ;
		maxHeight = 0 ;
	}
	
	SUSF(int n, int N) {  // we need input length of id[] n and real nodes number N
		length = n;
		reallength = N;
		id = new int[n] ;
		for (int i = 0; i < n; ++i) {
			id[i] = -1 ;
		}
		numFind = 0 ;
		numUnion = 0 ;
		maxHeight = 0 ;
	}

	public void P() {
		System.out.println("n = " + (reallength)) ;
		System.out.println("U = " + numUnion + " F = " + numFind + " H = " + maxHeight ) ;
	}
  
	/* WRITE SMART UNION AND SMART FIND CODE BELOW */
	/* make sure all tests passes */
    public int compressedFind(int x){  // find the root of x and compressed;
    	if (id[x] < 0) {
    		return x;
    	}
    	numFind++;	
    	id[x] = compressedFind(id[x]);
    	return (id[x]);
    }
  
    
    private void getheight(int x){  // count height after compressed;
    	if (id[x] < 0)   
    		return;
    	height++;
    	x= id[x];
    }
    

    
	public boolean F(int i, int j) {  // judge  i and j connected?
		int x = compressedFind(i) ;
		int y = compressedFind(j) ;
		return x ==y;
	}
    
    public void U(int x, int y){
    	numUnion++;
    	int maxHeightx = Integer.MIN_VALUE;
    	int maxHeighty = Integer.MIN_VALUE;
    	height = 1;
        int rootx = compressedFind(x);
        getheight(x);
        maxHeightx = Math.max(maxHeightx, height);
        height = 1;
        int rooty = compressedFind(y);
        getheight(y);
        maxHeighty = Math.max(maxHeighty, height);
        if (rootx == rooty)  return;
        if (id[rootx] > id[rooty]) {// merge root of y to  root of x(higher);
        	id[rootx] += id[rooty];
        	id[rooty] = rootx;
        	maxHeight = maxHeightx == maxHeighty?  Math.max(maxHeightx, maxHeighty)+1 : Math.max(maxHeightx, maxHeighty);
        }
        else {
        	id[rooty] += id[rootx];
        	id[rootx] = rooty;
        	maxHeight = maxHeightx == maxHeighty?  Math.max(maxHeightx, maxHeighty)+1 : Math.max(maxHeightx, maxHeighty);
        }
    }
	
	
	private void testBasic() {
		int [][] e1 = { 
				{4,3}, 
				{3,8},
				{6,5},
				{9,4},
				{2,1},  
		} ;
		int [][] e2 = { 
				{5,0}, 
				{7,2},
				{6,1},
				{7,3}, 
		} ;
		int n = 10 ;
		SUSF uf = new SUSF(n) ;
		for (int i = 0; i < e1.length; ++i) {
			int[] p = e1[i] ;
			u.myassert(p.length == 2);
			uf.U(p[0],p[1]) ;
		}
		u.myassert(uf.F(8,9)) ; //8->9 must be connected    
		u.myassert(uf.F(5,4) == false) ; //5->4 must not be connected

		for (int i = 0; i < e2.length; ++i) {
			int[] p = e2[i] ;
			u.myassert(p.length == 2);
			uf.U(p[0],p[1]) ;
		} 
		uf.P();
		System.out.println("Test basic passed");
	}


	private void test1(int n) {
		System.out.println("--------------------test1---------------");
		SUSF uf = new SUSF(n) ;
		for (int i = 0; i < n-1; ++i) {
      uf.U(i,i+1) ;
    }
		uf.P();
		System.out.println("Test1passed");
	}
	
	private void test2(int n) {
		System.out.println("--------------------test2---------------");
		SUSF uf = new SUSF(n) ;
		uf.U(0,1) ;
		for (int i = 2; i < n; ++i) {
      uf.U(i,0) ;
    }
		uf.P();
		System.out.println("Test2passed");
	}
	
	private void testRandom(int n) {
		System.out.println("--------------------testRandom---------------");
		int k = n * 10 ;
    System.out.println("Union on " + n + " random data performed " + k + " times") ;
    SUSF uf = new SUSF(n) ;
    Random r = new Random() ;
    for (int i = 0; i < k; ++i) {
      int v1 = RandomInt.getRandomInt(r,0,n); //This gives number between 0 to n-1
      int v2 = RandomInt.getRandomInt(r,0,n); //This gives number between 0 to n-1
      if (v1 != v2) {
        if (i % 5 == 0) {
          boolean z = uf.F(v1,v2) ;         
        }else {       
          uf.U(v1,v2) ;
        }
      }
    }
    uf.P();
		System.out.println("testRandompassed");
	}
	
	private void testBench() {
		testBasic() ;
		test1(1000);
		test2(1000);
		testRandom(100000) ;
	}

	public static void main(String[] args) {
		System.out.println("SUSF.java Starts");
		SUSF u = new SUSF(5) ;
		u.testBench() ;
		System.out.println("SUSF.java Ends");
	}  
}