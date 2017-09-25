package com.arrays_strings;

/**
 * Class to represent convert an integer into its string representation in
 * binary format.
 */
public class ConvertIntToBinaryStr
{
  public static String convertInt(int input)
  {
    StringBuilder result = new StringBuilder();

    if(input < 0)
    {
      System.err.println("Does not handle negative numbers right now");
      return null;
    }
    
    do
    {
      if((input & 1) != 0)
        result.append("1");
      else
        result.append("0");
      input = input >> 1;
    }
    while(input > 0);

    result.reverse();

    return result.toString();
  }

  public static void main(String args[])
  {
    int[] numbers = {0, 8, 7, 12, 2, 3, 6, 23};
  	
    for(int number : numbers)
    {
    	System.out.println("Number : " + number + " Binary String : " + convertInt(number));
    }
  }
}
