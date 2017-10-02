package com.recursion;

/**
 * Find all permutations of the given string. Assume that the string is not null and non-empty and has unique characters.
 * @author nirav99
 *
 */
public class PermuteAll
{
  public static void findPermutations(String data)
  {
    char[] input = data.toCharArray();
    boolean[] used = new boolean[input.length];
    char[] result = new char[input.length];
    
    permuteHelper(input, result, used, 0);
  }
  
  private static void permuteHelper(char[] input, char[] result, boolean[] used, int level)
  {
    if(level >= input.length)
    {
      String perm = new String(result);
      System.out.println("  " + perm);
      return;
    }
    else
    {
      for(int i = 0; i < input.length; i++)
      {
        if(used[i] == false)
        {
          result[level] = input[i];
          used[i] = true;
          permuteHelper(input, result, used, level + 1);
          used[i] = false;
        }
      }
    }
  }
  
  public static void main(String[] args)
  {
    try
    {
      String[] inputs = {"a", "ab", "abc", "abcd"};
      
      for(String input : inputs)
      {
        System.out.println("Input : " + input);
        System.out.println("Permutations : ");
        findPermutations(input);
        System.out.println("================================\n");
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}

