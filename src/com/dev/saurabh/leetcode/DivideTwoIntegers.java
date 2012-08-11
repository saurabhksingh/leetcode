package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 5:34 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class DivideTwoIntegers {
    public static void main(String [] args)
    {
        DivideTwoIntegers instance = new DivideTwoIntegers();
        System.out.println(instance.divide(100, 91));
    }

    public int divide (int dividend, int divisor)
    {
        int tempDivisor = divisor;
        int sign = 1;

        int result = 1;

        if(dividend  < 0)
        {
            dividend = -1 * dividend;
            sign = -sign;
        }
        if(divisor < 0)
        {
            divisor = divisor* -1;
            sign = -sign;
        }

        if(divisor == 0 || dividend == 0)
        {
            return 0;
        }
        if(divisor == dividend)
        {
            return sign;
        }
        if(divisor == 1)
        {
            return  sign*dividend;
        }
        if(divisor == 2)
        {
            return dividend>>1;
        }
        if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
        {
            return 0;
        }
        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
        result = (int) Math.floor(Math.pow(Math.E, Math.log(dividend) - Math.log(divisor)));
        if(true)
        {
            return sign*result;
        }
        if(divisor < dividend)
        {
            while((tempDivisor+divisor) <= dividend)
            {
                tempDivisor += divisor;
                result = result+1;
            }
        }
        else
        {
            return 0;
        }

        return result*sign;
    }
}
