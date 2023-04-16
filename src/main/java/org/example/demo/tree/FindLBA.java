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

    public static TreeNode inTree(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {return null;}
        if (root.val > a.val && root.val > b.val) {
            return inTree(root.left, a, b);
        }
        if (root.val < a.val && root.val < b.val) {
            return inTree(root.right, a, b);
        }
        return root;
    }
}
