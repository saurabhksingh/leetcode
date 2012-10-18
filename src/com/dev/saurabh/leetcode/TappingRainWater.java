package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class TappingRainWater {

    public static void main(String [] args)
    {
        TappingRainWater instance = new TappingRainWater();
        instance.runTest();
    }

    private void runTest() {

        int [] A = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(A));
    }

    public int trap(int[] A) {

        int sum = 0;

        if(A == null || A.length==0)
        {
            return 0;
        }

        int [] leftHigh = new int[A.length];
        int [] rightHigh = new int[A.length];
        int currentHeigh = A[0];

        for(int i=1; i<A.length; i++)
        {
            leftHigh[i] = currentHeigh;
            if(A[i] > currentHeigh)
            {
                currentHeigh = A[i];
            }
        }

        currentHeigh = A[A.length-1];
        for(int i=A.length-2; i>=0; i--)
        {
            rightHigh[i] = currentHeigh;
            if(A[i] > currentHeigh)
            {
                currentHeigh = A[i];
            }
        }

        for(int i=0; i<A.length; i++)
        {
            int fillHeightAvailable = Math.min(leftHigh[i], rightHigh[i]);
            if(fillHeightAvailable > A[i])
            {
                sum += fillHeightAvailable-A[i];
            }
        }

        return sum;

    }
}
