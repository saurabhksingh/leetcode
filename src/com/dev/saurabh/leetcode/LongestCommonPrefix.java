package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/20/12
 * Time: 10:14 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class LongestCommonPrefix {

    public static void main(String [] args)
    {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(new String[]{"abab","aba","abc"}));
    }

    private String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder("");
        int count = 0;
        int [] alphabets = new int[26];
        if(strs != null && strs.length > 0)
        {
            int minLengthString = Integer.MAX_VALUE;

            for(String input : strs)
            {
                if(input != null && !"".equals(input))
                {
                    if(input.length() < minLengthString)
                    {
                        minLengthString = input.length();
                    }
                }
                else
                {
                    return "";
                }
            }
            int charMatch = 0;
            for(int i=0; i<minLengthString; i++)
            {
               int currentChar = strs[0].charAt(i);
               for(String input : strs)
               {
                   alphabets[input.charAt(i)-'a']++;
               }
               if(alphabets[currentChar-'a'] == strs.length)
               {
                   result.append((char)currentChar);
                   alphabets[currentChar-'a'] = 0;
               }
               else
               {
                   break;
               }
            }
        }

        return result.toString();
    }
}
