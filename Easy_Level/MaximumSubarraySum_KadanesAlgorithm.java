package Easy_Level;

public class MaximumSubarraySum_KadanesAlgorithm {
    private static int solve(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,-3,3,4};
        System.out.println(solve(nums));
    }
}
