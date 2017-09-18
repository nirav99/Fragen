package com.arrays_strings;
/**
 * Traverse the matrix in a spiral order
 * @author nirav99
 *
 */
public class MatrixSpiralTraversal
{  
	public static void printSpiral(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int rstart = 0;
		int rend = rows - 1;
		int cstart = 0;
		int cend = cols - 1;
		
		while(true)
		{
			traverseUpperRow(matrix, rstart, cstart, cend);
			if(++rstart > rend) break;
			
			traverseRightColumn(matrix, rstart, rend, cend);
			if(--cend < cstart) break;
			
			traverseLowerRow(matrix, rend, cstart, cend);
			if(--rend < rstart) break;
			
			traverseLeftColumn(matrix, rstart, rend, cstart);
			if(++cstart > cend) break;
		}
		System.out.println("\n");
	}
	
	private static void traverseUpperRow(int[][] matrix, int rstart, int colstart, int colend)
	{
		for(int i = colstart; i <= colend; i++)
			print(matrix[rstart][i]);
	}
	
	private static void traverseRightColumn(int[][] matrix, int rstart, int rend, int colend)
	{
		for(int i = rstart; i <= rend; i++)
			print(matrix[i][colend]);
	}
	
	private static void traverseLowerRow(int[][] matrix, int rend, int colstart, int colend)
	{
		for(int i = colend; i >= colstart; i--)
			print(matrix[rend][i]);
	}
	
	private static void traverseLeftColumn(int[][] matrix, int rstart, int rend, int colstart)
	{
//		System.out.println("rstart = " + rstart + " rend = " + rend + " cstart = " + colstart);
		for(int i = rend; i >= rstart; i--)
			print(matrix[i][colstart]);
	}
	
	private static void print(int x)
	{
		System.out.print(x + " ");
	}
	
	public static void main(String[] args)
	{
		try
		{
		  int[][] matrix = new  int[1][1];
		  matrix[0][0] = 1;
		  printSpiral(matrix);
		  
		  matrix = new int[2][2];
		  initializeMatrix(matrix);
		  printSpiral(matrix);
		  
		  matrix = new int[2][3];
		  initializeMatrix(matrix);
		  printSpiral(matrix);
		  
		  matrix = new int[3][3];
		  initializeMatrix(matrix);
		  printSpiral(matrix);
		  
		  matrix = new int[4][4];
		  initializeMatrix(matrix);
		  printSpiral(matrix);
		}
		catch(Exception e)
		{
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void initializeMatrix(int[][] matrix)
	{
		int count = 1;
		for(int i = 0; i < matrix.length; i++)
	    for(int j = 0; j < matrix[0].length; j++)
	    	matrix[i][j] = count++;
	}
}
