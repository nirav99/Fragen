package com.arrays_strings;

/**
 * Rotate a square matrix 90 degrees clockwise while using constant space.
 * @author nirav99
 *
 */
public class RotateMatrixClockwise
{
  private int[][] matrix;
  private int dimension;
  
  private RotateMatrixClockwise(int dimension)
  {
    matrix = new int[dimension][dimension];
    this.dimension = dimension;
    
    int value = 1;
    
    for(int i = 0; i < dimension; i++)
    {
      for(int j = 0; j < dimension; j++)
      {
        matrix[i][j] = value++;
      }
    }
  }
  
  public void rotateMatrix()
  {
    System.out.println("Original Matrix :");
    printMatrix();
    transpose();
    swapColumns();
    System.out.println("Rotated Matrix :");
    printMatrix();
  }
  
  private void transpose()
  {
    int temp;
    for(int i = 0; i < dimension; i++)  
    {
      for(int j = i + 1; j < dimension; j++)
      {
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    
    System.out.println("Transposed Matrix : ");
    printMatrix();
  }
  
  /**
   * Swaps the first column with the last, 2nd with second last and so on
   */
  private void swapColumns()
  {
    int startCol = 0;
    int endCol = dimension - 1;
    int temp;
    
    while(startCol < endCol)
    {
      for(int i = 0; i < dimension; i++)
      {
        temp = matrix[i][startCol];
        matrix[i][startCol] = matrix[i][endCol];
        matrix[i][endCol] = temp;
      }
      startCol++;
      endCol--;
    }
  }
  
  private void printMatrix()
  {
    for(int i = 0; i < dimension; i++)
    {
      for(int j = 0; j < dimension; j++)
      {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    
    System.out.println("\n");
  }
  
  public static void main(String[] args)
  {
    try
    {
      RotateMatrixClockwise matrix = new RotateMatrixClockwise(4);
      matrix.rotateMatrix();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
