package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/23/12
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class BalancedBinaryTree {

    public static void main(String [] args)
    {

    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right==null))
        {
            return true;
        }

        else
        {
            int lHeight = getHeight(root.left);
            int rHeight = getHeight(root.right);
            int diff = lHeight-rHeight;
            return (diff >=-1 && diff<=1) && isBalanced(root.left) && isBalanced(root.right);
        }

    }

    private int getHeight(TreeNode node) {
        if(node == null)
        {
            return 0;
        }

        return 1+ Math.max(getHeight(node.left), getHeight(node.right));
    }
}
