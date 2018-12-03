package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import org.testng.annotations.AfterMethod;

public class Pactise {
  @Test
  public void f() {
	  
	  ArrayList<String> al = new ArrayList<String>();
	  
	  ArrayList<String> al1 = new ArrayList<String>();
	  
	  LinkedList<String> ll = new LinkedList<String>();
	  
	  Vector<String> vt = new Vector<String>();
	  
	  Stack<String> st = new Stack<String>();
	  
	  Queue<String> q1 = new PriorityQueue<String>();  
	  
	  Deque<String> q2 = new ArrayDeque<String>();
	  
	  HashSet<String> s1 = new HashSet<String>();  
	  LinkedHashSet<String> s2 = new LinkedHashSet<String>();  
	  TreeSet<String> s3 = new TreeSet<String>();  
	  Map<Integer,String> hm = new HashMap<Integer,String>();
	  
	  al.add("Vijay");
	  al.add("Rahul");
	  al.add("Raj");
	  al.add("Vijay");
	  al.add("Rasika");
	  al.add("Yuvraj");
	  
	 	  
	  System.out.println("Itearating Array List through Iterator....\n");
	  Iterator<String> itr = al.iterator();
	  
	  while(itr.hasNext()) {
		  
		  System.out.println(itr.next());
	  }
	  
	  System.out.println("Itearating Array List through ListIterator....\n");
	  
	  ListIterator<String> li = al.listIterator();
	  
	 
	  // Elemetns using lis iterator
	  
	  while(li.hasNext()){
	  
	  System.out.println(li.next());
	  
	  }
	  
	  System.out.println("Creating Linked List and Traversing through ListIterator\n");  
	  ll.addAll(al);

	  ListIterator<String> li1 = ll.listIterator();
	 
		 
	 while(li1.hasNext()) {
		 
		 System.out.println(li1.next());
	 }
	 
	 System.out.println("Exmple of peek method \n");
	 System.out.println(ll.peek());
	 System.out.println("Exmple of peek first method \n");
	 System.out.println(ll.peekFirst());
	 System.out.println("Exmple of peek last method \n");
	 System.out.println(ll.peekLast());
	 System.out.println("Before Poll Method\n");
	 System.out.println(ll);
	 System.out.println("Exmple of poll method \n");
	 System.out.println(ll.poll());
	 System.out.println("After Poll Method\n");
	 System.out.println(ll);
	 System.out.println("Example of Pop Method\n");
	 System.out.println(ll.pop());
	 System.out.println("After Pop Method\n");
	 System.out.println(ll);
	 ll.set(1, "Rajendra");
	 System.out.println("After Set\n");
	 System.out.println(ll);
	 ll.offer("Offer");
	 System.out.println("After Offer\n");
	 System.out.println(ll);
	 vt.addAll(ll);
	 System.out.println("Displaying Vector\n");
	 System.out.println(vt);
	 st.addAll(vt);
	 System.out.println("Displaying Stack\n");
	 System.out.println(st);
	 System.out.println("Pushing item to Stack\n");
	 st.push("Pushing");
	 System.out.println("After Pushing Stack\n");
	 System.out.println(st);
	 System.out.println("Poping item to Stack\n");
	 st.pop();
	 System.out.println("After Popping Stack\n");
	 System.out.println(st);
	 q1.addAll(ll);
	 System.out.println("Displaying Priority Queue\n");
	 System.out.println(q1);
	 q1.poll();
	 System.out.println("After Pop\n");
	 System.out.println(q1);
	 q2.addAll(q1);
	 System.out.println("After Q2\n");
	 System.out.println(q2);
	 s1.addAll(ll);
	 System.out.println("Displaying HashSet");
	 System.out.println(s1);
	 s1.add("Raj");
	 System.out.println("Displaying HashSet after adding duplicate");
	 System.out.println(s1);
	 
	 s3.addAll(s1);
	 System.out.println("Displaying Tree Set");
	 System.out.println(s3);
	 
	 hm.put(1, "Vijay");
	 hm.put(2,"Ajay");
	 hm.put(3, "Aniket");
	 System.out.println("Displaying HashMap using get method");
	 System.out.println(hm.get(1));
	
	System.out.println(hm.entrySet());
	
	Set<Entry<Integer, String>> set = hm.entrySet();
	
	Iterator<Entry<Integer, String>> itr1 = set.iterator();
	
	while(itr1.hasNext()) {
		
		Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)itr1.next();
		System.out.println(entry.getKey()+" " +entry.getValue());
		
	}
	 
	q1.add("");
	
	System.out.println(q1);	 
	
	
  }
}
