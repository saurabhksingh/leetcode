package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOne {

    public static void main(String [] args)
    {
        PlusOne instance = new PlusOne();
        int [] result = instance.plusOne(new int[]{9,9,9});
        for(int digit: result)
        {
            System.out.print(digit);
        }
    }

    public int[] plusOne(int[] digits) {

        int carry = 1;
        if(digits == null || digits.length == 0)
        {
            return digits;
        }
        for(int i=digits.length-1; i>=0; i--)
        {
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0)
            {
                break;
            }
        }
        int [] result = null;
        if(carry > 0)
        {
            result = new int[digits.length+1];
            result[0] = carry;
            for(int i=1; i<=digits.length; i++)
            {
                result[i] = digits[i-1];
            }
        }
        else
        {
            result = digits;
        }

        return result;
    }
}
