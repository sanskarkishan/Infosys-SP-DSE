package Medium_Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    private static int[][] solve(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int idx = 0;
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
            } else {
                temp.add(List.of(intervals[idx][0], intervals[i][1]));
                idx = i+1;
            }
        }
        temp.add(List.of(intervals[idx][0], intervals[intervals.length - 1][1]));
        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i][0] = temp.get(i).get(0);
            ans[i][1] = temp.get(i).get(1);
        }
        return ans;
    }
}
