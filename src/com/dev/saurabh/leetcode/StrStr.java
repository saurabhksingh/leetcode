package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/12/12
 * Time: 4:51 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class StrStr {

    public static void main(String [] args)
    {
        StrStr instance = new StrStr();
        System.out.println(instance.strStr("sdfddsdsfsdaf","ddsds"));
    }

    public String strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return haystack;
        if(haystack.length() < needle.length())
            return null;
        int diff = haystack.length() - needle.length() + 1;
        int needleLength = needle.length();
        for(int i = 0; i < diff;)
        {
            boolean match = true;
            char mismatchChar = ' ';
            int mismatchPos = 0;
            for(int j=needleLength-1; j>=0; j--)
            {
                if(haystack.charAt(i+j) != needle.charAt(j))
                {
                    match = false;
                    mismatchChar = haystack.charAt(i+j);
                    mismatchPos = i+j;
                    break;
                }

            }
            if(!match)
            {
                if(!needleContains(needle,mismatchChar))
                {
                    i = mismatchPos+1;
                }
                else
                {
                    i++;
                }
            }
            else
            {
                return haystack.substring(i);
            }

        }
        return null;
    }

    private boolean needleContains(String needle, char mismatchChar) {
        boolean result = false;
        for(int i=needle.length()-1; i>=0; i--)
        {
            if(needle.charAt(i) == mismatchChar)
            {
                return true;
            }
        }
        return result;
    }
}
