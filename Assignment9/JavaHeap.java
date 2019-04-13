import java.util.Comparator;
import java.util.PriorityQueue;



/**
 * File Name: JavaHeap.java 
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java GraphM.java GraphMTester.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

class JavaHeap{
	private class Node {
		private int num ;
		Node(int num) {
			this.num = num ;
			
		}
	}
	private class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node x, Node y) {
      return -(x.num - y.num);
    }
  }
	
	void testmin() {
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> minheap = new PriorityQueue<Node>(10,comparator);
		for (int i = 10; i >= 0; --i) {
			Node n = new Node(i) ;
			minheap.add(n) ;
		}
		for (int i = 10; i >= 0; --i) {
			Node n = minheap.peek() ;
	    minheap.remove();
	    System.out.print(n.num + " ");
		}
		System.out.println() ;
    
	}
	
	public static void main(String[] args) {
		System.out.println("JavaHeap Starts");
		JavaHeap j = new JavaHeap() ;
		j.testmin() ;
		System.out.println("JavaHeap ENDS");
	}
}