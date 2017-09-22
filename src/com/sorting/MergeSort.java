package com.sorting;

import java.util.*;

/**
 * Implementation of MergeSort
 * @author nirav99
 *
 */
public class MergeSort
{
  public static void sort(int[] a, int start, int end)
  {
    if(start < end)
    {
      int mid = start + (end - start) / 2;
      sort(a, start, mid);
      sort(a, mid + 1, end);
      merge(a, start, mid, end);
    }
  }
  
  private static void merge(int[] a, int start, int mid, int end)
  {
    int[] result = new int[end - start + 1];
    
    int start1 = start;
    int end1 = mid;
    int start2 = mid + 1;
    int end2 = end;
    
    int writePos = 0;
    
    while(start1 <= end1 && start2 <= end2)
    {
      if(a[start1] < a[start2])
        result[writePos++] = a[start1++];
      else
        result[writePos++] = a[start2++];
    }  
    
    while(start1 <= end1)
      result[writePos++] = a[start1++];
      
    while(start2 <= end2)
      result[writePos++] = a[start2++];
      
    for(int i = 0; i < result.length; i++)
      a[start + i] = result[i];

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
