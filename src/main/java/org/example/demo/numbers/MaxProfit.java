package org.example.demo.numbers;

/**
 * 买卖股票最大收益 #122
 * @author jun
 */
public class MaxProfit {

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }
}
