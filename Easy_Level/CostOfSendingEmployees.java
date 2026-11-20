package Easy_Level;

import java.util.Arrays;

public class CostOfSendingEmployees {
    private static int findCost(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            b[i] = (Math.min(a[i], b[i]) + b[i]) - a[i];
        }
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        for (int i = 0; i < n / 2; i++) {
            sum += b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {10, 30, 50, 20};
        int[] b = {20, 10, 40, 30};
        System.out.println(findCost(a, b));
    }
}
