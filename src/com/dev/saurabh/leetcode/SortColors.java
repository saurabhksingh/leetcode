package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 3:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortColors {

    public static void main(String [] args)
    {
        SortColors instance = new SortColors();
        instance.runTest();
    }

    private void runTest() {

        int [] A = new int[] {0,0,1,2,1,0,2,1};

        sortColors(A);

        for(int data : A)
        {
            System.out.println(data);
        }

    }

    public void sortColors(int[] A) {
       int count0 = 0, count1 = 0, count2 = 0;

        if(A == null || A.length == 0)
        {
            return;
        }

        for(int i=0; i<A.length; i++)
        {
            count0 += A[i]==0?1:0;
            count1 += A[i]==1?1:0;
            count2 += A[i]==2?1:0;
        }
        for(int i=0; i<count0; i++)
        {
            A[i] = 0;
        }
        for(int i=0;i<count1; i++)
        {
            A[i+count0] = 1;
        }
        for(int i=0;i<count2; i++)
        {
            A[i+count0+count1] = 2;
        }
    }
}
