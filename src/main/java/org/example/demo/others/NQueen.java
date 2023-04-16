package org.example.demo.others;

import java.util.*;

/**
 * N皇后问题 #51
 * @author jun
 */
public class NQueen {

    //todo incomprehension

    public List<List<String>> getSolution(int n) {

        return null;
    }


    public static class MyQueen {

        public List<List<String>> solution(int n) {
            return null;
        }

        public void helper(List<List<String>> solution, int row, int n, int[] queens,
                Set<Integer> cols, Set<Integer> s1, Set<Integer> s2) {
            if (row == n) {
                solution.add(generalBoard(queens, n));
            } else {
                for (int i = 0; i < n; i++) {
                    int colS1 = row - i;
                    if (s1.contains(colS1)) {
                        continue;
                    }
                    int colS2 = row + i;
                    if (s2.contains(colS2)) {
                        continue;
                    }
                    queens[row] = i;
                    cols.add(i);
                    s1.add(colS1);
                    s2.add(colS2);
                    helper(solution, row + 1, n, queens, cols, s1, s2);
                    queens[row] = -1;
                    cols.remove(i);
                    s1.remove(colS1);
                    s2.remove(colS2);
                }
            }

        }

        public List<String> generalBoard(int[] queen, int n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '*');
                chars[queen[i]] = 'Q';
                list.add(Arrays.toString(chars));
            }
            return list;

        }

    }


    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
            return solutions;
        }

        public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                List<String> board = generateBoard(queens, n);
                solutions.add(board);
            } else {
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    queens[row] = i;
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                    queens[row] = -1;
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
            }
        }

        public List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }

}
