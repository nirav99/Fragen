package com.arrays_strings;
import java.util.*;

/**
 * There are N rods in a nuclear reactors numbered from 1 through N. Some rods have fused with each other and some rods are free.
 * A robot has to move these rods. The cost of moving a free rod is 1. 
 * The cost of moving fused rods is square root of the total number of rods fused. Thus, if 3 rods are fused together, the 
 * cost would be sqroot(3).
 * The input is a sequence of pairs of fused rods and the total number of rods.
 * e.g. total rods = 9 and pairs of fused rods is "1_2", "4_5", "6_7", "3_6", "7_2"
 * Given a total number of rods and the pairs of fused rods, find the cost of moving these rods.
 * @author nirav99
 *
 */
public class CostFusedRods
{
  private static boolean DEBUG_MODE = false;
  
  public static int findCost(int N, String[] fusedRodPairs)
  {
    HashSet<Integer> fusedRods = new HashSet<Integer>();
    
    int[] listNum = new int[N];
    
    for(int i = 0; i < fusedRodPairs.length; i++)
      processRodPair(fusedRodPairs[i], listNum, fusedRods);
    
    if(DEBUG_MODE)
    {
      System.out.println("lists ");
    
      for(int i = 0; i < listNum.length; i++)
      {
        System.out.println((i + 1) + " : " + listNum[i]);
      }
    }
    
    int numFreeRods = N - fusedRods.size();
    
    if(DEBUG_MODE)
      System.out.println("Num. free rods = " + numFreeRods);
    
    int cost = numFreeRods;
    
    for(int idx = 1; idx < getNextListNumber(listNum); idx++)
    {
      int numElements = countNumElementsForList(listNum, idx);
      cost = cost + (int) Math.ceil(Math.pow(numElements, 0.5));
    }
    
    if(DEBUG_MODE)
      System.out.println("COST = " + cost);
    
    return cost;
  }
  
  private static void processRodPair(String rodPair, int[] listNum, HashSet<Integer> fusedRods)
  {
    String[] rods = rodPair.split("_");
    
    int rod1 = Integer.parseInt(rods[0]);
    int rod2 = Integer.parseInt(rods[1]);
    
    fusedRods.add(rod1);
    fusedRods.add(rod2);
    
    // Rod numbers are 1 to N.
    // Array indexes are 0 to N - 1.
    rod1--;
    rod2--;
    
    int listN1 = listNum[rod1];
    int listN2 = listNum[rod2];
    
    int nextListNum = getNextListNumber(listNum);
    
    if(listN1 == 0 && listN2 == 0)
    {
      listNum[rod1] = nextListNum;
      listNum[rod2] = nextListNum;
    }
    else
    if(listN1 > 0 && listN2 == 0)
    {
      listNum[rod2] = listNum[rod1];
    }
    else
    if(listN2 > 0 && listN1 == 0)
    {
      listNum[rod1] = listNum[rod2];
    }
    else
    if(listN1 > 0 && listN2 > 0)
    {
      if(listN1 < listN2)
        move(listNum, listN2, listN1);
      else
        move(listNum, listN1, listN2);
    }
  }
  
  private static void move(int[] listNum, int srcListNum, int destListNum)
  {
    for(int i = 0; i < listNum.length; i++)
    {
      if(listNum[i] == srcListNum)
        listNum[i] = destListNum;
    }
  }
  
  private static int getNextListNumber(int[] listNum)
  {
    int max = -1;
    
    for(int i = 0; i < listNum.length; i++)
      if(max < listNum[i])
        max = listNum[i];
    
    return max + 1;
  }
  
  private static int countNumElementsForList(int[] listNum, int collectionNumber)
  {
    int total = 0;
    
    for(int i = 0; i < listNum.length; i++)
    {
      if(listNum[i] == collectionNumber)
        total++;
    }
    return total;
  }
  
  public static void main(String[] args)
  {
    try
    {
      int N = 9;
      String[] fusedRods = {"1_2", "4_5", "6_7", "3_6", "7_2"};
      
      int cost = findCost(N, fusedRods);
      System.out.println(cost);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
