package Medium_Level;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    static List<Integer> ans;
    static int n;

    private static int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        ans = new ArrayList<>();
        solve(triangle, 1, 0, triangle.get(0).get(0));
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ans.size(); i++) {
            result = Math.min(result, ans.get(i));
        }
        return result;
    }

    private static void solve(List<List<Integer>> triangle, int i, int idx, int sum) {
        if (i == n) {
            ans.add(sum);
            return;
        }
        int l = sum + triangle.get(i).get(idx);
        solve(triangle, i+1, idx, l);
        int r = sum + triangle.get(i).get(idx + 1);
        solve(triangle, i+1, idx + 1, r);
    }

}
