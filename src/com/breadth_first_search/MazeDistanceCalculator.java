package com.breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * You are given a maze with three types of nodes, the Wall nodes (W), Gate nodes (G) and open nodes (_).
 * Your task is to find the distance to the closest Gate node for each open node.
 * In the maze, you can only travel up, down, left or right.
 * If there's a wall node, you can't travel through it.
 * @author nirav99
 *
 */
public class MazeDistanceCalculator
{
  private List<List<Node>> maze;
  private int maxRows;
  private int maxCols;
  
  MazeDistanceCalculator(List<List<Node>> maze)
  {
    this.maze = maze;
    this.maxRows = maze.size();
    this.maxCols = maze.get(0).size();
  }
  
  public void findDistance()
  {
    Queue<Node> queue = new ArrayDeque<Node>();
    
    List<Node> gateNodes = getAllGates();
    
    for(Node g : gateNodes)
      queue.add(g);
    
    while(!queue.isEmpty())
    {
      Node nextNode = queue.poll();
      List<Node> neighbors = getNeighbors(nextNode);
      
      if(neighbors != null)
      {
        for(Node neighbor : neighbors)
        {
          neighbor.distToGate = nextNode.distToGate + 1;
          neighbor.isVisited = true;
          queue.add(neighbor);
        }
      }
    }
    
    printMaze();
  }
  
  public static void main(String[] args)
  {
    try
    {
      List<List<Node>> maze = new ArrayList<List<Node>>();
      List<Node> l1 = new ArrayList<Node>();
      l1.add(new Node('_', 0, 0));
      l1.add(new Node('W', 0, 1));
      l1.add(new Node('_', 0, 2));
      maze.add(l1);
      
      List<Node> l2 = new ArrayList<Node>();
      l2.add(new Node('_', 1, 0));
      l2.add(new Node('W', 1, 1));
      l2.add(new Node('G', 1, 2));
      maze.add(l2);
      
      List<Node> l3 = new ArrayList<Node>();
      l3.add(new Node('G', 2, 0));
      l3.add(new Node('_', 2, 1));
      l3.add(new Node('W', 2, 2));
      maze.add(l3);
      
      MazeDistanceCalculator mazeDist = new MazeDistanceCalculator(maze);
      mazeDist.findDistance();
    }
    catch(Exception e)
    {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }
  
  /**
   * Gets all the gate nodes from the maze
   * @return
   */
  private List<Node> getAllGates()
  {
    List<Node> gates = new ArrayList<Node>();
    
    for(int i = 0; i < maxRows; i++)
    {
      for(int j = 0; j < maxCols; j++)
      {
        Node n = maze.get(i).get(j);
        if(n.ch == 'G' || n.ch == 'g')
          gates.add(n);
      }
    }
    
    return gates;
  }
  
  /**
   * Given a node, find the neighboring nodes that can be visited, and are open nodes.
   * @param n
   * @return
   */
  private List<Node> getNeighbors(Node n)
  {
    List<Node> neighbors = new ArrayList<Node>();
    
    int row = n.row;
    int col = n.col;
    
    if(row - 1 >= 0)
      addNodeToList(maze.get(row - 1).get(col), neighbors);
    if(col - 1 >= 0)
      addNodeToList(maze.get(row).get(col -1), neighbors);
    if(row + 1 < maxRows)
      addNodeToList(maze.get(row + 1).get(col), neighbors);
    if(col + 1 < maxCols)
      addNodeToList(maze.get(row).get(col + 1), neighbors);
    
    return neighbors.size() > 0 ? neighbors : null;
  }
  
  /**
   * Add a node to the list if it is an open node and can be visited
   * @param n
   * @param neighbors
   */
  private void addNodeToList(Node n, List<Node> neighbors)
  {
    if(shouldNodeBeVisited(n))
      neighbors.add(n);
  }
  
  /**
   * If a node has not been visited and is an open node, it returns true
   * @param n
   * @return
   */
  private boolean shouldNodeBeVisited(Node n)
  {
    return n.isVisited == false && (n.ch == '_');
  }
  
  /**
   * Prints the maze
   */
  private void printMaze()
  {
    for(int i = 0; i < maxRows; i++)
    {
      for(int j = 0; j < maxCols; j++)
      {
        Node n = maze.get(i).get(j);
        
        System.out.print(n.ch);
        
        if(n.ch == '_')
          System.out.print(":" + n.distToGate);
        
        System.out.print("\t");
      }
      System.out.println();
    }
  }
}

class Node
{
  char ch;
  boolean isVisited = false;
  int row;
  int col;
  int distToGate = Integer.MAX_VALUE;
  
  Node(char ch, int r, int c)
  {
    this.ch = ch;
    this.row = r;
    this.col = c;
    
    if(ch == 'g' || ch == 'G')
      distToGate = 0;
  }
}
