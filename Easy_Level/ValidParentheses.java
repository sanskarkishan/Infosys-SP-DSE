package Easy_Level;

import java.util.Stack;

public class ValidParentheses {
    private static boolean solve(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) return false;

                char top = st.pop();

                if (top == '(' && ch != ')') return false;
                if (top == '{' && ch != '}') return false;
                if (top == '[' && ch != ']') return false;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(solve(s));
    }
}
