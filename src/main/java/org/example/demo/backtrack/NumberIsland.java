package org.example.demo.backtrack;

/**
 * @author linjun
 * @date 2023/5/1
 * #200 岛屿数量
 **/
public class NumberIsland {

    private boolean[][] visited;

    private int maxX;

    private int maxY;

    //上，右，下，左
    private final int[][] director = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        maxX = grid.length;
        maxY = grid[0].length;
        /**
         * 陆地数量
         */
        int islandNum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandAndFindNext(grid, i, j);
                    //没访问一片陆地就+1;
//                    System.out.println("isLand i is " + i + " j is " + j);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private void islandAndFindNext(char[][] grid, int x, int y) {
        /**
         * x,y 已经是陆地了，看下一个步骤是不是陆地。
         * 1. 标记 x, y 访问过
         * 2. 从4个方向访问下一个陆地
         */
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + director[i][0];
            int nextY = y + director[i][1];
            if (isInArea(nextX, nextY) && grid[nextX][nextY] == '1' && !visited[nextX][nextY]) {
                islandAndFindNext(grid, nextX, nextY);
            }
        }
        //这里不能让陆地加1，这里是回溯回去的操作，+1 所有的格子都+1了，没有连成大陆的概念了。
        //islandNum++;

    }

    private boolean isInArea(int nextX, int nextY) {
        return nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new NumberIsland().numIslands(grid));

    }

}
