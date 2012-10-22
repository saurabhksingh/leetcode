package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidNumber {

    public static void main(String [] args)
    {
        ValidNumber instance = new ValidNumber();
        instance.runTest();
    }

    private void runTest() {
        System.out.println(isNumber("511e381307"));
    }

    public boolean isNumber(String s) {

        boolean result = false;
        int dotCount = 0;
        int eCount = 0;
        int dashCount = 0;
        int plusCount = 0;
        boolean immediateDigitAfterE = false;
        boolean digitAfterE = false;
        boolean anyDigit = false;

        if(s == null)
        {
            return false;
        }
        s = s.trim();
        if((s.length() == 0))
        {
            return false;
        }
        int start = 0;
        if(s.charAt(0) == '-')
        {
            start++;
        }
        else if(s.charAt(start) == '+')
        {
            start++;
            if(start > 1)
            {
                return false;
            }
        }
        if(start<s.length() && (!(s.charAt(start)>= '0' && s.charAt(start)<= '9') && s.charAt(start)!='.') )
        {
            return false;
        }
        for(int i=start; i<s.length(); i++)
        {
           if(s.charAt(i) == 'e')
           {
               eCount++;
               if(eCount > 1 || (!anyDigit && dotCount>0))
               {
                   result = false;
                   break;
               }
               if(i<s.length()-1)
               {
                   immediateDigitAfterE = s.charAt(i+1)>='0' && s.charAt(i+1)<='9';
               }
           }
           else if(s.charAt(i) == '.')
           {
               dotCount++;
               if(dotCount > 1 || eCount > 0)
               {
                   result = false;
                   break;
               }
           }
           else if(s.charAt(i) == '-')
           {
               dashCount++;
               if(dashCount > 1 || eCount == 0 || plusCount>0 || immediateDigitAfterE)
               {
                   result = false;
                   break;
               }
           }
           else if(s.charAt(i) == '+')
           {
               plusCount++;
               if(plusCount > 1 || eCount == 0 || immediateDigitAfterE || dashCount > 0)
               {
                   result = false;
                   break;
               }
           }
           else
           {
               if(s.charAt(i) >= '0'   && s.charAt(i)<='9')
               {
                   anyDigit = true;
                   if(eCount > 0)
                   {
                       digitAfterE = true;
                   }
                   result = true;
               }
               else
               {
                   result = false;
                   break;
               }
           }
        }

        if(eCount > 0 && (!digitAfterE || (s.charAt(s.length()-1) < '0' || s.charAt(s.length()-1) > '9')))
        {
            result = false;
        }

        return result;
    }
}
