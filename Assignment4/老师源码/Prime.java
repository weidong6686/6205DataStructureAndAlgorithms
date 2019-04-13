/**
 * File Name: Prime.java 
 * Finding prime numbers
 * 
 * To compile: IntUtil.java RandomInt.java Prime.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

public class Prime{
  private int max ;
  private int [] p ; //array that has prime number 
  private int pkount ;
  private long steps ;
  private long gsteps ; //Number of steps guessed through formula
  private boolean display = false;
  static IntUtil u = new IntUtil();
  
  Prime(int n) {
    max = n ;
    p = new int[n+1] ;
    pkount = 0 ;  
    steps = 0 ;
    gsteps = 0 ;
  }
 
  
  public void bruteForce() {
  	//WRITE CODE
  	
  	
  	//This must be last line
    pLn("----------bruteForce method---------- ");
  }
  
  public void uptoSquareRoot() {
  	//WRITE CODE
  	
  	
  	//This must be last line
    pLn("----------uptoSquareRoot method---------- ");
  }
  
  public void uptoPrimeNumbers() {
  	//WRITE CODE
  	
  	
  	//This must be last line
    pLn("----------uptoPrimeNumbers method---------- ");
  }
  
  public void SieveOfEratosthenes() {
  	//WRITE CODE
    
  	
  	
  	//This must be last line
  	pLn("----------SieveOfEratosthenes method---------- ");
  }
  
  /*
   * ------------------ CANNOT CHANGE ANYTHING BELOW----------------------
   */
  
  private static void pLn(String t) {
    System.out.println(t);
    if (display) {
      u.pLn(p,0,pkount) ;
    }
    System.out.println("The numbers of primes from 2 to " + max + " = " + pkount);
    System.out.println("The number of steps is =           " + steps) ;
    System.out.println("The number of guessed steps is = " + gsteps) ;
    if (pkount >= 999) {
      System.out.println("The 1000 prime is = " + p[999]) ;
    }
    if (pkount >= 9999) {
      System.out.println("The 10000 prime is = " + p[10000-1]) ;
    }
  }
  
  private static void assertAnswers(Prime a, Prime b) {
    u.myassert(a.pkount == b.pkount);
    u.myassert(u.arrayEqual(a.p, b.p));
  }

  private static void testAll(int n) {
    if (n < 2000) {
      Prime b = new Prime(n) ;
      b.bruteForce() ;
      Prime s = new Prime(n) ;
      s.uptoSquareRoot() ;
      assertAnswers(b,s) ;
      System.out.println("bruteforce and uptoSquareRoot methods produces same answers") ;
    }
    System.out.println("============uptoPrimeNumbers start " + n + " ---------------------") ;
    Prime p = new Prime(n) ;
    p.uptoPrimeNumbers() ;
    System.out.println("uptoPrimeNumbers done") ;
    System.out.println("============ SieveOfEratosthene start " + n + " ---------------------") ;
    Prime e = new Prime(n) ;
    e.SieveOfEratosthenes() ;
    System.out.println("SieveOfEratosthene done") ;
    assertAnswers(p,e);
    System.out.println("uptoPrimeNumbers and SieveOfEratosthene methods produces same answers") ;
    System.out.flush();
  }
  
  public static void main(String[] args) {
    System.out.println("Prime.java Starts");
    testAll(16);
    testAll(1000);
    testAll(50000);
    testAll(500000);
    testAll(5000000);
    System.out.println("Arrach Prime.java and output of the program as a pdf file");
    System.out.println("Prime.java ends");
  }
}
