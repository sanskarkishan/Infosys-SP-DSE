package Medium_Level;

import java.util.HashMap;
import java.util.Map;

// Intuition:
// For a valid pair (a[i], a[j]):
//
// 1. (a[i] - a[j]) % d == 0
//    => a[i] % d == a[j] % d
//    => both numbers belong to the same remainder group.
//
// 2. Let the common remainder be r.
//    Then:
//
//    (a[i] + a[j]) % d
//    = (r + r) % d
//    = (2 * r) % d
//
//    For the pair to be valid:
//    (2 * r) % d == 0
//
// Therefore, we first group numbers by their remainder modulo d.
// Only those remainder groups satisfying (2 * remainder) % d == 0
// can contribute valid pairs.
//
// If a valid remainder group contains 'freq' elements,
// the number of ways to choose 2 elements from it is:
//
// freq * (freq - 1) / 2
//
// Summing this value for all valid remainder groups gives the answer.
//
// Time Complexity: O(n)
// Space Complexity: O(d) / O(n)

public class CountPairs {
    public static long countPairs(int[] nums, int d) {
        Map<Integer, Long> freq = new HashMap<>();

        for (int num : nums) {
            int rem = ((num % d) + d) % d;
            freq.put(rem, freq.getOrDefault(rem, 0L) + 1);
        }

        long count = 0;

        for (Map.Entry<Integer, Long> entry : freq.entrySet()) {
            int rem = entry.getKey();
            long f = entry.getValue();

            if ((2 * rem) % d == 0) {
                count += f * (f - 1) / 2;
            }
        }

        return count;
    }
}
