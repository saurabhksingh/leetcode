package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 2:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInsertPosition {

    public static void main(String [] args)
    {
        SearchInsertPosition instance = new SearchInsertPosition();
        instance.runTest();
    }

    private void runTest() {

        int [] A = new int[]{1,3};
        System.out.println(searchInsert(A,2));
    }

    public int searchInsert(int[] A, int target) {

        if(A==null || A.length == 0)
        {
            return 0;
        }

        int low = 0, high = A.length-1;
        int mid = 0;

        while(low < high)
        {
            mid = (low+high)/2;

            if(A[mid] == target)
            {
                return mid;
            }
            else
            {
                if(A[mid] > target)
                {
                    high = mid-1;
                }
                else
                {
                    low = mid+1;
                }
            }
        }

        return low;

    }
}
