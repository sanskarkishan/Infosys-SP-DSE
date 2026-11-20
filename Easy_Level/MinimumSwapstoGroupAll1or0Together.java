package Easy_Level;

public class MinimumSwapstoGroupAll1or0Together {
    private static int minSwaps(int[] nums) {
        int one = solve(nums, 1);
        int zero = solve(nums, 0);
        return Math.min(one, zero);
    }

    private static int solve(int[] nums, int target) {

        int count = 0;

        for (int num : nums) {
            if (num == target) count++;
        }

        if (count <= 1) return 0;

        int curr = 0;

        // First window
        for (int i = 0; i < count; i++) {
            if (nums[i] != target) curr++;
        }

        int min = curr;

        // Sliding window
        for (int i = count; i < nums.length; i++) {

            if (nums[i - count] != target) curr--;

            if (nums[i] != target) curr++;

            min = Math.min(min, curr);
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1};
        System.out.println(minSwaps(arr));
    }
}
