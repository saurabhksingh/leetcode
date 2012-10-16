package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/6/12
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static void main(String [] args)
    {
        LongestSubstringWithoutRepeatingChars instance = new LongestSubstringWithoutRepeatingChars();
        System.out.println(instance.lengthOfLongestSubstring("abccbaabccba"));
    }

    private String lengthOfLongestSubstring(String s) {
        int [] charIndex = new int[26];

        char [] in = s.toCharArray();

        int currentMaxLength = 0;
        int currentLength = 0;
        int runningStartIndex = 0;
        int startIndex = 0;
        for(int i=0; i<in.length; i++)
        {
            char ch = in[i];
            int nextStartIndex = 0;
            if( charIndex[ch-'a'] != 0)
            {
                nextStartIndex =  charIndex[ch-'a'];
                if(nextStartIndex > runningStartIndex)
                {
                    int diff = nextStartIndex-runningStartIndex;
                    charIndex[ch - 'a'] = i+1;
                    runningStartIndex = nextStartIndex;
                    currentLength = currentLength-diff+1;
                }
                else
                {
                    charIndex[ch - 'a'] = i+1;
                    currentLength++;
                }
            }
            else
            {
                charIndex[ch-'a'] = i+1;
                currentLength++;
            }

            if(currentLength > currentMaxLength)
            {
                currentMaxLength = currentLength;
                startIndex =  runningStartIndex;
            }
        }

        return  s.substring(startIndex, currentMaxLength+startIndex);
    }
}
