package com.sorting;
import java.util.*;

/**
 * Implementation of Quick sort
 * @author nirav99
 *
 */
public class QuickSort
{
  public static void sort(int[] a, int start, int end)
  {
    if(start < end)
    {
      int pivotIndex = partition(a, start, end);
      sort(a, start, pivotIndex - 1);
      sort(a, pivotIndex + 1, end);
    }
  }
  
  private static int partition(int[] a, int start, int end)
  {
    int pivotIndex = getMedianOfThree(a, start, end, (start + end) / 2);
    int pivotValue = a[pivotIndex];
    
    swap(a, pivotIndex, end);
    
    int j = start;
    for(int i = start; i < end; i++)
    {
      if(a[i] <= pivotValue)
      {
        swap(a, i, j);
        j++;
      }
    }
    swap(a, j, end);
    return j;
  }
  
  /**
   * Of the first, middle and the last element, return the index of the element that is the median of the other two.
   * @param a
   * @param low
   * @param mid
   * @param high
   * @return
   */
  private static int getMedianOfThree(int[] a, int low, int mid, int high)
  {
    if((a[low] - a[mid]) * (a[high] - a[low]) >= 0) // low >= mid and low <= high OR low <= mid and low >= high
      return low;
    else if ((a[mid] - a[low]) * (a[high] - a[mid]) >= 0) // mid >= low and mid <= high OR mid <= low and mid >= high
      return mid;
    else
      return high;
  }
  
  private static void swap(int[] a, int i, int j)
  {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  public static void main(String args[])
  {
    int size = 11;
      
    int [] a = new int[size];
    Random rn = new Random();
      
    for(int i = 0; i < size; i++)
    a[i] = rn.nextInt(size * 10);
      
    System.out.println("Original array : ");
    for(int i = 0; i < size; i++)
      System.out.print(a[i] + " ");
    System.out.println("\n");
      
    sort(a, 0, a.length - 1);
      
    System.out.println("Sorted array : ");
    for(int i = 0; i < size; i++)
      System.out.print(a[i] + " ");
    System.out.println("\n");
  }
}
