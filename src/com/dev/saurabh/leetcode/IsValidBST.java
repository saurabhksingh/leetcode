package com.dev.saurabh.leetcode;

/**
 * Copyright (c)
 * User: saurabh
 * Date: 10/18/12
 * Time: 11:07 AM
 * This file is created and owned by Saurabh Kr Singh (saurabh.nsit@gmail.com).
 * The code written here is being released under Apache 2.0 License
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class IsValidBST {

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root  == null)
        {
            return true;
        }
        return validate(root, min, max);
    }

    private boolean validate(TreeNode root, int min, int max) {
        if(root  == null)
        {
            return true;
        }

        return root.val > min
                && root.val < max
                && validate(root.left,min,root.val)
                && validate(root.right,root.val,max);
    }
}
