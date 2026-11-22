package Easy_Level;

import java.util.ArrayList;

public class MinimumBaseWithEqualDigitsRepresentation {
    private static int findMinBase(int m) {
        int b = 2;
        boolean isfound = false;
        while (!isfound) {
            isfound = solve(m, b);
            if (!isfound) {
                b++;
            }
        }
        return b;
    }

    private static boolean solve(int m, int b) {
        ArrayList<Integer> list = new ArrayList<>();
        while (m != 0) {
            int d = m % b;
            list.add(d);
            m /= b;
        }
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) != list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findMinBase(63));
    }
}