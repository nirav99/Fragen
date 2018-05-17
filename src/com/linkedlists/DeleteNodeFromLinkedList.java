package com.linkedlists;

/**
 * Delete node(s) matching the given data from the singly linked list
 * @author nirav99
 *
 */
public class DeleteNodeFromLinkedList
{
  private class Node
  {
  	int data;
  	Node next;
  	
  	Node(int data)
  	{
  		this.data = data;
  		next = null;
  	}
  }
  
  private Node head;
  private Node tail;
  
  
  public void addToLinkedList(int[] dataArray)
  {
  	for(int data : dataArray)
  		addNodeToList(data);
  }
  
  private void addNodeToList(int data)
  {
  	if(head == null)
  	{
  		head = new Node(data);
  		tail = head;
  	}
  	else
  	{
  		tail.next = new Node(data);
  		tail = tail.next;
  	}
  }
  
  public void deleteNodes(int data)
  {
    if(head == null)
    {
    	System.err.println("Error: can't delete from empty list");
    	return;
    }
    
    // Delete the matching nodes at the start of the list
    while(head != null && head.data == data)
    	head = head.next;
    
    if(head == null)
      return;
    
    Node first = head;
    Node last = first;
    
    Node trav = head.next;
    
    while(trav != null)
    {
    	if(trav.data != data)
    	{
    		last.next = trav;
    		last = last.next;
    	}
    	trav = trav.next;
    }
    
    last.next = null;
    head = first;
  }
  
  public void printLinkedList()
  {
  	if(head == null)
  		System.out.println("Empty list");
  	else 
  	{
  		for(Node trav = head; trav != null; trav = trav.next)
  			System.out.print(trav.data + " ");
  		System.out.println();
  	}
  }
  
  public static void main(String[] args)
  {
  	try
  	{
  		
  		
  		int[] input1 = {3, 3, 3};
  		int[] input2 = {3, 3, 4};
  		int[] input3 = {1, 3, 3};
  		int[] input4 = {1, 3, 3, 3, 4};
  		int[] input5 = {1, 3, 4};
  		int[] input6 = {1, 2, 3};
  		int[] input7 = {1, 2, 3, 3};
  		
  		test(input1);
  		test(input2);
  		test(input3);
  		test(input4);
  		test(input5);
  		test(input6);
  		test(input7);
  	}
  	catch(Exception e)
  	{
  		System.err.println(e.getMessage());
  		e.printStackTrace();
  	}
  }
  
  private static void test(int[] input)
  {
  	DeleteNodeFromLinkedList dll = new DeleteNodeFromLinkedList();
  	dll.addToLinkedList(input);
  	System.out.println("Original list : ");
  	dll.printLinkedList();
  	System.out.println();
  	System.out.println("Linked list after removing 3 : ");
  	dll.deleteNodes(3);
  	dll.printLinkedList();
  	System.out.println("=============================\n");
  }
}
