package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class SameTree {

    public static void main(String [] args)
    {
        SameTree instance = new SameTree();
        instance.runTest();
    }

    private void runTest() {


    }

    class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null)
        {
            return true;
        }
        if(p == null && q != null)
        {
            return false;
        }
        if(p != null && q == null)
        {
            return false;
        }

        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

    }
}
