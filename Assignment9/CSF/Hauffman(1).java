import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Queue;

public class Hauffman {
	private String str;	//original string
	private String encodeStr;	//encoded by huffman codes
	private HashMap<Character, Integer> dic; //count characters
	private HashMap<Character, String> dic2; //characters' huffman codes
	private HashMap<String, Character> dic3; //characters' huffman codes
	private Node root;
	
	class Node {
		Character ch;
		Integer count;
		Integer num;
		Node left = null;
		Node right = null;
		
		Node(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
	}
	
	private class NodeComparator implements Comparator<Node> {
	    @Override
	    public int compare(Node x, Node y) {
	      return (x.count - y.count);
	    }
	  }

	public Hauffman(String s, boolean show, String dotfilename) {
		this.str = s;
		System.out.println("============ " + s + " +++++++++++++++");
		countChars();
		System.out.println("=======================================");
		makeTree();
		writeDot(dotfilename);
		printCode();
	}

	/**
	 * count characters
	 */
	private void countChars() {
		this.dic = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(dic.containsKey(c)) {
				int times = dic.get(c);
				times++;
				dic.put(c, times);
			} else {
				dic.put(c, 1);
			}
		}
		for (Entry<Character, Integer> entry : dic.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " occurs  " + value + " times");
		}
	}

	/**
	 * make the huffman tree
	 */
	private void makeTree() {		
		this.root = null;
		// make the tree
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(10, comparator);
		System.out.println("==== Tree built in this order===============");
		int i = 0;
		for (Entry<Character, Integer> entry : dic.entrySet()) {
			i++;
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("Leaf     node "+ i + " Character is "
					+ key + " Weight is " + value);
			
			Node node = new Node(key, value);
			node.ch = entry.getKey();
			node.count = entry.getValue();
			node.num = i;
			priorityQueue.add(node);
		}
		// make the tree
		int size = priorityQueue.size();
		for (int j = 0; j < size - 1; j++) {
			i++;
			Node node1 = priorityQueue.poll();
			Node node2 = priorityQueue.poll();

			Node sumNode = new Node('\0', 0);
			sumNode.ch = ' ';
			sumNode.count = node1.count + node2.count;
			sumNode.num = i;

			sumNode.left = node1;
			sumNode.right = node2;
			priorityQueue.add(sumNode);
			// output the merge procedure
			System.out.println("Internal node " + i + " : Left " + 
					node1.ch + "(" + node1.count + ") Right " +
					node2.ch + "(" + node2.count + ") Weight = " + sumNode.count);	
		}	
		this.root = priorityQueue.poll();
	}
	
	/**
	 * 	write the dot file
	 */
	private void writeDot(String dotfilename) {
		File file = new File(dotfilename);
		FileWriter fw;
		if (file.exists()) {
			file.delete();
		} 
		try {
			file.createNewFile();
			fw = new FileWriter(dotfilename);
			fw.write("digraph g {\r\n");
			fw.write(" lable = \" " + str + " \"\r\n");	
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				Node node = q.poll();
				Node temp;	
				
				temp = node.left;
				if (temp == null) {
					fw.write(" \"" + node.num + "\\n" + node.count + "\"\r\n");
					break;
				}				
				fw.write(" \"" + node.num + "\\n" + node.count + "\" ->\"");				
				fw.write(temp.num + "\\n" + temp.count);
				if (temp.left != null) { //if interval node
					q.add(temp);						
				} else {	//leaf node
					fw.write("\\n " + temp.ch);
				}
				fw.write("\" [color=red]\r\n");
				temp = node.right;
				fw.write(" \"" + node.num + "\\n" + node.count + "\" ->\"");				
				fw.write(temp.num + "\\n" + temp.count);
				if (temp.left != null) { //if interval node
					q.add(temp);						
				} else {	//leaf node
					fw.write("\\n " + (temp.ch == ' ' ? "blank" : temp.ch));
				}
				fw.write("\" [color=blue]\r\n");
			}
			fw.write("}\r\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * print the huffman code
	 */
	private void printCode() {
		StringBuilder path = new StringBuilder(); 
		this.dic2 = new HashMap<>();
		this.dic3 = new HashMap<>();
		printCodeHelper(root, path);			
		//output the huffman codes
		for (Entry<Character, String> entry : dic2.entrySet()) {
			Character key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " Has Code  " + value);
		}
	}
	
	private void printCodeHelper(Node node, StringBuilder path) {
		if ((node.left == null) && (node.right == null)) {
//			System.out.println(node.ch + " Has Code  " + path);		
			if (node == root)
				path = new StringBuilder("0");
			dic2.put(node.ch, path.toString());
			dic3.put(path.toString(), node.ch);
			return;
		}
		if (node.left != null) {
			path.append("0");
			printCodeHelper(node.left, path);
			path.deleteCharAt(path.length() - 1);
		}
		if (node.right != null) {
			path.append("1");
			printCodeHelper(node.right, path);
			path.deleteCharAt(path.length() - 1);
		}		
	}

	public String encode() {
		System.out.println("=======================================");
		System.out.println("======= Original String========");
		System.out.println(str);

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < str.length(); i++)	
			ans.append(dic2.get(str.charAt(i)));
		encodeStr = ans.toString();
		return encodeStr;
	}

	public String decode() {
		System.out.println("======= Decoded String========");
		System.out.println(encodeStr);

		StringBuilder ansStr = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < encodeStr.length(); i++)	{
			temp.append(encodeStr.charAt(i));
			if (dic3.containsKey(temp.toString())) {
				ansStr.append(dic3.get(temp.toString()));
				temp = new StringBuilder();
			}
		}
		System.out.println("======= Recovered String========");
		System.out.println(ansStr.toString());
		return ansStr.toString();
	}

}
