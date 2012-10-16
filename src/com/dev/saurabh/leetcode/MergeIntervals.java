package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeIntervals {

    private void runTest() {
        ArrayList<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1,3));
        input.add(new Interval(2,6));
        input.add(new Interval(8,10));
        input.add(new Interval(15,18));
        ArrayList<Interval> out = merge(input);
        for(Interval interval: out)
        {
            System.out.println("["+interval.start+","+interval.end+"]");
        }
    }

     public class Interval implements Comparable<Interval>{
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }

         @Override
         public int compareTo(Interval interval) {
             return this.start-interval.start;
         }
     }

    public static void main(String [] args)
    {
        MergeIntervals instance = new MergeIntervals();
        instance.runTest();
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        if(intervals == null || intervals.size()==0)
        {
            return intervals;
        }
        ArrayList<Interval> out = new ArrayList<Interval>();

        Collections.sort(intervals);

        out.add(intervals.get(0));
        Interval previousInterval = intervals.get(0);
        for(int i=1; i<intervals.size(); i++)
        {
            Interval currentInterval = intervals.get(i);
            if(currentInterval.start>=previousInterval.start && currentInterval.start<=previousInterval.end)
            {
               int end = Math.max(currentInterval.end, previousInterval.end);
               previousInterval.end = end;
            }
            else
            {
                out.add(currentInterval);
                previousInterval = currentInterval;
            }
        }

        return out;
    }
}
