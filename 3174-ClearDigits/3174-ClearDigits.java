// Last updated: 4/10/2025, 11:39:49 PM
class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(!stack.empty() && isCharacter(stack.peek()) && isNumber(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isCharacter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}