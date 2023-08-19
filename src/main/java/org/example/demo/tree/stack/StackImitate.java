package org.example.demo.tree.stack;

import org.example.demo.tree.TreeNode;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author linjun
 * @date 2023/4/27
 * stack 模拟前序遍历
 **/
public class StackImitate {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        root.left = new TreeNode(20);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(41);
        root.right.right = new TreeNode(55);
        System.out.println(new StackImitate().preorderTraversal(root).toString());
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<Command> commandStack = new Stack<>();
        commandStack.push(new Command("go", root));
        while (!commandStack.isEmpty()) {
            Command pop = commandStack.pop();
            if (pop == null || pop.node == null) {
                continue;
            }
            if (pop.c.equals("go")) {
                commandStack.push(new Command("go", pop.node.right));
                commandStack.push(new Command("go", pop.node.left));
                commandStack.push(new Command("do", pop.node));

            } else if(pop.c.equals("do")) {
                resultList.add(pop.node.val);
            }
        }
        return resultList;
    }

    static class Command {
        String c;
        TreeNode node;

        Command(String c, TreeNode v) {
            this.c = c;
            this.node = v;
        }
    }

}
