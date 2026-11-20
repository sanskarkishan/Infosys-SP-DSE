package Easy_Level;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement1 {
    private static int[] solve(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums2[i], i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int nextMax = -1;
            int start = map.get(nums1[i]);
            for (int j = start; j < m; j++) {
                if (nums2[j] > nums1[i]) {
                    nextMax = nums2[j];
                    break;
                }
            }
            ans[i] = nextMax;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solve(nums1, nums2)));
    }
}
