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
	public Cstring(char c) {
		this(String.valueOf(c));
	}

	public Cstring(String string) {
		d = new CharArray();
		int n = string.length();
		for (int i = 0; i < n; i++) {
			d.set(i, string.charAt(i));
		}
		d.set(n, '\0');
	}
	
	private Cstring(CharArray d) {
		this.d = d;
	}

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
  
	public void reverse() {
		int i = 0, j = 0;
		while (d.get(i) != '\0') {
			i++;
		}
		CharArray res = new CharArray(i);
		i--;
		while (i >= 0) {
			res.set(j++, d.get(i--));
		}
		res.set(j, '\0');
		d = res;
	}
	
	@Override
	public Cstring clone() {		
		CharArray ans = new CharArray();
		int i = 0;
		while (d.get(i) != '\0') {
			ans.set(i, d.get(i));
			i++;
		}
		ans.set(i, '\0');
		Cstring obj = new Cstring("");
                obj.d = ans;
		return obj;
	}
	
	@Override
	public String toString() {
		StringBuilder ans = new StringBuilder();
		int i = 0;
		while (d.get(i) != '\0') {
			ans.append(d.get(i++));
		}
		return ans.toString();
	}
	  
	public void pLn(String string) {
		System.out.print(string);
		System.out.println(this.toString());
	}
	  
	public void append(String string) {
		int start = 0;
		while (d.get(start) != '\0') {
			start++;
		}
		for (int i = start; i < start + string.length(); i++) {
			d.set(i, string.charAt(i - start));
		}
	}
	
	public void append(Cstring b) {
		this.append(b.toString());
	}
	
	public Cstring add(String string) {
		CharArray ans = new CharArray();
		int start = 0;
		while (d.get(start) != '\0') {
			ans.set(start, d.get(start));
			start++;
		}
		for (int i = start; i < start + string.length(); i++) {
			ans.set(i, string.charAt(i - start));
		}
		Cstring obj = new Cstring(ans);
		return obj;
	}
	
	public Cstring add(Cstring b) {
		return this.add(b.toString());
	}
	  
	public boolean isEqual(Cstring b) {
		int i = 0;
		while (!((d.get(i) == '\0') || (b.get(i) == '\0')))  {
			if (d.get(i) != b.get(i))
				return false;
			i++;
		}
		if (d.get(i) != b.get(i))
			return false;
		else
			return true;
	}

	public char get(int i) {
		return d.get(i);
	}
	
	public int length() {
		int i = 0;
		while (d.get(i++) != '\0') {}
		i--;
		return i;
	}

	public void trimLeftZero() {
		CharArray ans = new CharArray();
		int i = 0, j = 0;
		boolean flag = false;
		while (d.get(i) != '\0') {
			if ((d.get(i) != '0') || (flag)) {
				ans.set(j, d.get(i));
				j++;
				flag = true;
			}
			i++;
		}
		if (ans.get(0) == '\0') {
			ans.set(0, '0');
			j++;
		}
		ans.set(j, '\0');
		this.d = ans;	
	}
  
}