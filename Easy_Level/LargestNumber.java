package Easy_Level;

import java.util.Arrays;


//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
//Since the result may be very large, so you need to return a string instead of an integer.


// Convert all integers into strings so that custom concatenation
// comparisons can be performed during sorting.

// Sort the strings such that for any two numbers s1 and s2,
// the order is decided by comparing s2+s1 and s1+s2.
// Place the combination that forms the larger number first
// to maximize the final concatenated result.

// Join all sorted strings together to construct the largest
// possible number that can be formed using the given integers.

// Compare two numbers by checking which concatenation forms
// a larger value: s1+s2 or s2+s1.
// If s2+s1 is larger, place s2 before s1.

// If the largest element after sorting is "0",
// then all elements are zeros. Returning the joined
// result would produce values like "00" or "000",
// so return a single "0" instead.

public class LargestNumber {
    private static String solve(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = new String("" + nums[i]);
        }
        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        if (str[0].equals("0")) {
            return "0";
        }
        return String.join("", str);
    }
}
