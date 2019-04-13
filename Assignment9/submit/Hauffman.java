import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hauffman {
	private String str;	//original string
	private String encodeStr;	//encoded by huffman codes
	private HashMap<Character, Integer> chartimes; //count character times
	private HashMap<Character, String> codes; //saving char and its codes
	private HashMap<String, Character> recodes; 
	private Node root;
	
	class Node {
		Integer num;
		Character ch;
		Integer weight;
		Node left = null;
		Node right = null;
		
		Node(char ch, int weight) {
			this.ch = ch;
			this.weight = weight;
		}
	}
	
	
	private class NodeComparator implements Comparator<Node> {
	    @Override
	    public int compare(Node x, Node y) {
	      return (x.weight - y.weight);
	    }
	  }

	public Hauffman(String s, boolean show, String dotfilename) {
		this.str = s;
		System.out.println("============ " + s + " +++++++++++++++");
		countChar();
		System.out.println("=======================================");
		buildTree();
		writeDot(dotfilename);
		printCode();
	}
	//	  count character frequency
	private void countChar() {
		this.chartimes = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(chartimes.containsKey(c)) {
				int times = chartimes.get(c);
				times++;
				chartimes.put(c, times);
				}
			else chartimes.put(c, 1);
			}
		for (Character key : chartimes.keySet()) {
			System.out.println(key + " occurs  " + chartimes.get(key) + " times");
		}
	}
	 // Build the huffman tree
	private void buildTree() {		
		this.root = null;
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(10, comparator);
		System.out.println("==== Tree built in this order===============");
		// Print leaf;
		int i = 0;
		for (Character key : chartimes.keySet()) {
			System.out.println("Leaf    node "+ (++i) + " Character is "+ key + " Weight is " + chartimes.get(key));
			Node node = new Node(key, chartimes.get(key));
			node.num = i;
			node.ch = key;
			node.weight = chartimes.get(key);
			priorityQueue.add(node);
			}
		// Print Internal node;
		int len = priorityQueue.size();
		if (len == 1) {  // one single root;
			Node merge = new Node('\0', 0);
			merge.num = ++i;
			merge.ch = ' ';
			merge.left = priorityQueue.poll();
			merge.weight = merge.left.weight;
			priorityQueue.add(merge);
			System.out.println("Internal node " + i + " : Left " + merge.left.ch + "(" + merge.left.weight + ") Right " + "null" + " Weight = " + merge.weight);
			}
		for (int j = 0; j < len - 1; j++) {
			Node node1 = priorityQueue.poll();
			Node node2 = priorityQueue.poll();
			Node merge = new Node('\0', 0);
			merge.num = ++i;
			merge.ch = ' ';
			merge.weight = node1.weight + node2.weight;
			merge.left = node1;
			merge.right = node2;
			priorityQueue.add(merge);
			System.out.println("Internal node " + i + " : Left " + node1.ch + "(" + node1.weight + ") Right " +
					node2.ch + "(" + node2.weight + ") Weight = " + merge.weight);
			}
		System.out.println("==== Tree has "+i+" nodes===============");
		this.root = priorityQueue.poll();
		}
	
//	write the dot file
	private void writeDot(String dotfilename) {
		System.out.println("You can see dot file at "+dotfilename);
		System.out.println("Run the following command to get pdf file");
		System.out.println("dot -Tpdf "+dotfilename+" -o "+dotfilename+".pdf");
		File file = new File (dotfilename);
		FileWriter fw;
		if (file.exists()) {
			file.delete();
			}
		try {
			file.createNewFile();
			fw = new FileWriter(dotfilename);
			fw.write("digraph g {\r\n lable = \" " + str + " \"\r\n");	
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				Node node = q.poll();
				Node left;
				left = node.left;
				// root is single leaf 
				if (left == null) {
					fw.write(" \"" + node.num + "\\n" + node.weight + "\"\r\n");
					break;
					}
				//root is not single
				fw.write(" \"" + node.num + "\\n" + node.weight + "\" ->\"");
				fw.write(left.num + "\\n" + left.weight);
				if (left.left != null) { // not leaf
					q.add(left);	
					} 
				else {	//leaf node
					fw.write("\\n " + left.ch);
					}
				fw.write("\" [color=red]\r\n");
				Node right = node.right;
				if (right != null) {
				fw.write(" \"" + node.num + "\\n" + node.weight + "\" ->\"");
				fw.write(right.num + "\\n" + right.weight);
				if (right.left != null) { //if interval node
					q.add(right);	
					} else {	//leaf node
						fw.write("\\n " + (right.ch == ' ' ? "blank" : right.ch));
						}
				fw.write("\" [color=blue]\r\n");
				}
			}
			fw.write("}\r\n");
			fw.flush();
			fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				}
		}
	
	// print each char's code;
	private void printCode() {
		System.out.println("============Code for each character in "+str+" ===============");
		StringBuilder sb = new StringBuilder(); 
		this.codes = new HashMap<>();
		this.recodes = new HashMap<>();
		printCodeHelper(root, sb);			
		for (Entry<Character, String> entry : codes.entrySet()) {
			Character key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " Has Code  " + value);
		}
	}
	private void printCodeHelper(Node node, StringBuilder sb) {
		if ((node.left == null) && (node.right == null)) {
			codes.put(node.ch, sb.toString());
			recodes.put(sb.toString(), node.ch);
			return;
		}
		if (node.left != null) {
			sb.append("0");
			printCodeHelper(node.left, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (node.right != null) {
			sb.append("1");
			printCodeHelper(node.right, sb);
			sb.deleteCharAt(sb.length() - 1);
		}		
	}	
	
	
	public String encode() {
		System.out.println("=======================================");
		System.out.println("======= Original String========");
		System.out.println(str);
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < str.length(); i++)	
			ans.append(codes.get(str.charAt(i)));
		encodeStr = ans.toString();
		return encodeStr;
	}

	public String decode() {
		System.out.println("======= Decoded String========");
		System.out.println(encodeStr);
		StringBuilder res = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < encodeStr.length(); i++)	{
			sb.append(encodeStr.charAt(i));
			if (recodes.containsKey(sb.toString())) {
				res.append(recodes.get(sb.toString()));
				sb = new StringBuilder();
			}
		}
		System.out.println("======= Recovered String========");
		System.out.println(res.toString());
		return res.toString();
	}

}
