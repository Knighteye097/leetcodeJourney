// Last updated: 4/10/2025, 11:38:08 PM
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

        return stack.stream().map(ch -> ch.toString()).collect(Collectors.joining(""));
    }

    private boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isCharacter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}