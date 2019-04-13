/**
 * File Name: DuplicateN.java
 * Find Duplicate elements in an array
 * The array of size N will have elements 0 <= i < N
 * 
 * to compile: RandomInt.java IntUtil.java DuplicateN.java
 * 
 * DO NOT POST THIS CODE ON WEB. CopyRight: Jagadeesh Vasudevamurthy
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

class DuplicateN {
	static IntUtil u = new IntUtil() ;
	/* NOTHING CAN BE CHANGED IN CONSTRUCTOR */
	DuplicateN() {
		testBed() ;
	}

	/*
	 * Time: O(n^2)
	 * Space: THETA(1)
	 */

	private int bigOnSquareTimeTheta1Space(int[] a, boolean show) {
		int k = 0 ;
		int n = a.length ;
		for (int i = 0; i < n; ++i) {
			a[i] = a[i] + 1 ;
		}
		for (int i = 0; i < n; ++i) {
			int x = a[i] ;
			if (x >= 0) {
				boolean first = true ;
				for (int j = i+1; j < n; ++j) {
					int y = a[j] ;
					if (x == y) {
						a[j] = -y ;
						if (first) {
							++k ;
							if (show) {
								System.out.print(x-1 + " ") ;
							}
							first = false ;
						}
					}
				}
			}
		}
		if (show) {
			System.out.println() ;
		}

		for (int i = 0; i < n; ++i) {
			if (a[i] < 0) {
				a[i] = -(a[i]) - 1;
			}else {
				a[i] = a[i] - 1 ;
			}
		}
		return k ;
	}

	/*
	 * Time: THETA(n)
	 * Space: THETA(n)
	 */

	private int thetaNTimeThetaNSpace(int[] a, boolean show) {
		int k = 0 ;
		//WRITE CODE HERE
		int n = a.length;
		int [] b =  new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = 0;	
			}
		for (int i = 0; i < n; i++) {
			if (b[a[i]] == 1) {//judge if repeat or not
				++k;
				if (show) {
					System.out.print( a[i]+" ") ;
				}
			}
			b[a[i]]++;
		}
		if (show) {
			System.out.println() ;
		}
		return k ;
	}

	/*
	 * Time: THETA(n)
	 * Space: THETA(1)
	 */
	private int thetaNTimeTheta1Space(int[] a, boolean show) {
		int k = 0 ;
		//WRITE CODE HERE
		int n = a.length;
		for (int i = 0; i < n; i++) {
				if (a[a[i]%n]/n == 1) { //judge if repeat or not
					++k;
					if (show) {
						System.out.print( a[a[i]%n] + " ") ;
					}
				}
				a[a[i]%n]+= n;
				}
		//restore the a[i] to original
		for (int i = 0; i < n; i++) {
			a[i] = a[i] % n;
		}
		if (show) {
			System.out.println() ;
		}
		return k ;
	}

	/*
	 ***************** NOTHING CAN BE CHANGED BELOW *************************************
	 */
	private int test(int[] a, boolean show) {
		int[] b = u.copyArray(a); //For testing. Keep a copy
		int n = a.length;
		if (show) {
			System.out.println("-----------BEFORE-----------") ;
			u.pLn(n);
			u.pLn(a);
		}
		int k1 = 0 ;
		int k2 = 0 ;
		int k3 = 0 ;
		{
			long startTime = System.nanoTime();
			k1 = bigOnSquareTimeTheta1Space(a,show);
			u.myassert(u.arrayEqual(a, b)) ; //Make sure array a is not changed
			long endTime = System.nanoTime();
			double d2 = u.timeInSec(endTime,startTime) ;
			System.out.println("O(n^2)O(1) Number of DuplicateNs in " + n + " elements = " + k1 + " CPU time = " + d2 + " seconds");
		}
		
		{
			long startTime = System.nanoTime();
			k2 = thetaNTimeThetaNSpace(a,show);
			u.myassert(u.arrayEqual(a, b)) ; //Make sure array a is not changed
			long endTime = System.nanoTime();
			double d2 = u.timeInSec(endTime,startTime) ;
			System.out.println("O(n)O(n) Number of DuplicateNs in " + n + " elements = " + k2 + " CPU time = " + d2 + " seconds");
		}
		
		{
			long startTime = System.nanoTime();
			k3 = thetaNTimeTheta1Space(a,show);
			u.myassert(u.arrayEqual(a, b)) ; //Make sure array a is not changed
			long endTime = System.nanoTime();
			double d2 = u.timeInSec(endTime,startTime) ;
			System.out.println("O(n)O(1) Number of DuplicateNs in " + n + " elements = " + k3 + " CPU time = " + d2 + " seconds");
		}

		u.myassert(k1 == k2);
		u.myassert(k1 == k3);
		return k1 ;
	}

	private void testRandom() {
		int N = 500000 ; 
		for (int i = 10000; i < N; i = i + 10000) {
			int start = 0 ;
			int end = i-1 ; 
			int [] a = u.generateRandomNumber(i, true, start,end);
			int k = test(a,false) ;	
		 }
		}


	private void test1() {
		{
			int [] a = {1,1,1};
			int k = test(a, true);
			u.myassert(k == 1);
		}
		{
			int [] a = {1,2,0};
			int k = test(a, true);
			u.myassert(k == 0);
		}
		{
			int [] a = {1,0,0};
			int k = test(a, true);
			u.myassert(k == 1);
		}
		{
			int [] a = {1,0,1,0};
			int k = test(a, true);
			u.myassert(k == 2);
		}
	}

	private void testBed() {
		test1() ;
		testRandom() ;
	}

	public static void main(String[] args) {
		System.out.println("DuplicateN.java STARTS");
		DuplicateN m = new DuplicateN() ;
		System.out.println("All tests passed. You will get full points");
		System.out.println("DuplicateN.java ENDS");
	}
}

//EOF
