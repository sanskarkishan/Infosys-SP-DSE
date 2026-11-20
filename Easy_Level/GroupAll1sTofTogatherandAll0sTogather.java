package Easy_Level;

public class GroupAll1sTofTogatherandAll0sTogather {
    private static int group(String s) {
        int i = 0;
        int j = s.length() - 1;
        int countL = 0;
        char[] str = s.toCharArray();
        while (i < j) {
            char l = str[i];
            char r = str[j];
            if (l == '1' && r == '1') {
                i++;
            }
            if (l == '1' && r == '0') {
                i++;
                j--;
            }
            if (l == '0' && r == '1') {
                swap(str, i, j);
                countL++;
                i++;
                j--;
            }
        }

        i = 0;
        j = s.length() - 1;
        str = s.toCharArray();
        int countR = 0;
        while (i < j) {
            char l = str[i];
            char r = str[j];
            if (l == '1' && r == '1') {
                j--;
            }
            if (l == '0' && r == '1') {
                i++;
                j--;
            }
            if (l == '1' && r == '0') {
                swap(str, i, j);
                countR++;
                i++;
                j--;
            }
        }
        return Math.min(countL, countR);
    }

    private static void swap(char[] str, int i, int j) {
        char ch = str[i];
        str[i] = str[j];
        str[j] = ch;
    }

    public static void main(String[] args) {
        System.out.println(group("010110"));
    }
}
