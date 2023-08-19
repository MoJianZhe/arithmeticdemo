package org.example.demo.backtrack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author linjun
 * @date 2023/4/30
 * #79 单词搜索
 * 给定二维数组中，是否存在这个单词
 **/
public class ExistWord {

    // x 边界
    private int maxX;
    // y 边界
    private int maxY;

    private  boolean[][] visited ;

    //上，右，下，左
    private final int[][] director = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        maxX = board.length;
        maxY = board[0].length;
        visited = new boolean[maxX][maxY];
        Deque<Character> hasSelectQueue = new ArrayDeque<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findWord(board, word, i, j, 0, hasSelectQueue)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从 x,y 上下左右方向，不停地去寻找下一个字符
     * @param board 二维数组
     * @param word 需要寻找的单词
     * @param x x坐标
     * @param y y坐标
     * @param hasSelectQueue 已经寻找的数据
     * @return 是否成功
     */
    private boolean findWord(char[][] board, String word, int x, int y, int start, Deque<Character> hasSelectQueue) {
        System.out.println("findWord x is " + x + "  y is " + y + " start is " + start + "  queue is " + hasSelectQueue);
        if (hasSelectQueue.size() == word.length() - 1) {
            //判断最后一个是否相等
            return board[x][y] == word.charAt(word.length() - 1);
        }


        //判断点是否一致
        if (board[x][y] == word.charAt(start)) {
            hasSelectQueue.addLast(word.charAt(start));
            visited[x][y] = true;
        } else {
            return false;
        }
        boolean nextResult = false;
        //4个方向寻找下一个
        for (int i = 0; i < 4; i++) {
            int newX = x + director[i][0];
            int newY = y + director[i][1];
            if (isInArea(newX, newY) && !visited[newX][newY]) {
                nextResult = findWord(board, word, newX, newY, start + 1, hasSelectQueue);
                if (nextResult) {//说明已经找到解了，可以返回了，不需要4个方向去循环了
                    return nextResult;
                }
//                return result; 直接 return 就跳出上下左右循环了
            }
        }
        //如果下面4个方向都没有，就需要退出添加的数据了
        hasSelectQueue.pollLast();
        visited[x][y] = false;

        return nextResult;

    }

    private boolean isInArea(int newX, int newY) {
        return newX < maxX && newX >= 0 && newY < maxY && newY >= 0;
    }


    public static void main(String[] args) {
//        {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        //{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}  "ABCB"
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCB";



        System.out.println(new ExistWord().exist(board, word));
    }

}
