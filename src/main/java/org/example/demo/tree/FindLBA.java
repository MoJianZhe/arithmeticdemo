package org.example.demo.tree;

/**
 * 查找2个节点的公共祖先。#235
 */
public class FindLBA {

    public static void main(String[] args) {

    }

    public static TreeNode findLBA(TreeNode root, TreeNode a, TreeNode b) {
        return inTree(root, a, b);
    }


    /**
     * 时间复杂度:O(n)，//todo 为啥不是 O(logn)?
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    public static TreeNode inTree(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {return null;}
        //比a大并且比b大
        if (root.val > a.val && root.val > b.val) {
            return inTree(root.left, a, b);
        }
        //比a小，并且比b小
        if (root.val < a.val && root.val < b.val) {
            return inTree(root.right, a, b);
        }
        //如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，a,和b , 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
        return root;
    }
}
