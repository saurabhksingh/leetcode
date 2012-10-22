package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseInteger {

    public static void main(String [] args)
    {
        ReverseInteger instance = new ReverseInteger();
        instance.runTest();
    }

    private void runTest() {

        System.out.println(reverse(-1436));
    }

    public int reverse(int x) {

        int sign = x<0?-1:1;
        String num = Integer.toString(x*sign);
        char [] number = num.toCharArray();
        int iterateUpTo = number.length;
        iterateUpTo = iterateUpTo>>1;
        for(int i=0; i<iterateUpTo; i++)
        {
            char temp = number[i];
            number[i] = number[number.length-i-1];
            number[number.length-i-1] = temp;
        }
        num = new String(number);
        x = sign * (Integer.valueOf(num));

        return x;
    }
}
