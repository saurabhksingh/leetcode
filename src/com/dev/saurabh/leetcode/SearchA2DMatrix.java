package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/18/12
 * Time: 2:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class SearchA2DMatrix {

    public static void main(String [] args)
    {
        SearchA2DMatrix instance = new SearchA2DMatrix();
        instance.runTest();
    }

    private void runTest() {
        int [][] matrix  = new int[][]{{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix,3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;

        if(matrix == null || matrix.length == 0)
        {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int startRow = 0;
        int startCol = cols-1;

        while(startRow<rows && startCol>=0)
        {
            if(matrix[startRow][startCol] == target)
            {
                return true;
            }
            else
            {
                if (matrix[startRow][startCol] > target)
                {
                    startCol--;
                }
                else
                {
                    startRow++;
                }
            }
        }

        return result;
    }

}
