package com.dev.saurabh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/20/12
 * Time: 9:08 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class LetterCombinationsOfPhoneNumbers {

    private static Map <Integer, String []> digitStringOpts = new HashMap<Integer, String[]>();
    static
    {
        digitStringOpts.put(2, new String[]{"a","b","c"});
        digitStringOpts.put(3, new String[]{"d","e","f"});
        digitStringOpts.put(4, new String[]{"g","h","i"});
        digitStringOpts.put(5, new String[]{"j","k","l"});
        digitStringOpts.put(6, new String[]{"m","n","o"});
        digitStringOpts.put(7, new String[]{"p","q","r","s"});
        digitStringOpts.put(8, new String[]{"t","u","v"});
        digitStringOpts.put(9, new String[]{"w","x","y","z"});
    }
    public static void main(String [] args)
    {
        LetterCombinationsOfPhoneNumbers instance = new LetterCombinationsOfPhoneNumbers();
        ArrayList <String> result = instance.letterCombinations("23");
        for(String str: result)
        {
            System.out.println(str);
        }
    }

    private ArrayList<String> letterCombinations(String digits)
    {
        ArrayList <String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
        {
             result.add("");
        }
        else
        {
            String [] letters = digitStringOpts.get(digits.charAt(0)-'0');
            for(String letter: letters)
            {
                result.add(letter);
            }
            addLetterCombinations(result, digits, 1, digits.length()-1);
        }

        return result;
    }

    private void addLetterCombinations(ArrayList<String> result, String digits, int start, int end) {
          while(start <= end)
          {
              for(int i=result.size()-1; i>=0; i--)
              {
                  String currentStr = result.get(i);
                  String [] letters = digitStringOpts.get(digits.charAt(start)-'0');
                  if(letters != null)
                  {
                      result.remove(i);
                  }
                  for(String letter: letters)
                  {
                      result.add(i,currentStr+letter);
                  }
              }

              start++;
          }
    }
}
