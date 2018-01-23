package com.matrices;

/**
 * Given an m x n matrix where all the rows and all the columns are sorted, write a function to efficiently search for a given number.
 * @author nirav99
 *
 */
public class SearchSortedMatrix
{
  private int[][] matrix;
  
  public SearchSortedMatrix(int[][] m)
  {
    this.matrix = m;
  }
  
  public boolean search(int num)
  {
    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;
    
    int currRow = 0;
    int currCol = totalColumns - 1;
    
    while(currRow < totalRows && currCol >= 0)
    {
      if(matrix[currRow][currCol] == num)
        return true;
      else
      if(matrix[currRow][currCol] > num)
        currCol--;
      else
        currRow++;
    }
    return false;
  }
  
  public static void main(String[] args)
  {
    try
    {
      int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
      printMatrix(matrix);
      
      SearchSortedMatrix sm = new SearchSortedMatrix(matrix);
      
      int[] searchElements = {5, 8, 0, 14, 1, 4};
      
      for(int elem : searchElements)
      {
        System.out.println("Searching for " + elem + " Found : " + sm.search(elem));
      }
        
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private static void printMatrix(int[][] matrix)
  {
    int totalRows = matrix.length;
    int totalColumns = matrix[0].length;
    
    for(int i = 0; i < totalRows; i++)
    {
      for(int j = 0; j < totalColumns; j++)
      {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
