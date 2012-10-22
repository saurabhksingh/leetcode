package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pow {

    public static void main(String [] args)
    {
        Pow instance = new Pow();
        System.out.println(instance.pow(0.00001, 2147483647));
    }

    public double pow(double x, int n) {
        if(x == 0.0)
        {   if(n == 0)
                return 1.0;
            return x;
        }
        if(n == 0)
        {
            return 1.0;
        }
        if(n > 0)
        {
            if(n == 1)
            {
                return x;
            }
            if(n%2 == 0)
            {
                double tmp = pow(x,n>>1);
                return tmp*tmp;
            }
            else
            {
                return x * pow(x,n-1);
            }
        }
        else
        {
            if(n == -1)
            {
                return 1.0/x;
            }
            if(n%2 == 0)
            {
                double tmp = pow(x, n/2);
                return tmp*tmp;
            }
            else
            {
                return (1.0/x)*pow(x, (n+1));
            }
        }

    }
}
