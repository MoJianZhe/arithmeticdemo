package org.example.demo.tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 深度优先遍历
 * @author jun
 */
public class DFS {
    Set<TreeNode> visitedSet = new HashSet<>();
    public void transfer(TreeNode current) {
        if (current == null) {
            return;
        }
//        visitedSet.add(current);
        System.out.println(current.val);
        transfer(current.left);
        transfer(current.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(20);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(41);
        root.right.right = new TreeNode(55);
        new DFS().transfer(root);
    }
}
