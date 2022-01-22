import java.io.*;
import java.util.*;
  public class DoublyLinkedList implements DoublyLinkedListInterface  {
	  
	  Node head = null;
	  Node tail = null;
	
  class Node {
	  
	  	int count;
	  	String word;
	  	Node next;
	    Node prev;
	    
  public Node(String word) {
		  
		  this.word = word;
		  this.count = 1; 
	  
	  }
	  
	 
  } 
 
  public void add(String word) {
	  //create new node
	  Node newNode = new Node(word);
	  
	  //check if head is empty
	  if (head == null) {
		  head = tail = newNode;
		  // make head prev null
		  head.prev = null;
		
		  //since the tail is the last node in the list it will point to null
		  tail.next = null;
	  } else {
		  boolean tag = false;
		  Node curr = head;
		  
		  while (curr != null) {
			  
			  if (curr.word.equals(word.toUpperCase())) {
				  curr.count++;
				  tag = true;
				  break;
			  }
			  curr = curr.next;
		  }
		 
		  if (!tag) {
			  //create new node after tail
			  tail.next = newNode;
			  // newNode's prev will point to tail
			  newNode.prev = tail;
			  //make newNode the tail
			  tail = newNode;
			  // tail's next point to null
			  tail.next = null;
		  }
		  sortList();
	  }
  }  // end add
  
  public void sortList() {
	  	Node index = null , curr = null;
	  	String word;
	  	int temp;
	  	
	  
	  //Check if list is empty
	  if (head == null) {
		  return;
	  } else {
		  //Current points to head
	  for (curr = head; curr.next != null; curr = curr.next) {
		  
		  //Index will point to node next to curr
	  for (index = curr.next; index != null; index = index.next) {
		  
		  //If curr is greater than index then swap the data of current and index
	  if (curr.count > index.count) {

	  temp = curr.count;
	  word = curr.word;
	  curr.count = index.count;
	  curr.word = index.word;
	  index.count = temp;
	  index.word = word;
	  }
	  }
	  }
	  }
	  }  //end sortlist()
  
  
  public void ascendingOrder() {
	//Node curre points to head
	  Node curr = head;
	  
	  //checks if head is empty
	if (head == null) {
		System.out.println("List is empty");
		return;
	}
	
	while (curr != null) {
	//Prints each node by incrementing the pointer.

		System.out.println(curr.word + ":" + curr.count);
		curr = curr.next;
	}
		System.out.println();
	} //end ascendingOrder()
  
  public void descendingOrder() {
	//Node curr points to tail
	  Node curr = tail;
	  
	  //checks if head is empty
	if (head == null) {
		System.out.println("List is empty");
		return;
	}
	while (curr != null) {
	//Prints each node by incrementing the pointer.
    
		System.out.println(curr.word + ":" + curr.count);
		curr = curr.prev;
	}
		System.out.println();
	} // end descendingOrder()
  
  
  
  
  
  public static void main(String[] args) throws IOException {
	  //create new doubly linked list
	  DoublyLinkedList list = new DoublyLinkedList();
	  
	  //insert file name that will be read
	  String filename = "src/input.txt";

	  //use scanner to read file
	  Scanner sc = new Scanner(new File(filename));

	  while (sc.hasNext()) {
		  list.add(sc.next().toUpperCase());
	  }
	  
	  	System.out.println("Ascending Order Word Count:");
	  	System.out.println("___________________________");
	  	list.ascendingOrder();

	 
	  	System.out.println("Descending Order Word Count:");
	  	System.out.println("____________________________");
	  	list.descendingOrder();
	  } // end main

}// end doubly linked list
  
  
