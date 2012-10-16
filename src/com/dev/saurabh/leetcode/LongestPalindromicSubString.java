package com.dev.saurabh.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/5/12
 * Time: 6:52 PM
 */
public class LongestPalindromicSubString {

    //we will use Manacher's Algorithm to achieve the goal

    public static void main(String [] args) throws Exception
    {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(consoleReader.readLine());
        String s = consoleReader.readLine();
        LongestPalindromicSubString instance = new LongestPalindromicSubString();
        System.out.println(instance.longestPalindrome(s).length());
    }

    public String longestPalindrome(String s)
    {
       char [] expandedString = new char[s.length()*2 + 3];
        expandedString[0] = '$';
        expandedString[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            expandedString[2*i + 1] = '#';
            expandedString[2*i + 2] = s.charAt(i);
        }
        expandedString[s.length()*2 + 1] = '#';



        int [] p = new int[expandedString.length];
        int center = 0, right = 0;
        int length = 0, finalCenter = 0;
        for (int i = 1; i < expandedString.length-1; i++) {

            int mirror = 2*center - i;

            if (right > i) p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            while (expandedString[i + (1 + p[i])] == expandedString[i - (1 + p[i])])
                p[i]++;

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > length) {
                length = p[i];
                finalCenter = i;
            }
        }


        return s.substring((finalCenter - 1 - length) / 2, (finalCenter - 1 + length) / 2);
    }
}
