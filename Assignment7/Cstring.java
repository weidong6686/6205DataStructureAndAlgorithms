/**
 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: IntUtil.java RandomInt.java CharArray.java Cstring.java 
 * WRITE CODE IN THIS FILE
 */

class Cstring {
	//YOU CANNOT ADD ANYTHING HERE
  private CharArray d; //Infinite array of char
  static IntUtil u = new IntUtil();
  
  //WRITE ALL THE ROUTINES BELOW, so that all the tests pass
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox junped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false) ;
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic() ;
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Done");
  }
  
}