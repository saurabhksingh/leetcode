package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 8/20/12
 * Time: 8:06 PM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */
public class LengthOfLastWord {

    public static void main(String [] args)
    {
        LengthOfLastWord instance = new LengthOfLastWord();
        System.out.println(instance.lengthOfLastWord("  day"));
    }

    private int lengthOfLastWord(String sentence) {
        int result = 0;
        int indexOfWordBreak = -1;
        boolean anyCharEncountered = false;
        int wordEnd = -1;
        for(int i=sentence.length()-1; i>=0; i--)
        {
            if(sentence.charAt(i)!= ' ')
            {
                wordEnd = i;
                break;
            }
        }
        for(int i=wordEnd; i>=0; i--)
        {
            if(sentence.charAt(i) == ' ')
            {
                indexOfWordBreak = i;
                break;
            }
            else
            {
                anyCharEncountered = true;
            }
        }
        if(indexOfWordBreak != -1)
        {
            result = wordEnd-indexOfWordBreak;
        }
        else if(anyCharEncountered)
        {
            result = wordEnd+1;
        }
        else
        {
            result = 0;
        }

        return result;
    }
}
