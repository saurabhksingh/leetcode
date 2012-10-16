package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/8/12
 * Time: 2:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStrings {

    public static void main(String [] args)
    {
        MultiplyStrings instance = new MultiplyStrings();
        System.out.println(instance.multiply("61480723987857250303867015585644902996295272","17149437458129895288707346085"));
    }

    public String multiply(String num1, String num2) {

        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
        {
            return "";
        }

        if(num1.length()+num2.length() <= 8)
        {
            return Integer.toString(Integer.parseInt(num1)*Integer.parseInt(num2));
        }

        int l1 = num1.length(); int l2 = num2.length();

        String a = num1.substring(0, l1>>1); String b = num1.substring(l1>>1);
        String c = num2.substring(0, l2>>1); String d = num2.substring(l2>>1);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int limit = l1-(l1>>1);
        for(int i=0; i<limit; i++)
        {
            sb1.append("0");
        }
        limit = l2-(l2>>1);
        for(int i=0; i<limit; i++)
        {
            sb2.append("0");
        }
        String ac = multiply(a,c)+sb1.toString()+sb2.toString();
        String ad = multiply(a,d)+sb1.toString();
        String bc = multiply(b,c)+sb2.toString();
        String bd = multiply(b,d);

        String result = add(ac,ad);
        result = add(result, bc);
        result = add(result, bd);

        return  result;
    }

    private String add(String first, String second) {
        StringBuilder answer = new StringBuilder();
        int i =0;
        while(i<first.length() && first.charAt(i) == '0')
        {
            i++;
        }
        if(i<first.length())first=first.substring(i);
        else return second;

        i=0;
        while(i<second.length() && second.charAt(i) == '0')
        {
            i++;
        }
        if(i<second.length())second=second.substring(i);
        else return first;

        if(first.length() < second.length())
        {
            String tmp = first;
            first = second;
            second = first;
        }
        char [] firstIn = first.toCharArray(); char [] secondIn = second.toCharArray();

        int carry = 0;
        int atoiFactor = 2*'0';
        int delta = firstIn.length-secondIn.length;
        for(i=second.length()-1; i>=0; i--)
        {
            int sum = firstIn[i+delta] + secondIn[i] -  atoiFactor + carry;
            carry = sum/10;
            sum = sum%10;
            firstIn[i+delta] = (char)('0'+sum);

        }
        if(first.length() == second.length())
        {
            if(carry > 0)
            {
                return answer.append(carry).append(firstIn).toString();
            }
            else
            {
                return answer.append(firstIn).toString();
            }
        }
        else
        {
            if(carry > 0)
            {
                atoiFactor = '0';
                for(i=first.length()-second.length()-1; i>=0; i--)
                {
                    int sum = firstIn[i] -  atoiFactor + carry;
                    carry = sum/10;
                    sum = sum%10;
                    firstIn[i] = (char)('0'+sum);
                }

                if(carry > 0)
                {
                    return answer.append(carry).append(firstIn).toString();
                }
                else
                {
                    return answer.append(firstIn).toString();
                }
            }
            else
            {
                return answer.append(firstIn).toString();
            }
        }
    }
}
