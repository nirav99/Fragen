package com.recursion;
import java.util.*;

/**
 * Finds the solutions that add upto a given number.
 * Assumptions: only positive unique integers in the given array.
 * @author Nirav
 *
 */
public class NumbersAddingUpToThreshold
{
	private HashSet<HashSet<Integer>> allSolutions;
	private int[] input;
	private int target;
	
	public NumbersAddingUpToThreshold(int[] input, int target)
	{
		this.target = target;
		this.input = input;
		allSolutions = new HashSet<HashSet<Integer>>();
	}
	
	public void solve()
	{
		Arrays.sort(input);
		
    System.out.println("Sorted array : ");
    for(int i = 0; i < input.length; i++)
      System.out.print(input[i] + " ");
    System.out.println("\n");
    
		for(int i = 0; i < input.length; i++)
		{
			int sum = input[i];
			
			if(sum <= target)
			{
			  HashSet<Integer> soln = new HashSet<Integer>();
			  soln.add(sum);
				findRecursive(soln, sum, i + 1);
			}
		}
		
		Iterator<HashSet<Integer>> iter = allSolutions.iterator();
		
		System.out.println("Solutions where numbers sum to " + target + " : ");
		while(iter.hasNext())
			printSolution(iter.next());
	}
	
	private void findRecursive(HashSet<Integer> solution, int sum, int index)
	{
		if(sum == target)
		{
			allSolutions.add(solution);
			return;
		}
		else
		if(sum > target)
			return;
		// Now sum < target
		
		if(index < input.length)
		{
			int newSum = sum + input[index];
			
			if(newSum <= target)
			{
				HashSet<Integer> newSolution = new HashSet<Integer>(solution);
				newSolution.add(input[index]);
				findRecursive(newSolution, newSum, index + 1); // Add 
				findRecursive(solution, sum, index + 1);
			}
		}
	}
	
	private void printSolution(HashSet<Integer> soln)
	{
		Iterator<Integer> iter = soln.iterator();
		
		System.out.print("{ ");
		while(iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		System.out.println(" }");
	}
	
  public static void main(String[] args)
  {
    try
    {
      int[] input = {17, 8, 32, 3, 6, 4, 2, 1, 10, 0};
      int X = 10;
      
      NumbersAddingUpToThreshold xx = new NumbersAddingUpToThreshold(input, X);
      
      long startTime = System.currentTimeMillis();
      xx.solve();
      long endTime = System.currentTimeMillis();
      
      System.out.println("Execution time = " + (endTime - startTime)  + " msec");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
