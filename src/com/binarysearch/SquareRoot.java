package com.binarysearch;
/**
 * Method to calculate square root for a real number greater than or equal to 1.
 * The square root must be within the specfied tolerance value.
 * @author nirav99
 *
 */
public class SquareRoot
{
  public static double squareRoot(double input, double tolerance)
  {
    double low = 0;
    double high = input;
    double mid;
    double square;
    
    while(low < high)
    {
      mid = (low + high) / 2;
      square = mid * mid;
      
  //    System.out.format("  Low : %.3f High : %.3f Mid : %.3f\n", low, high, mid);
      
      if(square >= input - tolerance && square <= input + tolerance)
        return mid;
      else
      if(square > input)
      {
        high = mid;
      }
      else
      {
        low = mid;
      }
    }
    return -1;
  }
  
  public static void main(String[] args)
  {
    try
    {
      double[] input = {2, 3, 4, 5, 6, 10, 100, 5.6};
      double tolerance = 0.001;
      
      for(double num : input)
      {
        System.out.format("Num : %.2f, Square Root : %.3f\n", num, squareRoot(num, tolerance));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}
