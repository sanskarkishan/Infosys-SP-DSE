package Easy_Level;

public class GetMaximuminGeneratedArray {
    private static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] arr = new int[n + n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 1; i < (n / 2) + 1; i++) {
            arr[2 * i] = arr[i];
            arr[(2 * i) + 1] = arr[i] + arr[i + 1];
        }
        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(getMaximumGenerated(n));
    }
}
