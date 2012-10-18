package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 4:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class SQRT {

    public static void main(String [] args)
    {
        SQRT instance = new SQRT();
        instance.runTest();
    }

    private void runTest() {
          System.out.println(sqrt(78));
    }

    //babylonian algorithm..
    public int sqrt(int x) {
        if(x == 1)return 1;

        double epsilon = 1e-15;
        double high = x;
        double low = x;

        while (Math.abs(low - high/low) > epsilon*low) {
            low = (high/low + low) / 2.0;
        }

        return (int)(low+0.5);
    }
}
