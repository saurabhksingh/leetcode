package com.dev.saurabh.leetcode;

import java.util.ArrayList;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/12/12
 * Time: 12:21 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class GrayCode {

    public static void main(String [] args)
    {
        GrayCode instance = new GrayCode();
        ArrayList<Integer> result = instance.grayCode(3);

        for(int data :  result)
        {
            System.out.println(data);
        }
    }

    public ArrayList <Integer> grayCode(int n)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int count = 0;
        //int currentNum = 0;
        //result.add(0);
        int numberOfIteration = 1<<n;
        while(count < numberOfIteration)
        {
            char [] binaryFormat = Integer.toBinaryString(count).toCharArray();
            //binary to graycode
            int grayCode = 0;
            for(int i=binaryFormat.length-1; i>0; i--)
            {
               if(binaryFormat[i-1] == '1')
               {
                   binaryFormat[i] = (binaryFormat[i] == '0')?'1':'0';
               }
               if(binaryFormat[i] == '1')
               {
                   grayCode += 1<<(binaryFormat.length-1-i);
               }
            }
            if(binaryFormat[0] == '1')
            {
                grayCode += 1<<(binaryFormat.length-1);
            }
            result.add(grayCode);
            count++;
        }
        return result;
    }
}
