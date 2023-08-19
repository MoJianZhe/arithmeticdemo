package org.example.demo.tree;

/**
 * @author linjun
 * @date 2023/4/28
 * # 111 二叉树 最小深度
 * 和最深深度的区别就是，对最小问题的判断，不一样。
 * 最深深度，为空节点返回0就好了，<p>根本不需要关系它是不是叶子节点</p> 因为肯定是叶子节点最大。
 * 而最小深度，<p>需要关系是否是叶子节点</p>，不是叶子节点，当然不能算是最短的深度了。
 **/
public class MinDepthTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MinDepthTree().getMinDepth(root));

    }

    public int getMinDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = -1 ;
        if (treeNode.left != null) {
            left = getMinDepth(treeNode.left);
        }
        int right = -1;
        if (treeNode.right != null) {
            right = getMinDepth(treeNode.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right) + 1;
        }
        if (left == -1 && right != -1) {
            return right + 1;
        }
        if (right == -1 && left != -1) {
            return left + 1;
        }
        //left !=-1 && right !=-1
        return 1;

    }



    class Solution {
        public int minDepth(TreeNode root) {
            if(root == null) return 0;
            //这道题递归条件里分为三种情况
            //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
            if(root.left == null && root.right == null) return 1;
            //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
            if(root.left == null || root.right == null) return m1 + m2 + 1;

            //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
            return Math.min(m1,m2) + 1;
        }
    }


}
