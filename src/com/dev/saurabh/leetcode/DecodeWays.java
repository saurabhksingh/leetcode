package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 3:47 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class DecodeWays {


    public static void main(String [] args)
    {
       DecodeWays instance = new DecodeWays();
       System.out.println(instance.numDecodings("1010"));

    }
    private static  int constant = 0;
    private static boolean isInit = false;
    public int numDecodings(String s)
    {
        //a->1, b->2, c->3......z->26.
        //This means that at a time a single digit or two digits can be picked for lookup.
        //Also the while picking two digit number we need to see that it does not exceed 26.
        //So if current char>'2' || currentChar=='2'&&nextChar>'6'
        //              then the total possibilities will be 1+numDecodings(s(1,n))

        char [] charArray = s.toCharArray();
        if(charArray !=null && charArray.length>0)
        {
            if(charArray[0] == '0')
            {
                return 0;
            }

        }
        constant = charArray.length * charArray.length;

        int result = totalPossibleDecodings(charArray, 0, false);
        return result<0? 0 : result;

    }

    private int totalPossibleDecodings(char [] charArray, int startIndex, boolean prevOneWay)
    {
        if(charArray == null)
        {
            return 0;
        }
        if(startIndex >= charArray.length)
        {
            return 0;
        }
        char currentChar = charArray[startIndex];
        if(charArray.length == 2)
        {
            if(currentChar == '0')
            {
                return 0;
            }
            else if(charArray[1] == '0')
            {
                return 1;
            }
            else if((currentChar == '2' && charArray[1] > '6') || currentChar > '2')
            {
                return 1;
            }
            return 2;
        }


        if(currentChar == '0')
        {
            return -1*constant;
        }

        if(startIndex == charArray.length-1)
        {
            return prevOneWay?0:1;
        }
        if(currentChar == '2')
        {
            if(charArray[startIndex+1]>'6')
            {
                if(prevOneWay)
                {
                    return totalPossibleDecodings(charArray, startIndex+1, true);
                }
                else
                {
                    return 1 + totalPossibleDecodings(charArray, startIndex+1, true);
                }
            }
            else
            {
                boolean isOneWay = false;
                if(charArray[startIndex+1] == '0')
                {
                    startIndex++;
                    isOneWay = true;

                }
                if(prevOneWay)
                {
                    return totalPossibleDecodings(charArray, startIndex+1, isOneWay);
                }
                else
                {
                    if(isOneWay && isInit)
                    {
                        return totalPossibleDecodings(charArray, startIndex+1, isOneWay);
                    }
                    else
                    {
                        isInit = true;
                        return 1 + totalPossibleDecodings(charArray, startIndex+1, isOneWay);
                    }
                }
            }
        }
        if(currentChar == '1')
        {
            boolean isOneWay = false;
            if(charArray[startIndex+1] == '0')
            {
                startIndex++;
                isOneWay = true;
            }
            if(prevOneWay)
            {
                return totalPossibleDecodings(charArray, startIndex+1, isOneWay);
            }
            else
            {
                if(isOneWay && isInit)
                {
                    return totalPossibleDecodings(charArray, startIndex+1, isOneWay);
                }
                else
                {
                    isInit = true;
                    return 1+totalPossibleDecodings(charArray, startIndex+1, isOneWay);
                }
            }
        }
        else if(currentChar > '2')
        {
            if(charArray[startIndex+1] == '0')
            {
                return  -1*(constant);
            }
            if(prevOneWay)
            {
                return totalPossibleDecodings(charArray, startIndex+1, true);
            }
            else
            {
                return 1+totalPossibleDecodings(charArray, startIndex+1, true);
            }
        }
        else
        {
            return 0;
        }
    }
}
