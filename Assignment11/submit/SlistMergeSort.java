/**
 * File Name: SlistMergeSort.java 
 * Sort int slist using Merge Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort{
	//You are free to add any number of private data and private functions 
  
  @Override
  protected void sort() {
	  a.first = mergeSort(a.first);
  }
  
  private  node  mergeSort(node first) {
	    if (first == null || first.next == null)
	    	return first; 
		  if (display) {
			  System.out.print("before partition a = ");
			  pLn(first);
		  }
	      // cut the list into two lists in the middle
	      node slow = first, fast = first.next;
	      while (fast != null && fast.next != null) {
	    	  slow = slow.next;
	    	  fast = fast.next.next;
	    	  }
	      node mid = slow.next; // slow is mid or mid -1;
	      slow.next = null;   //cut list;
	      //recursion and sort each list
		  if (display) {
			  System.out.print("after partition a = ");
			  pLn(first);
			  System.out.print("after partition b = ");
			  pLn(mid);
		  }
	      node l1 = mergeSort(first);
	      numRecursion++;
	      node l2 = mergeSort(mid);
	      numRecursion++;
	      return merge(l1, l2);
	      }
  
  private node merge(node l1, node l2) {
	    node dummy = new node(0,0);
	    node p = dummy;
	    while (l1 != null && l2 != null) {
	    	numCompare++;
	    	numSwap++;
	    	if (l1.d <= l2.d) {
	    		p.next = l1;
	    		l1 = l1.next;
	    		}else{
	    			p.next = l2;
	    			l2 = l2.next;
	    			}
	    	p = p.next;
	    	}
	    if (l1 != null)
	    	p.next = l1;
	    if (l2 != null)
	    	p.next = l2;
		  if (display) {
			  System.out.print("after merge = ");
			  pLn(dummy.next);
		  }
	    return dummy.next;
	  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
    u.testBench();
    System.out.println("SlistMergeSort.java DONE");
  }
}


