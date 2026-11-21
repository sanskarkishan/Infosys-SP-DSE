package Medium_Level;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumSumofPairMaximumswithBipartitePairing {
    private static int maxSum(int[] weight, int[] category) {
        int n = weight.length;
        int m = category.length;
        if (n % 2 != 0 || m % 2 != 0) return -1;
        if (n != m) return -1;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < m; i++) {
            ones += category[i];
        }
        zeros = m - ones;
        if (ones != zeros) return -1;

        ArrayList<Integer> zeroWeg = new ArrayList<>();
        ArrayList<Integer> oneWeg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (category[i] == 0) {
                zeroWeg.add(weight[i]);
            } else {
                oneWeg.add(weight[i]);
            }
        }

        Collections.sort(zeroWeg);
        Collections.sort(oneWeg);
        Collections.reverse(oneWeg);

        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += Math.max(zeroWeg.get(i), oneWeg.get(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] weights = {1, 5, 2, 8};
        int[] category = {0, 0, 1, 1};
        System.out.println(maxSum(weights, category));
    }
}
