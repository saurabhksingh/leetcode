package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/8/12
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class MinimumWindowSubstring {

    public static void main(String [] args)
    {
        String S = "abc";
        String T = "ac";

        MinimumWindowSubstring instance = new MinimumWindowSubstring();
        System.out.println(instance.minWindow(S,T));
    }

    public String minWindow(String S, String T) {
        if(S== null || T == null || S.length()==0 || T.length()==0 || T.length() > S.length())
        {
            return "";
        }

        int [] targetAlphabetsIndex = new int[256];
        int [] hasFound = new int [256];
        for(int i=0; i<T.length(); i++)
        {
            targetAlphabetsIndex[T.charAt(i)]++;
        }

        int length = S.length();
        int start= 0, end=0, count=0, finalStart = 0, finalEnd = 0;
        int minLength = S.length()+1;
        for(; end<length; end++)
        {
            if(targetAlphabetsIndex[S.charAt(end)] > 0)
            {
                hasFound[S.charAt(end)]++;
                if(hasFound[S.charAt(end)] <=targetAlphabetsIndex[S.charAt(end)])
                {
                    count++;
                }

                if (count == T.length()) {

                    while (targetAlphabetsIndex[S.charAt(start)] == 0 || hasFound[S.charAt(start)] > targetAlphabetsIndex[S.charAt(start)]) {
                        if (hasFound[S.charAt(start)] > targetAlphabetsIndex[S.charAt(start)])
                            hasFound[S.charAt(start)]--;

                        start++;
                    }


                    int windowLen = end - start + 1;
                    if (windowLen < minLength) {
                        finalStart = start;
                        finalEnd = end;
                        minLength = windowLen;
                    }
                }
            }
        }

        if(count < T.length())
        {
            return "";
        }


        return S.substring(finalStart, finalEnd+1);
    }
}
