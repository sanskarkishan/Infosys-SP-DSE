package Medium_Level;

import java.util.Arrays;

public class PalindromicSubstrings {
    static int[][] dp;
    private static int countSubstrings(String s) {
        dp = new int[1001][1001];
        for (int[] nums : dp){
            Arrays.fill(nums, -1);
        }
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean check(String s, int i, int j) {
        if (i > j){
            return true;
        }
        if (dp[i][j] != -1){
            if (dp[i][j] == 0){
                return false;
            }
            return true;
        }
        if (s.charAt(i) == s.charAt(j)){
            if (check(s, i+1, j-1)){
                dp[i][j] = 1;
                return true;
            } else {
                dp[i][j] = 0;
                return false;
            }
        }
        dp[i][j] = 1;
        return false;
    }
}
