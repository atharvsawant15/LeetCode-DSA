import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';  // previous operator

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');  // handle multi-digit numbers
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // apply the previous operator
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;  // update operator
                num = 0;   // reset number
            }
        }

        int result = 0;
        for (int n : stack) result += n;
        return result;
    }
}
