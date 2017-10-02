package com.recursion;

/**
 * Prints all combinations of the given string
 * @author nirav99
 *
 */
public class Combinations
{
  public static void combinations(String data)
  {
    char[] input = data.toCharArray();
    char[] result = new char[input.length];
    
    combinationRecursive(input, result, 0, 0);
  }
  
  private static void combinationRecursive(char[] input, char[] result, int readIndex, int writeIndex)
  {
    for(int i = readIndex; i < input.length; i++)
    {
      result[writeIndex] = input[i];
      print(result, writeIndex);
      
      if(i < input.length - 1)
        combinationRecursive(input, result, i + 1, writeIndex + 1);
    }
  }
  
  private static void print(char[] array, int len)
  {
    String output = new String(array);
    System.out.println(output.substring(0, len + 1));
  }
  
  public static void main(String[] args)
  {
    try
    {
      String[] inputs = {"a", "ab", "abc"};
      
      for(String input : inputs)
      {
        System.out.println("Input : " + input);
        System.out.println("Combinations : ");
        combinations(input);
        System.out.println("================================\n");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
