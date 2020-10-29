package org.example.demo.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层级遍历 #102
 *
 * @author jun
 */
public class BreadthFS {

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        ArrayDeque<TreeNode> convenienceQueue = new ArrayDeque<>();
        convenienceQueue.add(root);
        while (!convenienceQueue.isEmpty()) {
            //每一层有多少个节点。遍历一次，就会把这一层的节点数全部放进来，
            //queue 的size 就表示每一层的节点数
            int levelSize = convenienceQueue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = convenienceQueue.poll();
                if (treeNode == null) {
                    break;
                }
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    convenienceQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    convenienceQueue.add(treeNode.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
