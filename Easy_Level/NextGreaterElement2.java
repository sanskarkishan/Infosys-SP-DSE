package Easy_Level;

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
// return the next greater number for every element in nums.
//
// The next greater number of a number x is the first greater number to its traversing-order next in the array,
// which means you could search circularly to find its next greater number. If it doesn't exist,
// return -1 for this number.

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

// Create a circular array by duplicating the original array,
// so that elements after the last index can be traversed naturally.
// Traverse from right to left while maintaining a monotonic decreasing stack.
// Remove all elements smaller than or equal to the current element because
// they can never be the next greater element for any previous element.

// If the stack becomes empty, no greater element exists on the right,
// so store -1. Otherwise, the top of the stack is the next greater element.

// Push the current index into the stack so it can act as a candidate
// next greater element for elements on its left.

    private static int[] solve(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int m = 2 * n;
        int[] newArr = new int[m];
        for (int i = 0; i < m; i++) {
            newArr[i] = nums[i % n];
        }

        for (int i = m - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                nums[i % n] = -1;
                stack.push(i % n);
            } else {
                while (!stack.isEmpty() && newArr[stack.peek()] <= newArr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    nums[i % n] = -1;
                    stack.push(i % n);
                } else {
                    nums[i % n] = newArr[stack.peek()];
                    stack.push(i % n);
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(solve(nums)));
    }
}
