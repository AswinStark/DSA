package com.aswinstark.patterns.pathfinding;

public class FindMinCostPath_001 {
    public static void main(String[] args) {
        // Dummy cost matrix for testing
        int[][] cost = {
                {1, 3, 5, 9},
                {8, 1, 3, 4},
                {5, 0, 6, 1},
                {8, 8, 4, 0}
        };

        System.out.println("Minimum cost path: "+ findMinCostPath(cost, 3, 3));
    }

    private static int findMinCostPath(int[][] cost, int i, int j) {
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 || j==0){
            return cost[i][j];
        }
        int cost_x = findMinCostPath(cost, i, j-1);
        int cost_y = findMinCostPath(cost, i-1, j);
        return Math.min(cost_x, cost_y) + cost[i][j];
    }

    private static int findMinCostPathDP(int[][] cost, int i, int j) {
        int dp[][] = new int[cost.length][cost[0].length];

        dp[0][0] = cost[0][0];
        for(int k = 1; k <cost.length; k++){
            dp[k][0] = dp[k -1][0]+cost[k][0];
        }
        for(int k = 1; k <cost[0].length; k++){
            dp[0][k] = dp[0][k -1]+cost[0][k];
        }
        for(int n = 1; n<cost.length; n++){
            for(int m = 1; m<cost[0].length; m++){
                dp[n][m] = cost[n][m]+ Math.min(dp[n-1][m], dp[n][m-1]);
            }
        }
        return dp[i][j];
    }
}
