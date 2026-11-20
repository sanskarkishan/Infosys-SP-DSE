// At each coin, we have two choices:
// 1. Take the current coin and stay at the same index because
//    the coin can be used unlimited times.
// 2. Skip the current coin and move to the next index.
// Whenever amount becomes 0, update the minimum number of coins used.
// Prune paths that already use more coins than the current best answer.
package Medium_Level;

public class CoinChange {
    static int count;
    static int n;

    private static int coinChange(int[] coins, int amount) {
        n = coins.length;
        count = Integer.MAX_VALUE;
        solve(coins, 0, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private static void solve(int[] coins, int i, int amount, int counts) {
        if (amount == 0) {
            count = Math.min(counts, count);
            return;
        }
        if (i == n){
            return;
        }
        if (amount < coins[i]) {
            solve(coins, i + 1, amount, counts);
            return;
        }
        solve(coins, i, amount - coins[i], counts + 1);
        solve(coins, i + 1, amount, counts);
    }

    public static void main(String[] args) {
        int[] coins = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
        int amount = 9864;
        System.out.println(coinChange(coins, amount));
    }
}
