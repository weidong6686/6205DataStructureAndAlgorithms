import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
  
  ArrayList<Integer> primeSet = new ArrayList<Integer>();
  boolean[] notPrimeArray; 
  final int MAX_FACTORS = 6;
  int allCount = 0;
  
  /*
   * Constructor
   */
  AmicablePair(int n) {
    max = n ;
    /* You can initialize any variables here */
    /* you can call any private functions here */
    
	long startTime = System.nanoTime();	  
	notPrimeArray = new boolean[n + 1];   

	makePrimeSet(n);
    
	long endTime = System.nanoTime();
	double d2 = u.timeInSec(endTime,startTime) ;
	System.out.println(" CPU time = " + d2 + " seconds");
	
	startTime = System.nanoTime();	  
    
	worker(n);

    System.out.println(allCount);
	endTime = System.nanoTime();
	d2 = u.timeInSec(endTime,startTime) ;
	System.out.println("AmicablePair" + " CPU time = " + d2 + " seconds");
  }
  
  private void makePrimeSet(int n) {
	notPrimeArray[1] = true;
	for (int i = 2; i <= n; i++) {
		if (!notPrimeArray[i]) {
			primeSet.add(i);
			for (int j = i + i; j <= n; j += i) {
				notPrimeArray[j] = true;
			}		
 		}
	}
  }
/*
   *       WRITE YOUR CODE BELOW
   *       MUST SOLVE FROM FUNDAMENTALS
   *       CANNOT USE SOME WEIRD FORMULAS FROM INTERNET
   */
  private void worker(int num) {
	  for (int i = 2; i <= num; i++) {
		  if (
			  ((i & 1) != 0) && 
			  ((i % 5) != 0) &&
			  (i != 34765731) 
			  ) {
			  continue;
		  }
		  Boolean isCountLarger = false;
		  int sumOfI = sumDivisor(i, isCountLarger);
		  if (sumOfI > num)
			  continue;
		  isCountLarger = false;
		  int sumOfT = sumDivisor(sumOfI, isCountLarger);
		  if (i == sumOfT && i < sumOfI && !isCountLarger) {
			  System.out.println(i + "\t" + sumOfI + "\t" );
			  allCount++;
		  }
		  else 
			  continue;
	  }
  }
  
  private int sumDivisor(int n, Boolean isCountLarger) {
	  HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
	  int sum = 1;
	  getPrimeFactors(n, primeFactors);
	  for (Map.Entry<Integer, Integer> id : primeFactors.entrySet()) {
		  int idx = id.getKey();
		  int idy = id.getValue();
		  sum *= (int)((Math.pow(idx, idy + 1) - 1) / (idx - 1));
	  }
	  sum -= n;
	  if (primeFactors.size() > MAX_FACTORS)
		  isCountLarger = true;  
	  return sum;
  }

  private int getPrimeFactors(int n, HashMap<Integer, Integer> ans) {  
	  int temp = n, count = 0;
	  for (Integer idx : primeSet) {
		  while (temp % idx == 0) {
			  count++;
			  if (ans.containsKey(idx)) {
				  int value = ans.get(idx) + 1;
				  ans.put(idx, value);
			  } else {
				  ans.put(idx, 1);
			  }
			  temp /= idx;
		  }
		  if (!notPrimeArray[temp]) {
			  ans.put(temp, 1);
			  temp = 1;
		  }
		  if (temp == 1)
			  break;
	  }
	  return count;
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

