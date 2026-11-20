package Easy_Level;

public class RotateArray {
    private static int[] solve(int[] nums, int k) {
        // Without using extra space
        // We just need to reverse (0 to n-1) -> (0 to k-1) -> (k-1 to n-1)
        // also remember k = k % n // to handle the case k > n


        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        return nums;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
