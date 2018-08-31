package com.arrays_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a Sudoku board, validate that the board is valid. A Sudoku board is 9x9.
 * A board is valid if every row and column has all the digits from 1 to 9 exactly once AND
 * each 3x3 Square also has all the digits from 1 to 9.
 * @author nirav99
 *
 */
public class SudokuValidator
{
  public static boolean isSudokuBoardValid(int[][] board)
  {
    for(int i = 0; i < board.length; i++)
    {
      if(!isRowAndColumnValid(board, i))
      {
        System.out.println("Row/column " + i + " is invalid");
        return false;
      }
    }
    
    for(int i = 0; i < board.length; i +=3)
    {
      for(int j = 0; j < board.length; j+= 3)
      {
        if(!isSquareValid(board, i, j))
        {
          System.out.println("Square " + i + "," + j + " is invalid");
          return false;
        }
      }
    }
    return true;
  }
  
  private static boolean isRowAndColumnValid(int[][] board, int index)
  {
    int[] foundNumbers = new int[board.length];
    
    for(int j = 0; j < board.length; j++)
    {
      int num = board[index][j];
      
      if(num >= 1 && num <= 9)
      {
        foundNumbers[num - 1]++;
      }
      else
        return false;
    }
    
    for(int i = 0; i < board.length; i++)
    {
      int num = board[i][index];
      
      if(num >= 1 && num <= 9)
      {
        foundNumbers[num - 1]++;
      }
      else
        return false;
    }
    
    return foundAllNumbers(foundNumbers);
  }

  
  private static boolean foundAllNumbers(int[] foundNumbers)
  {
    for(int i = 0; i < foundNumbers.length; i++)
    {
      if(foundNumbers[i] != 2)
        return false;
    }
    return true;
  }
  
  private static void printBoard(int[][] board)
  {
    for(int i = 0; i < board.length; i++)
    {
      for(int j = 0; j < board[0].length; j++)
      {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  private static boolean isSquareValid(int[][] board, int startRow, int startCol)
  {
    Set<Integer> numbersFound = new HashSet<Integer>();
    
    for(int i = startRow; i < startRow + 3; i++)
    {
      for(int j = startCol; j < startCol + 3; j++)
      {
        int num = board[i][j];
        if(num >= 1 && num <= 9)
        {
          numbersFound.add(num);
        }
        else
          return false;
      }
    }
    return numbersFound.size() == 9;
  }
  
  public static void main(String[] args)
  {
    try
    {
      int[][] input1 = new int[][] {{6, 3, 9, 5, 7, 4, 1, 8 ,2},
                      {5, 4, 1, 8, 2, 9, 3, 7, 6},
                      {7, 8, 2, 6, 1, 3, 9, 5, 4},
                      {1, 9, 8, 4, 6, 7, 5, 2, 3},
                      {3, 6, 5, 9, 8, 2, 4, 1, 7},
                      {4, 2, 7, 1, 3, 5, 8, 6, 9},
                      {9, 5, 6, 7, 4, 8, 2, 3, 1},
                      {8, 1, 3, 2, 9, 6, 7, 4, 5},
                      {2, 7, 4, 3, 5, 1, 6, 9, 8}
      };
      
      int[][] input2 = new int[][] {{6, 3, 9, 5, 7, 4, 1, 8 ,2},
        {5, 4, 1, 8, 2, 9, 3, 7, 6},
        {7, 8, 2, 6, 1, 3, 9, 5, 4},
        {1, 9, 8, 4, 6, 7, 5, 2, 3},
        {3, 6, 5, 9, 8, 2, 4, 1, 7},
        {4, 2, 7, 1, 3, 5, 8, 6, 9},
        {9, 5, 6, 7, 4, 8, 2, 3, 1},
        {8, 1, 3, 2, 9, 6, 7, 4, 5},
        {2, 7, 4, 3, 5, 8, 6, 9, 1}
};

    validateBoard(input1);
    validateBoard(input2);
    }
    catch(Exception e)
    {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }
  
  private static void validateBoard(int[][] board)
  {
    printBoard(board);
    if(isSudokuBoardValid(board))
    {
      System.out.println("Sudoku board is valid");
    }
    else
    {
      System.out.println("Sudoku board is invalid");
    }
    System.out.println();
  }
}

