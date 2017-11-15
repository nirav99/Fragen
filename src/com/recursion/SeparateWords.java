package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * You are given a string that contains multiple words but spacing between the words is lost.
 * You are also given a dictionary that contains all possible words.
 * Your task is to find all valid word separations in the given string.
 * @author nirav99
 *
 */
public class SeparateWords
{
  private HashSet<String> dictionary;
  private List<String> solutionList;
  
  public SeparateWords(String input, HashSet<String> dictionary)
  {
  	this.dictionary = dictionary;
  	this.solutionList = new ArrayList<String>();
  	findWords(input, null, true);
  	printAllSolutions(input);
  }
  
  private void findWords(String input, List<String> currentSolution, boolean isFirstIteration)
  {
  	for(int i = 1; i <= input.length(); i++)
  	{
  		String[] parts = splitString(input, i);
  		
  		if(isFirstIteration)
  		{
  			currentSolution = new ArrayList<String>();
  		}
  		
  		// If the dictionary contains first part of the string, then continue with the rest.
  		// Else iterate over the next separation
  		if(dictionary.contains(parts[0]))
  		{
  			currentSolution.add(parts[0]);
  			
  			if(parts[1] == null || parts[1].isEmpty())
  			{
  			  // Add current solution to final solution
  				addCurrentSolutionToFinalSolution(currentSolution);
  			}
  			else
  			{
//  				System.out.println("Recursing on : " + parts[1]);
  				findWords(parts[1], currentSolution, false);
  			}
  		}
  	}
  }
  
  private void addCurrentSolutionToFinalSolution(List<String> currentSolution)
  {
  	StringBuilder result = new StringBuilder();
  	
  	for(String s : currentSolution)
  		result.append(s).append("/");
  	
  	result.setLength(result.length() - 1);
  	
  	solutionList.add(result.toString());
  }
  
  private String[] splitString(String input, int index)
  {
  	String[] parts = new String[2];
  	parts[0] = input.substring(0, index);
  	parts[1] = input.substring(index);
  	
//  	System.out.println("Parts[0] : " + parts[0] + " Parts[1] : " + parts[1]);
  	return parts;
  }
  
  private void printAllSolutions(String input)
  {
  	System.out.println("Word separation for " + input);
  	
  	if(solutionList.size() < 1)
  		System.out.println("No solutions exist");
  	for(String solution : solutionList)
      System.out.println(solution);
  	
  	System.out.println("================");
  }
  
  public static void main(String[] args)
  {
  	try
  	{
  		HashSet<String> dictionary = new HashSet<String>();
  		dictionary.addAll(Arrays.asList(new String[]{"elon", "musk"}));
  		String input = "elonmusk";
  		SeparateWords sw = new SeparateWords(input, dictionary);
  		
  		dictionary = new HashSet<String>();
  		dictionary.addAll(Arrays.asList(new String[]{"j", "k", "jk", "rowling"}));
  		input = "jkrowling";
  		sw = new SeparateWords(input, dictionary);
  		
  		dictionary = new HashSet<String>();
  		dictionary.addAll(Arrays.asList(new String[]{"j", "k", "jk", "rowling"}));
  		input = "jkrowlings";
  		sw = new SeparateWords(input, dictionary);
  		
  		dictionary = new HashSet<String>();
  		dictionary.addAll(Arrays.asList(new String[]{"switzerland"}));
  		input = "switzerland";
  		sw = new SeparateWords(input, dictionary);
  	}
  	catch(Exception e)
  	{
  		e.printStackTrace();
  	}
  }
}
