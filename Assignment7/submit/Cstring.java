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

public Cstring(String string) { // Convert string to Cstring; 
	d = new CharArray();  //CharArray d = new CharArray(); 
	for (int i = 0; i < string.length(); i++) {
		d.set(i,  string.charAt(i));
	}
	d.set(string.length(), '\0');
}

  public Cstring(char c) {
	this(c+"");  //  convert char to string
}


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
  
  @Override
  public Cstring clone() {
	  int i = 0;
	  CharArray res = new CharArray();
	  Cstring res1 = new Cstring("");
	  while(d.get(i) != '\0') {
		  res.set(i, d.get(i));
		  i++;
	  }
	  res.set(i, '\0');
	  res1.d = res;
	 return res1;
}
  
  public void reverse() {
	  int i = 0;
	  StringBuilder sb = new StringBuilder();
	  while(d.get(i) != '\0') {
		  sb.append(d.get(i));
		  i++;
	  }
	  i = 0;
	  String rev = sb.reverse().toString();
	  while(d.get(i) != '\0') {
		  d.set(i, rev.charAt(i));
		  i++;
	  }
}

  @Override  
  public String toString( ) {
  	StringBuilder sb = new StringBuilder();
  	int i = 0;
  	while (d.get(i) != '\0') {
  		sb.append(d.get(i));
  		i++;
  		}
  	return sb.toString();
  }
  
  public void append(String string) {
  	StringBuilder sb = new StringBuilder();
  	int i = 0;
  	while(d.get(i) != '\0') {
  		sb.append(d.get(i));
  		i++;
		  }
  	i = 0;
  	while(i < string.length()) {
  		sb.append(string.charAt(i));
  		i++;
  		}
  	i = 0;
  	while(i < sb.length()) {
  		d.set(i, sb.charAt(i));
  		i++;
  		}
  	}
  public void append(Cstring b) {
    	this.append(b.toString());
    }


   public Cstring add(String string) {
	  CharArray res = new CharArray();
	  Cstring res1 = new Cstring("");
	  StringBuilder sb = new StringBuilder();
	  int i = 0;
	  while(d.get(i) != '\0') {
		  sb.append(d.get(i));
		  i++;
		  }
	  i = 0;
	  while(i < string.length()) {
		  sb.append(string.charAt(i));
		  i++;
		  }
	  i = 0;
	  while(i < sb.length()) {
		  res.set(i, sb.charAt(i));
		  i++;
		  }
	  res.set(i, '\0');
	  res1.d = res;
	  return res1;
  } 
    
 public Cstring add(Cstring b) {
	  return this.add(b.toString());
  } 
  
 public void pLn(String string) {
	System.out.print(string);
	System.out.println(this.toString());
}
	
 public boolean isEqual(Cstring b) {
	int i = 0;
	while(d.get(i) != '\0' && i < b.toString().length()) {
		if (d.get(i) != b.toString().charAt(i))
			return false;
		i++;
		}
	if (d.get(i) != '\0' ||  i != b.toString().length())
		return false;
	return true;
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