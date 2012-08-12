package com.dev.saurabh.leetcode;

import java.util.HashMap;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/12/12
 * Time: 7:17 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class IntegerToRoman {

    public static void main(String [] args)
    {
        IntegerToRoman instance = new IntegerToRoman();
        System.out.println(instance.intToRoman(11));
    }

    public String intToRoman(int num)
    {
        StringBuilder result = new StringBuilder();
        int temp = 0;

        if(num >= 1000)
        {
            temp = num/1000;
            while(temp-- > 0)
            {
                result.append("M");
            }

            num = num%1000;
        }
        if(num >= 100)
        {
           if(num >= 900)
           {
               result.append("CM");
               num = num % 100;
           }
           else
           {
               if(num >= 500)
               {
                   result.append("D");
                   num = num-500;
                   if(num > 0)
                   {
                       temp = num/100;
                       while(temp-- > 0)
                       {
                           result.append("C");
                       }
                       num = num%100;
                   }
               }
               else if(num >= 400)
               {
                 result.append("CD");
                 num = num-400;
               }
               else
               {
                   temp = num/100;
                   while(temp-- > 0)
                   {
                       result.append("C");
                   }
                   num = num%100;
               }
           }
        }
        if(num >= 10)
        {
            if(num == 10)
            {
                result.append("X");
                num = num%10;
            }
            else
            {
                if(num == 50)
                {
                    result.append("L");
                    num = num% 10;
                }
                else if(num >= 40 && num<90)
                {
                    if(num<50)
                    {
                        result.append("XL");
                        num = num%10;
                    }
                    else
                    {
                        result.append("L");
                        num = num-50;
                        temp = num/10;
                        while(temp-- > 0)
                        {
                            result.append("X");
                        }
                        num = num%10;
                    }
                }
                else if(num>=90 && num<100)
                {
                    result.append("XC");
                    num = num%10;
                }
                else if(num<40 && num >0)
                {
                    temp = num/10;
                    while(temp-- > 0)
                    {
                        result.append("X");
                    }
                    num = num%10;
                }
            }
        }
        if(num>0 && num<10)
        {
           if(num == 9)
           {
               result.append("IX");
           }
           else
           {
               if(num >= 5)
               {
                   result.append("V");
                   temp = num-5;
                   while(temp-- > 0)
                   {
                       result.append("I");
                   }
               }
               else
               {
                   if(num == 4)
                   {
                       result.append("IV");
                   }
                   else
                   {
                       while(num-- > 0)
                       {
                           result.append("I");
                       }
                   }
               }
           }
        }
        return result.toString();
    }
}
