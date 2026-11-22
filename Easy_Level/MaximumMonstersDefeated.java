package Easy_Level;

import java.util.Arrays;

public class MaximumMonstersDefeated {
    private static int monsterCount(int[] power, int[] bonus, int e) {
        int n = power.length;
        int[][] newArr = new int[n][2];
        for (int i = 0; i < n; i++) {
            newArr[i][0] = power[i];
            newArr[i][1] = bonus[i];
        }
        Arrays.sort(newArr, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (newArr[i][0] <= e) {
                count++;
                e += newArr[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] p = {78, 130};
        int[] b = {10, 0};
        int e = 123;
        System.out.println(monsterCount(p, b, e));
    }
}
