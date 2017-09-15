package com.arrays_strings;

import java.util.*;

/**
 * You are given a list of Interval objects, where each interval has a start time and end time. e.g. (1,3).
 * In the given list, all the interval objects are sorted by start time but not by end time.
 * Find the intervals that are not overlapping.
 * e.g. (1,3) (2,4) (7,9), (7, 9) is the non-overlapping interval
 * 
 * Do this in O(n) time.
 * @author nirav99
 *
 */
public class FindNonOverlappingIntervals
{
	public static ArrayList<Interval> getNonOverlappingIntervals(ArrayList<Interval> data)
	{
    ArrayList<Interval> nonOverlap = new ArrayList<Interval>();
    HashSet<Interval> overlapSet = new HashSet<Interval>();
   
    Interval maxEndInterval = data.get(0);
    
    for(int i = 0; i < data.size() - 1 ; i++)
    {
    	Interval curr = data.get(i);
    	Interval next = data.get(i + 1);
    	
    	if(curr.end > next.start)
    	{
    		overlapSet.add(curr);
    		overlapSet.add(next);
    	}
    	if(maxEndInterval.end > next.start)
    	{
    		overlapSet.add(maxEndInterval);
    		overlapSet.add(next);
    	}
    	if(maxEndInterval.end < curr.end)
        maxEndInterval = curr;
    }
    
    for(Interval interval : data)
    {
    	if(!overlapSet.contains(interval))
    		nonOverlap.add(interval);
    }
    
    return (nonOverlap.size() >= 1) ? nonOverlap : null;
	}
	
  public static void main(String[] args)
  {
  	try
  	{
  		int total = 5;
  		ArrayList<Interval> intervalList = generateRandomData(total);
  		System.out.println("Original data : ");
  		printData(intervalList);
  		
  		System.out.println("Non-overlap intervals : ");
  		ArrayList<Interval> nonOverlapIntervals = getNonOverlappingIntervals(intervalList);
  		
  		if(nonOverlapIntervals == null)
  			System.out.println("NULL SET");
  		else
  		  printData(nonOverlapIntervals);
  	}
  	catch(Exception e)
  	{
  		System.err.println(e.getMessage());
  		e.printStackTrace();
  	}
  }
  
  /**
   * Generates random datas
   * @param total
   * @return
   */
  private static ArrayList<Interval> generateRandomData(int total)
  {
  	ArrayList<Interval> data = new ArrayList<Interval>(total);
  	Random random = new Random();
  	
  	for(int i = 0; i < total; i++)
  	{
  		int start = random.nextInt(100);
  		int duration = random.nextInt(20);
  		
  		if(duration == 0) duration = 1;
  		
  		data.add(new Interval(start, start + duration));
  	}
  	
  	Collections.sort(data);
  	
  	return data;
  }
  
  private static void printData(ArrayList<Interval> data)
  {
  	for(Interval d : data)
  		System.out.print(d + " ");
  }
}

/**
 * Interval class
 * @author nirav99
 *
 */
class Interval implements Comparable<Interval>
{
	int start;
	int end;
	
	Interval(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString()
	{
		return "(" + start + "," + end + ")";
	}

	@Override
	public int compareTo(Interval o)
	{
    return this.start - o.start;
	}
}