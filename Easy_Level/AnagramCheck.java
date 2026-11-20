package Easy_Level;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AnagramCheck {
    private static boolean solve(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : sMap.entrySet()) {
            char key = e.getKey();
            int val = e.getValue();
            if (!tMap.containsKey(key) || val != tMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solve("rat", "car"));
    }
}
