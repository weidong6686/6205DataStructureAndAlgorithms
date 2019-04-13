

/**
 * File Name: IntSlist2.java Slist of int
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java
 */

public class IntSlist2 {
  /*
   * protected data members
   */
  protected node first;
  //Cannot add last
  //Cannot add size
  //Cannot add anything here
  protected static final IntUtil u = new IntUtil();

   protected class node {
    //Cannot change anything in this class
    protected final int d; //You cannot change d or t
    protected final int t ;//Used for testing stable sort
    protected node next; //You should manipulate only next

    protected node(int x,int y) {
      d = x;
      t = y ;
      next = null;
    }
  }

  public IntSlist2() {
    first = null;
  }

  /*
   * Returns the number of elements in this list.
   * DO NOT CHANGE THIS FUNCTION
   */
  protected int size() {
    int n = 0 ;
    node s = first ;
    while (s!= null) {
      ++n ;
      s = s.next ;
    }
    return n ;
  }

  /*
   * Appends int x to the end of this list.
   * WRITE CODE
   */
  protected node add(int x,int y, node last) {
	  node n = new node(x, y);
	  if (last != null)
		  last.next = n;
	  else { 
		  first = n;
		  last = n;
	  }
	  return n;
  }
  
  /*
   * Get last node of the linked list
   * DO NOT CHANGE THIS FUNCTION
   */
  protected node getLastNode() {
    node c = first;
    node last = null ;
    while (c != null) {
      last = c ;
      c = c.next ;
    }
    return last ;
  }
  
  /*
   * Reverse slist without using recursion Write code below
   * WRITE CODE
   */
  protected void reverse() {
	  node pre = null;
	  node cur =first;
	  while (cur != null) {  // reverse the point direction;
	      node nextNode = cur.next;
	      cur.next = pre;
	      pre = cur;
	      cur = nextNode;
	      }
	  first = pre;
	  }

  /* NOTHING CAN BE CHANGED BELOW */
  /*
   * 0 1 2 is ok 1 0 2 is not ok
   * DO NOT CHANGE THIS FUNCTION
   */
  protected void assertSlistInAscending() {
    node t = first;
    if (t != null) {
      node prev = t;
      node next = t.next;
      while (next != null) {
        if (next.d < prev.d) {
          u.myassert(false);
        }
        if (prev.d == next.d) {
          //assures stable sort
          u.myassert(prev.t < next.t);    
        }
        prev = next;
        next = next.next;
      }
    }
  }

  /*
   * 2 1 0 is ok 1 0 2 is not ok
   * DO NOT CHANGE THIS FUNCTION
   */
  protected void assertSlistInDescending() {
    node t = first;
    if (t != null) {
      node prev = t;
      node next = t.next;
      while (next != null) {
        if (next.d > prev.d) {
          u.myassert(false);
        }
        if (prev.d == next.d) {
          //assures stable sort
          //Because we are not allowed to change data
          u.myassert(prev.t > next.t);    
        }
        prev = next;
        next = next.next;
      }
    }
  }
  
  /* Factory method. Build an slist from an array */
  //DO NOT CHANGE THIS FUNCTION
  protected static IntSlist2 buildSlist(int [] a) {
    IntSlist2 l = new IntSlist2();
    int n = a.length ;
    node last = null ;
    for (int i = 0; i < n; ++i) {
      int x = a[i] ;
      last = l.add(x,i,last);
    }
    return l;
  }

  /*
   * Print a linked list
   * DO NOT CHANGE THIS FUNCTION
   */
  protected void pLn(node n) {
    while (n != null) {
      System.out.print(n.d);
      if (n.next == null) {
        System.out.print("->NIL");
      } else {
        System.out.print("->");
      }
      n = n.next;
    }
    System.out.println();
  }
  
  protected void pLn() {
    node n = first;
    pLn(n);
  }

  /*
   * Print a linked list with title
   */
  public void pLn(String t, node n) {
    System.out.print(t);
    pLn(n);
  }
  
  public void pLn(String t, node s, node e) {
    System.out.print(t);
    if (s == null) {
      System.out.println() ;
      return ;
    }
    if (s == e) {
      System.out.print(s.d);
      if (s.next == null) {
        System.out.print("->->->NIL");
      }else {
        System.out.print("->->->" + e.next.d);
      }
      System.out.println();
      return ;
    }
    node n = s;
    if (n != null) { 
      boolean done = false ;
      do {
        System.out.print(n.d);
        if (n == e) {
          if (n.next == null) {
            System.out.print("->->->NULL");
          }else {
            System.out.print("->->->" + n.next.d);
          }
          done = true ;
        }else {
          System.out.print("->");
        }
        n = n.next; 
      }while (done == false) ;  
    } 
    System.out.println();
  }
  
  protected void pLn(String t) {
    System.out.print(t);
    pLn();
  }
  
  
  protected static void test1() {
    IntSlist2 l = new IntSlist2();
    node last = null ;
    for (int i = 0; i < 8; ++i) {
      last = l.add(i,i,last);
    }
    l.pLn("After adding 8 elements: ");
    int [] a = {9, 6, 7, 10};
    IntSlist2 l2 = IntSlist2.buildSlist(a) ;
    l2.pLn("l2: ");
  }
 

  protected static void testbed() {
    test1();
    System.out.println("---- test1 passed ------------");
  }

  public static void main(String[] args) {
    System.out.println("IntSlist.java");
    testbed();
    System.out.println("Done");
  }
}
