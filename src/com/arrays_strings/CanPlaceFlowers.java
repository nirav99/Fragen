package com.arrays_strings;

/*
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), 
 and a number n, return true / false if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 Example 1:
 Input: flowerbed = [1,0,0,0,1], n = 1
 Output: True
 Example 2:
 Input: flowerbed = [1,0,0,0,1], n = 2
 Output: False
 Note:
 The input array won't violate no-adjacent-flowers rule.
 The input array size is in the range of [1, 20000].
 n is a non-negative integer which won't exceed the input array size.
 */
public class CanPlaceFlowers
{
  public boolean canPlaceFlower(int[] a, int numFlowers)
  {
    int n = 0;
    int[] input = a.clone();
    
    for(int i = 0; i < input.length; i++)
    {
      if(canPlaceFlowerAtGivenPosition(input, i))
      {
        input[i] = 1;
        n++;
        
        if(n >= numFlowers)
          return true;
      }
    }
    return false;
  }
  
  private boolean canPlaceFlowerAtGivenPosition(int[] input, int i)
  {
    if(input[i] == 1)
      return false;
    
    if(i > 0 && input[i - 1] == 1)
      return false;
    
    if(i < input.length - 1 && input[i + 1] == 1)
      return false;
    
    return true;
  }
  
  public static void main(String[] args)
  {
    int[] input = {0, 0, 0, 0, 1};
    
    System.out.println(new CanPlaceFlowers().canPlaceFlower(input, 1));
    System.out.println(new CanPlaceFlowers().canPlaceFlower(input, 2));
  }
}
