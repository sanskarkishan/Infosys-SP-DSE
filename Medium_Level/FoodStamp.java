package Medium_Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodStamp {
    private static int food(int[] t, int[] d, int k) {
        int n = t.length;
        List<Integer> list = new ArrayList<>(); // we can use heap also Heap
        for (int i = 0; i < n; i++) {
            int num = t[i];
            while (num > 0) {
                list.add(num);
                num = num - d[i];
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] t = {5,7,9};
        int[] d = {2,4,6};
        int k = 5;
        System.out.println(food(t, d, k));
    }
}
