package org.example.demo.tree;

/**
 * @author linjun
 * @date 2023/4/28
 **/
public class ReverseTree {

    void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        reverseTree(root.left);
        reverseTree(root.right);
    }
}
