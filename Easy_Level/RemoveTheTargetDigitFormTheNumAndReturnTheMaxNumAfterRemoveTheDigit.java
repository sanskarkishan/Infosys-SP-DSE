package Easy_Level;

public class RemoveTheTargetDigitFormTheNumAndReturnTheMaxNumAfterRemoveTheDigit {
    private static int removeDigit(String s, char c) {
        int max = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == c) {
                String l = s.substring(0, i);
                String r = s.substring(i + 1, n);
                int num = Integer.parseInt(l + r);
                max = Math.max(max, num);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(removeDigit("1321", '1'));
    }
}
