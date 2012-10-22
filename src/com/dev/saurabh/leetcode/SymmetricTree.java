package com.dev.saurabh.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: saurabh
 * Date: 10/22/12
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymmetricTree {

    public static void main(String [] args)
    {
        SymmetricTree instance = new SymmetricTree();
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        if(root.left == null && root.right == null)
        {
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {

        if(p == null && q == null)
        {
            return true;
        }
        if((p == null && q != null)  || (p != null && q == null))
        {
            return false;
        }

        return (p.val == q.val) && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
