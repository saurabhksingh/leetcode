package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/7/12
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinPathSumInGrid {

    public static void main(String [] args)
    {
        MinPathSumInGrid instance = new MinPathSumInGrid();
        int [][] grid = new int[][] {{-5,1,5}, {-4,8,8}, {7,8,9}};

        System.out.println(instance.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=1; i < rows; i++)
            grid[i][0] += grid[i-1][0];

        for (int j=1; j < cols; j++)
            grid[0][j] += grid[0][j-1];

        for (int i=1; i < rows; i++) {
            for (int j=1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + + grid[i][j];
            }
        }
        return grid[rows-1][cols-1];

    }
}
