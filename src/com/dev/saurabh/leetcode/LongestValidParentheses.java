package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/6/12
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestValidParentheses {

    public static void main(String [] args)
    {
        LongestValidParentheses instance = new LongestValidParentheses();
        System.out.println(instance.longestValidParentheses("(()()("));
    }

    private int longestValidParentheses(String s) {

        int bracketParity = 0;
        int length = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketParity++;
            }
            else {
                bracketParity--;
            }
            length++;
            if (bracketParity < 0) {
                bracketParity = 0;
                length = 0;
                continue;
            }
            else if (bracketParity == 0 && length > max) {
                max = length;
            }

        }

        bracketParity = 0;
        length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                bracketParity--;
            }
            else {
                bracketParity++;
            }

            length++;

            if (bracketParity < 0) {
                length = 0;
                bracketParity = 0;
                continue;
            }
            else if (bracketParity == 0 && length > max) {
                max = length;
            }

        }

        return max;
    }
}
