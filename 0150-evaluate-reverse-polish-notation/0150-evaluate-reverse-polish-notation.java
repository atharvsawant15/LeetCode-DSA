class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int a = stack.pop();
                int b = stack.pop();
                int c = 0;

                switch (token) {
                    case "+":
                        c = b + a;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = b * a;
                        break;
                    case "/":
                        c = b / a;
                        break;
                }

                stack.push(c);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
