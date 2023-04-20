package org.example.demo.tree;

/**
 * 二叉树最大深度
 * @author jun
 */
public class MaxDepth {

    /**
     * O(2^n) n 是树的深度
     * @param root
     * @return
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = getMaxDepth(root.left);
        int maxRight = getMaxDepth(root.right);
        //取深度最大的子树
        int max = Math.max(maxLeft, maxRight);
        return 1 + max;
    }
}
