package Easy_Level;

// Given a positive integer n, find the smallest integer which has exactly the same digits existing in the
// integer n and is greater in value than n. If no such positive integer exists, return -1.
//
// Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not
// fit in 32-bit integer, return -1.

// Convert the number into a character array to work with individual digits.

// Traverse from right to left and find the first digit that is smaller
// than its next digit. This position acts as the pivot where the next
// greater permutation can be formed.

// If no such pivot exists, the digits are arranged in descending order,
// so no greater number can be formed. Return -1.

// Find the smallest digit on the right side of the pivot that is
// greater than the pivot digit.

// Swap the pivot digit with that next greater digit.

// Reverse the suffix after the pivot to obtain the smallest possible
// arrangement, ensuring the result is the next immediate greater number.

// Convert the resulting digit array back to a number.

// Check whether the generated number fits within the 32-bit integer range.
// If it exceeds Integer.MAX_VALUE, return -1.

public class NextGreaterElement3 {
    private static int solve(int n) {
        char[] ch = ("" + n).toCharArray();
        int i = ch.length - 2;
        while (i >= 0 && ch[i] >= ch[i + 1]) {
            i--;
        }
        if (i == -1) return -1;

        int j = ch.length - 1;
        while (j > i && ch[j] <= ch[i]) {
            j--;
        }

        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

        int l = i + 1;
        int r = ch.length - 1;
        while (l < r) {
            char temp2 = ch[l];
            ch[l] = ch[r];
            ch[r] = temp2;
        }
        long ans = Long.parseLong(new String(ch));
        return ans <= Integer.MAX_VALUE ? (int) ans : -1;
    }
}
