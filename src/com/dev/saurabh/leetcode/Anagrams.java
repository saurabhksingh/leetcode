package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/8/12
 * Time: 12:26 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class Anagrams {

    public static void main(String [] args)
    {
        Anagrams instance = new Anagrams();
        String [] input = new String[]{"abc", "cba", "dcb"};
        ArrayList<String> anagrams = instance.getAnagrams(input);
        for(String str : anagrams)
        {
            System.out.println(str);
        }
    }

    private ArrayList<String> getAnagrams(String [] strs)
    {
        ArrayList <String> result = new ArrayList<String>();

        Map <String, ArrayList<String>> stringAnagramCache = new HashMap<String, ArrayList<String>>();
        for(String input : strs)
        {
            char [] chars = input.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            ArrayList<String> data = null;
            if((data = stringAnagramCache.get(sortedStr)) != null)
            {
               data.add(input);
            }
            else
            {
               ArrayList <String> strList = new ArrayList<String>();
               strList.add(input);
               stringAnagramCache.put(sortedStr, strList);
            }
        }

        for(ArrayList<String> strList :  stringAnagramCache.values())
        {
            if(strList != null && strList.size() > 1)
            {
                result.addAll(strList);
            }
        }

        return result;
    }
}
