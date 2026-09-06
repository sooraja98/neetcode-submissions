class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ']' || ch == ')' || ch == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char ch1 = stack.pop();

                if (ch == ']' && ch1 != '[') {
                    return false;
                }

                if (ch == ')' && ch1 != '(') {
                    return false;
                }

                if (ch == '}' && ch1 != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}