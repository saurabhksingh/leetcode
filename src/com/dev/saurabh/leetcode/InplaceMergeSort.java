package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class InplaceMergeSort {

    public static void main(String [] args)
    {
        int [] A =  new int[] {1,2,3,0,0,0,0};
        int [] B = new int[] {4,5,6,7};
        new InplaceMergeSort().merge(A,3,B,4);
        for(int num : A)
        {
            System.out.println(num);
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        if(B == null || B.length == 0)
        {
            return;
        }
        if(A == null || A.length == 0)
        {
            return;
        }
        if(m == 0 && A.length >= B.length)
        {
            for(int i=0; i<n; i++)
            {
                A[i] = B[i];
            }

            return;
        }
        int indexA = m-1;
        int indexB = n-1;
        int fillIndex = A.length-1;
        while(indexA >= 0 && indexB >=0)
        {
            if(A[indexA] > B[indexB])
            {
                A[fillIndex--] = A[indexA--];
            }
            else
            {
                A[fillIndex--] = B[indexB--];
            }
        }

        if(indexA < 0)
        {
            for(int i=indexB; i>=0 && fillIndex>=0; i--)
            {
                A[fillIndex--] = B[i];
            }
        }
        if(indexB < 0)
        {
            for(int i=indexA; i>=0 && fillIndex>=0; i--)
            {
                A[fillIndex--] = A[i];
            }
        }
    }
}
