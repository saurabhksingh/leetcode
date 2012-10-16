package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 4:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String [] args)
    {
        MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
        System.out.println(instance.findMedianSortedArrays(new int [] {1,2,5,6}, new int [] {3,4,7,8,9,10}));
    }

    private double findMedianSortedArrays(int[] A, int[] B)
    {
      if(A==null || A.length==0)
      {
          if(B==null || B.length == 0)
          {
              return 0.0;
          }
          else
          {
              if(B.length % 2 ==0)
              {
                  return (B[B.length>>1]+ B[(B.length>>1)-1])/2.0;
              }
              else
              {
                  return B[B.length>>1];
              }
          }
      }
      else if(B == null || B.length == 0)
      {
          if(A.length % 2 ==0)
          {
              return (A[A.length>>1]+ A[(A.length>>1)-1])/2.0;
          }
          else
          {
              return A[A.length>>1];
          }
      }

      if ( A.length <= B.length )
      {
          return getMedianNum(A, 0, A.length, B, 0, B.length);
      }
      else
      {
          return getMedianNum(B, 0, B.length, A, 0, A.length);
      }

    }

    private double getMedianNum(int[] A, int startA, int lengthA, int[] B, int startB, int lengthB) {
        if (lengthA == 1 )
        {
            if ( lengthB == 1 )
                return (A[startA] + B[startB]) / 2.0;
            if ( lengthB % 2 == 1)
                return ( B[startB + lengthB/2] + getMedian(A[startA], B[startB+ lengthB/2-1], B[startB + lengthB/2+1]) ) / 2.0 ;
            else
                return getMedian( A[startA], B[startB + lengthB/2-1], B[lengthB/2] );
        }

        if ( lengthA == 2 )
        {
            if ( lengthB == 2 )
                return getMedian(A[startA], A[startA+1], B[startB], B[startB+1]);
            if ( lengthB % 2 == 1 )
                return getMedian( B[startB+ lengthB/2], Math.min(A[startA], B[startB + lengthB/2+1]), Math.max(A[startA+1], B[startB+ lengthB/2-1]) ) ;
            else
                return getMedian( B[startB + lengthB/2-1], B[startB + lengthB/2], Math.min(A[startA], B[startB+ lengthB/2+1]), Math.max(A[startA+1], B[startB + lengthB/2-2]) );
        }

        if((lengthA) > (lengthB))
        {
            return getMedianNum(B, startB, lengthB, A, startA, lengthA);
        }


        int minRemoved, idxA = startA+ lengthA/2 , idxB = startB + lengthB/2 ;

        if ( A[idxA] < B[idxB]  )
        {
            if ( lengthA % 2 == 0 ) --idxA;       //for even number of elements --idxA points to lower median of A[]
            minRemoved = Math.min ( idxA, lengthB - idxB - 1+startB) ;

            return getMedianNum( A,startA+minRemoved, lengthA - minRemoved, B,startB, lengthB - minRemoved);
        }
        else
        {
            if ( lengthB % 2 == 0 ) --idxB;       //for even number of elements --idxB points to lower median of B[]
            minRemoved = Math.min ( lengthA - idxA - 1+startA, idxB) ;
            return getMedianNum( A, startA, lengthA - minRemoved, B, startB+ minRemoved, lengthB - minRemoved);
        }
    }

    private double getMedian(int a, int b, int c)
    {
        int minValue = Math.min (a, Math.min (b,c) ) ;
        int maxValue = Math.max (a, Math.max (b,c) ) ;
        return (a + b + c - minValue - maxValue);
    }

    private double getMedian(int a, int b, int c, int d)
    {
        int minValue = Math.min (d, Math.min (a, Math.min (b,c) ) );
        int maxValue = Math.max (d, Math.max (a, Math.max (b,c) ) );
        return (a + b + c + d - minValue - maxValue) / 2.0 ;

    }

}
