package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/11/12
 * Time: 3:32 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class CountAndSay {

    public static void main(String [] args)
    {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(4));
    }
    public String countAndSay(int n)
    {
        String result = "1";

        for(int i=n; i>1; i--)
        {
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<result.length();)
            {
              int count = 0;
              int currentChar = result.charAt(j);

              while(j<result.length() &&(result.charAt(j) == currentChar))
              {
                  j++;
                  count++;
              }

              temp.append(count).append((char)(currentChar));

            }

            result = temp.toString();
        }

        return result;
    }
}
