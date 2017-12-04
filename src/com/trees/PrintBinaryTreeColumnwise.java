package com.trees;

import java.util.*;

/**
 * Given a binary tree, not necessarily a binary search tree, print it column wise. If there are multiple nodes on the same column, print them 
 * in increasing order of height.
 * e.g. Given a tree,
 * 
 *       5
 *     6   7
 *   8   9
 *   
 *   you should print 8 6 5 9 7
 * @author nirav99
 *
 */
public class PrintBinaryTreeColumnwise
{
  class TreeNode implements Comparable<TreeNode>
  {
    int data;
    TreeNode left;
    TreeNode right;
    int height;
    int column;
    
    TreeNode(int data)
    {
      this.data = data;
      left = null;
      right = null;
      height = -1;
      column = -1;
    }

    @Override
    public int compareTo(TreeNode other)
    {  
      if(this.column < other.column)
        return 1;
      else
      if(this.column > other.column)
        return -1;
      else
      {
        if(this.height < other.height)
          return -1;
        return 1;
      }
    }
  }
  
  private TreeNode root = null;
  private Random rn;
  
  private PrintBinaryTreeColumnwise(int numNodes)
  {
    rn = new Random();
    int value = rn.nextInt(100);
    System.out.println("Root value : " + value);
    root = new TreeNode(value);
    
    for(int i = 0; i < numNodes - 1; i++)
      addNode(new TreeNode(rn.nextInt(100)));
    
    assignHeight(root, 0);
    assignColumn(root, numNodes);
    
    System.out.println("Original tree (pre-order) : ");
    printPreOrder(root);
    System.out.println();
    
    List<TreeNode> list = new ArrayList<TreeNode>();
    buildListOfNodes(root, list);

    Collections.sort(list);
    System.out.println("Printing tree column-wise :");
    printList(list);
    
  }
  
  /**
   * Although I am building a binary search tree, the columnwise printing should work for any binary tree
   * @param n
   */
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
          break;
        }
      }
    }
  }
  
  private void printPreOrder(TreeNode n)
  {
    if(n != null)
    {
      System.out.print(n.data + " ");
      printPreOrder(n.left);
      printPreOrder(n.right);
    }
  }
  
  /**
   * Assign height to every node in the tree
   * @param n
   * @param height
   */
  private void assignHeight(TreeNode n, int height)
  {
    if(n != null)
    {
      n.height = height;
      assignHeight(n.left, height + 1);
      assignHeight(n.right, height + 1);
    }
  }
  
  private void assignColumn(TreeNode n, int column)
  {
    if(n != null)
    {
      n.column = column;
      assignColumn(n.left, column - 1);
      assignColumn(n.right, column + 1);
    }
  }
  
  /**
   * Traverse the tree, and copy every node to the list
   * @param n
   * @param list
   */
  private void buildListOfNodes(TreeNode n, List<TreeNode> list)
  {
    if(n != null)
    {
      list.add(n);
      buildListOfNodes(n.left, list);
      buildListOfNodes(n.right, list);
    }
  }
  
  private void printList(List<TreeNode> list)
  {
    for(TreeNode n : list)
      System.out.print(n.data + " ");
    System.out.println();
  }
  
  public static void main(String[] args)
  {
    try
    {
      PrintBinaryTreeColumnwise bt = new PrintBinaryTreeColumnwise(5);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
