package com.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array, find the Kth largest element in that array using QuickSelect - a variation of QuickSort
 * @author nirav99
 *
 */
public class KthLargestElement
{
  static int getKthLargestElement(int a[], int start, int end, int k)
  {
    if(start <= end)
    {
      int pivotPos = partition(a, start, end);

      System.out.println("Pivot Index = " + pivotPos +  " Pivot Value = " + a[pivotPos] + " Start = " + start + " End = " + end + " K = " + k);

      if(pivotPos == k)
      {
        return a[pivotPos];
      }
      else
      if(pivotPos < k)
      {
        return getKthLargestElement(a, pivotPos + 1, end , k);
      }
      else
        return getKthLargestElement(a, start, pivotPos - 1, k);
    }
    return -1;
  }

  private static int partition(int[] a, int start, int end)
  {
    int pivotIndex = start + (end - start) / 2;
    int pivotValue = a[pivotIndex];
    
    swap(a, pivotIndex, end);
    
    int writePos = start;
    for(int i = start; i < end; i++)
    {
      if(a[i] > pivotValue)
      {
        swap(a, i, writePos);
        writePos++;
      }
    }
    swap(a, writePos, end);
    return writePos;
  }
  
  private static void swap(int[] a, int i, int j)
  {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  public static void main(String args[])
  {
    int size = 8;
      
    int [] a = new int[size];
    Random rn = new Random();
      
    for(int i = 0; i < size; i++)
      a[i] = rn.nextInt(size * 10);
    
    int[] sortedArray = a.clone();
    Arrays.sort(sortedArray);
    
    System.out.println("Original array : ");
    for(int i = 0; i < size; i++)
      System.out.print(a[i] + " ");
    System.out.println("\n");
    
    int k = rn.nextInt(size) + 1;
    StringBuilder kthLargestText = new StringBuilder();
    kthLargestText.append(k);
    
    if(k == 1)
      kthLargestText.append("st");
    else
    if(k == 2)
      kthLargestText.append("nd");
    else
      kthLargestText.append("th");
    
    int value = getKthLargestElement(a, 0, a.length - 1, k - 1);
    
    if(value == -1)
      System.out.println(kthLargestText.toString() + " largest element absent");
    else
      System.out.println(kthLargestText.toString() + " largest element : " + value);

    System.out.println("\n");
    
    System.out.println("The original array sorted for convenient spot checking :");
    for(int i = 0; i < size; i++)
      System.out.print(sortedArray[i] + " ");
    System.out.println("\n");
  }
}
