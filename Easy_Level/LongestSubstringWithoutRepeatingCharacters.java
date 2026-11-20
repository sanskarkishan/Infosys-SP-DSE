package Easy_Level;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    private static int solve(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < n) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                max = Math.max(max, count);
                count = 0;
                i++;
                j = i;
                set.clear();
            } else {
                set.add(ch);
                count++;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
