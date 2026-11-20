package Medium_Level;

import java.util.Arrays;

public class NumberOfWaysToStoreKAmountOfWater {
    static int[][] dp;
    static int n;

    private static int findWays(int[] capacity, int amount) {
        n = capacity.length;
        dp = new int[n][amount + 1];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return solve(capacity, 0, amount);
    }

    private static int solve(int[] capacity, int i, int amt) {
        if (amt == 0) {
            return 1;
        }
        if (i == n || amt < 0) {
            return 0;
        }
        if (dp[i][amt] != -1) {
            return dp[i][amt];
        }
        if (capacity[i] > amt) {
            return dp[i][amt] = solve(capacity, i + 1, amt);
        }

        int take = solve(capacity, i, amt - capacity[i]);
        int skip = solve(capacity, i + 1, amt);

        return dp[i][amt] = take + skip;
    }

    public static void main(String[] args) {
        int[] c = {1, 2, 5};
        int a = 5;
        System.out.println(findWays(c, a));
    }
}
