package com.trees;

import java.util.*;

/**
 * Create a linked list for all the nodes at a single level of a binary tree
 * @author nirav99
 *
 */
public class LinkedListForEachTreeLevel
{
  class TreeNode
  {
  	int data;
  	int height;
  	TreeNode left;
  	TreeNode right;
  	
    TreeNode(int data)
    {
      this.data = data;
      left = null;
      right = null;
      height = -1;
    }
  }
  
  private TreeNode root;
  
  public LinkedListForEachTreeLevel(int numNodes)
  {
    Random rn = new Random();
    int value = rn.nextInt(100);
    System.out.println("Root value : " + value);
    root = new TreeNode(value);
    root.height = 0;
    
    for(int i = 0; i < numNodes - 1; i++)
      addNode(new TreeNode(rn.nextInt(100)));
    
    System.out.println("Original tree (Pre-order) : ");
    printPreOrder(root);
    System.out.println();
    
    ArrayList<ArrayList<TreeNode>> resultList = new ArrayList<ArrayList<TreeNode>>();
    
    int prevLevel = -1;
    
    Deque<TreeNode> queue = new LinkedList<TreeNode>();
    
    queue.add(root);
    
    while(!queue.isEmpty())
    {
    	TreeNode next = queue.pollFirst();
    	
    	if(next.left != null)
    		queue.add(next.left);
    	if(next.right != null)
    		queue.add(next.right);
    	
    	if(next.height == prevLevel)
    	{
    		resultList.get(prevLevel).add(next);
    	}
    	else
    	{
    		ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
    		newList.add(next);
    		resultList.add(newList);
    		prevLevel++;
    		
    	}
    }
    
    printAllLinkedLists(resultList);
  }
  
  private void printAllLinkedLists(ArrayList<ArrayList<TreeNode>> resultList)
  {
    for(ArrayList<TreeNode> listOfNodes : resultList)
      printList(listOfNodes);
  }
  
  private void printList(ArrayList<TreeNode> list)
  {
	  for(TreeNode n : list)
	  	System.out.print(n.data + " ");
	  System.out.println();
  }
  
  private void addNode(TreeNode n)
  {
    TreeNode trav = root;
    
    while(true)
    {
      if(trav.data < n.data)
      {
        if(trav.left != null)
          trav = trav.left;
        else
        {
          trav.left = n;
          n.height = trav.height + 1;
          break;
        }
      }
      else
      {
        if(trav.right != null)
          trav = trav.right;
        else
        {
          trav.right = n;
          n.height = trav.height + 1;
          break;
        }
      }
    }
  }
  
  private void printPreOrder(TreeNode n)
  {
    if(n != null)
    {
      System.out.print("(" + n.data + ", height : " + n.height + ") ");
      printPreOrder(n.left);
      printPreOrder(n.right);
    }
  }
  
  public static void main(String[] args)
  {
    try
    {
    	LinkedListForEachTreeLevel bt = new LinkedListForEachTreeLevel(5);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
