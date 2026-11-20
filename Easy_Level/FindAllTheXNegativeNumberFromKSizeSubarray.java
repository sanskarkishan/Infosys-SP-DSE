package Easy_Level;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindAllTheXNegativeNumberFromKSizeSubarray {
    private static int[] find(int[] nums, int k, int x) {
        int n = nums.length;
        int m = n - k + 1;
        int[] ans = new int[m];
        int index = 0;

        int i = 0;
        int j = k;
        while (j <= n) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int l = i; l < j; l++) {
                q.add(nums[l]);
            }

            int temp = x;
            for (int l = 0; l < k; l++) {
                if (temp == 1) {
                    if (q.peek() < 0){
                        ans[index++] = q.peek();
                        break;
                    }
                } else {
                    temp--;
                    q.poll();
                }
            }
            i++;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -3, -2, 3};
        System.out.println(Arrays.toString(find(nums, 3, 2)));
    }
}
