package org.example.demo.tree;

import java.util.Objects;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode pre;
    TreeNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) return false;
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null)
            return false;
        if (right != null ? !right.equals(treeNode.right) : treeNode.right != null)
            return false;
        return pre != null ? pre.equals(treeNode.pre) : treeNode.pre == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (pre != null ? pre.hashCode() : 0);
        return result;
    }
}
