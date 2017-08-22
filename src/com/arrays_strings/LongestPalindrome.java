package com.arrays_strings;

/**
 * Find the longest palindrome in the given string. If the string does not have a palindrome, 
 * return the first letter.
 * Examples:
 * Input : abared, Longest palindrome : aba
 * Input : racecar, Longest palindrome : racecar
 * Input : phd, Longest palindrome : p
 * Input : abba, Longest palindrome : abba
 * Input : abbd, Longest palindrome : bb
 * Input : aabd, Longest palindrome : aa
 * Input : abbcccddddeeeee, Longest palindrome : eeeee
 * @author nirav99
 *
 */
public class LongestPalindrome
{
  private String longestPalindrome;
  private String input;
  
  public LongestPalindrome(String input)
  {
    this.input = input;
    this.longestPalindrome = "";
  }
  
  public String longestPalindrome()
  {
    for(int i = 0; i < input.length(); i++)
    {
      // Generate substrings of length 1 and grow it to find palindromes
      palindromeHelper(input.substring(i, i + 1), i - 1, i+ 1);
      
      // Generate a substring of length 2 and grow it to find palindromes
      if(i < input.length() - 1)
        palindromeHelper(input.substring(i, i+ 2), i - 1, i + 2);
      
    }
    
    return this.longestPalindrome;
  }
  
  private void palindromeHelper(String currentContent, int prev, int next)
  {
    boolean found = false;
    
    if(longestPalindrome.isEmpty() && currentContent.length() == 1)
      this.longestPalindrome = currentContent;
    else
    if(longestPalindrome.length() == 1 && currentContent.length() == 2 && (currentContent.charAt(0) == currentContent.charAt(1)))
        this.longestPalindrome = currentContent;

    for(; prev >= 0 && next < input.length(); prev--, next++)
    {
      if(input.charAt(prev) == input.charAt(next))
        found = true;
      else
        break;
    }
    
    if(found == true)
    {
      String newPalindrome = input.substring(prev + 1, next);
      
      if(newPalindrome.length() > longestPalindrome.length())
        longestPalindrome = newPalindrome;
    }
  }
  
  public static void main(String[] args)
  {
    try
    {
      String[] inputArray = {"abared", "racecar", "phd", "abba", "abbd", "aabd", "abbcccddddeeeee"};
      
      for(String input : inputArray)
      {
        LongestPalindrome lp = new LongestPalindrome(input);
        System.out.println("Input : " + input + ", Longest palindrome : " + lp.longestPalindrome());
      }
    }
    catch(Exception e)
    {
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
