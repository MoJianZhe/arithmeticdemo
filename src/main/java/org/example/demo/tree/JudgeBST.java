package org.example.demo.tree;

/**
 * 判断是否是二叉搜索树 #98
 */
public class JudgeBST {


    public static void main(String[] args) {

    }


    /**
     * 判断一颗数是不是二叉查找数，左子树都小于current，又子树都大于 current
     */
    public static boolean isBST(TreeNode treeNode) {
        treeNode.pre = null;
        return helper(treeNode);
    }

    /**
     * O(n)
     * @param root
     * @return
     */
    //按照递归的形式，应该左边小于
    public static boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!helper(root.left)) {
            return false;
        }
        if (root.pre != null && root.pre.val >= root.val) {
            return false;
        }
        root.right.pre = root;
        return helper(root.right);
    }


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        return helper(node.left, lower, val);
    }


    public static boolean isMyBST(TreeNode treeNode) {
        return myHelper(treeNode, null, null);
    }

    public static boolean myHelper(TreeNode current, Integer max, Integer min) {
        if (current == null) {
            return true;
        }
        if (max != null && current.val >= max) {
            return false;
        }
        if (min != null && current.val <= min) {
            return false;
        }
        if (!myHelper(current.left, current.val, min)) {
            return true;
        }
        return myHelper(current.right, max, current.val);
    }

}


