package Easy_Level;

public class MaximumXORPrefixSuminaCircularArray {
    private static int maxPrefixSum(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int xor = 0;
            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                xor ^= arr[idx];
                sum += xor;
            }
            max = Math.max(max, sum);
            sum = 0;
            xor = 0;
            for (int j = n - 1; j >= 0; j--) {
                int idx = (i + j) % n;
                xor ^= arr[idx];
                sum += xor;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] n = {7, 8, 5, 5, 9, 2, 2, 0, 1, 6};
        System.out.println(maxPrefixSum(n));
    }
}
