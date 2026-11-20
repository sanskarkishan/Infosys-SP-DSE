package Medium_Level;

import java.util.Arrays;

public class MinimumPlatforms {
    private static int solve(int[][] time) {
        int n = time.length;
        if (n == 1) return 1;
        int count = 1;
        int max = 0;
        int i = 0;
        int j = 1;
        Arrays.sort(time, (a, b) -> Integer.compare(a[0], b[0]));
        while (i < n && j < n) {
            if (time[j][0] >= time[i][0] && time[j][0] <= time[i][1]) {
                count++;
                j++;
            } else {
                max = Math.max(max, count);
                count = 1;
                i++;
                j = i + 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        int[][] time = {{1000, 1200}, {935, 1240}, {1100, 1300}};
        System.out.println(solve(time));
    }
}
