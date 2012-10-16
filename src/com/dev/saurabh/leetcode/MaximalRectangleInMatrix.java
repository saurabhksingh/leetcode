package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/8/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaximalRectangleInMatrix {

    public static void main(String [] args)
    {
        MaximalRectangleInMatrix instance = new MaximalRectangleInMatrix();
        char [][] matrix = {{'1','1','1','1'}, {'1','1','1','1'},{'1','1','1','1'},{'1','1','1','1'}};
        System.out.println(instance.maximalRectangle(matrix));
    }
    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0)
        {
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int [][] S = new int[rows][columns];

        for(int i=0; i<columns; i++)
        {
           S[0][i] = matrix[0][i]-'0';
        }

        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                if((matrix[i][j] -'0') != 0)
                {
                    S[i][j] = matrix[i][j]-'0' + S[i-1][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<rows; i++)
        {
            int area = largestRectangleArea(S[i]);
            if(area > max)
            {
                max = area;
            }
        }

        return max;
    }

    private int largestRectangleArea(int[] height)
    {
        int result = 0;
        int count = 1;
        for(int i=1; i<height.length; i++)
        {
            if(height[i] >= height[i-1])
            {
                continue;
            }
            else
            {
                count = 1;
                for(int j=i-1; j>=0; j--)
                {

                    result = Math.max(result, height[j]*count);
                    if(height[j]> height[i])
                    {
                        height[j] = height[i];
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        count = 1;
        for(int i=height.length-1; i>=0; i--)
        {
            result = Math.max(result, height[i]*count);
            count++;
        }

        return result;
    }
}
