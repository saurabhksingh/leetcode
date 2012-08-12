package com.dev.saurabh.leetcode;

import java.util.ArrayList;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/12/12
 * Time: 5:11 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class InsertInterval
{
    public static void main(String [] args)
    {
        ArrayList<Interval> input = new ArrayList<Interval>();
        //[1,2],[3,5],[6,7],[8,10],[12,16]
//        input.add(new Interval(1,2));
//        input.add(new Interval(3,5));
//        input.add(new Interval(6,7));
//        input.add(new Interval(8,10));
//        input.add(new Interval(12,16));

        input.add(new Interval(1,4));
        input.add(new Interval(9,12));
        input.add(new Interval(19,22));

        Interval newItem = new Interval(7,13);

        InsertInterval instance = new InsertInterval();
        ArrayList<Interval> result = instance.insert(input,newItem);

        for(Interval interval : result)
        {
            System.out.println(interval.start + " , " + interval.end);
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals == null || intervals.isEmpty())
        {
            result.add(newInterval);
            return result;
        }
        else if(newInterval == null)
        {
            return  intervals;
        }

        int startIndex = 0;
        int endIndex = -1;
        boolean startFound = false;

        if(newInterval.start > intervals.get(intervals.size()-1).end)
        {
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval.start<intervals.get(0).start)
        {
            startIndex = -1;
        }
        else
        {
            startIndex = searchIndexBS(intervals, newInterval.start);
            startFound = startIndex != -1;
        }

        if(newInterval.end > intervals.get(intervals.size()-1).end)
        {
            endIndex = intervals.size();
            if(startIndex == -1)
            {
                intervals.clear();
                intervals.add(newInterval);
                return intervals;
            }
            else
            {
                for(int i=0; i<startIndex; i++)
                {
                    result.add(intervals.get(i));
                }
                if(newInterval.start>=intervals.get(startIndex).start && newInterval.start<=intervals.get(startIndex).end)
                {
                    if(intervals.get(startIndex).start < newInterval.start)
                    {
                        newInterval.start = intervals.get(startIndex).start;
                    }
                }
                else
                {
                    result.add(intervals.get(startIndex));
                }
                result.add(newInterval);

                return result;
            }
        }

        endIndex = searchIndexBS(intervals, newInterval.end);
        if(startIndex == -1)
        {
            if(endIndex >= 0)
            {
                if(intervals.get(endIndex).end > newInterval.end)
                {
                    newInterval.end = intervals.get(endIndex).end;
                }
            }
            result.add(newInterval);
            for(int i=endIndex+1; i<intervals.size(); i++)
            {
                result.add(intervals.get(i));
            }

            return result;
        }
        else
        {
            for(int i=0; i<startIndex; i++)
            {
                result.add(intervals.get(i));
            }
            if(newInterval.start>=intervals.get(startIndex).start && newInterval.start<=intervals.get(startIndex).end)
            {
                if(intervals.get(startIndex).start < newInterval.start)
                {
                    newInterval.start = intervals.get(startIndex).start;
                }
            }
            else
            {
                result.add(intervals.get(startIndex));
            }

            int nextStartGap = 0;

            if(newInterval.end>= intervals.get(endIndex).start)
            {
                if(intervals.get(endIndex).end > newInterval.end)
                {
                    newInterval.end = intervals.get(endIndex).end;
                }
                nextStartGap  = 1;
            }
            else
            {
                if(startIndex == endIndex)
                {
                    nextStartGap = 1;
                }
            }
            result.add(newInterval);

            for(int i=endIndex+nextStartGap; i<intervals.size(); i++)
            {
                result.add(intervals.get(i));
            }
        }

        return result;
    }

    private int searchIndexBS(ArrayList<Interval> intervals, int data) {
        int low = 0;
        int high = intervals.size()-1;
        int index = -1;

        while(low <= high)
        {
            int mid = low+(high-low)/2;
            Interval currentInterval = intervals.get(mid);

            if(data >= currentInterval.start && data <= currentInterval.end)
            {
                return mid;
            }
            else if(data > currentInterval.end)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
            if(low>high)
            {
                index = high;
            }
        }

        return index;
    }
}

class Interval
{
    int start,end;

    Interval()
    {
        start = 0;
        end = 0;
    }

    Interval(int s, int e)
    {
        start = s;
        end = e;
    }

}
