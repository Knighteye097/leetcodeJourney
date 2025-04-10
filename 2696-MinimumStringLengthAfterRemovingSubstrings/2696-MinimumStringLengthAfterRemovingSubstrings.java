// Last updated: 4/10/2025, 11:25:59 PM
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(!stack.empty() && isConditionMet(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    private boolean isConditionMet(char ch1, char ch2) {
        return (ch1 == 'A' && ch2 == 'B') || (ch1 == 'C' && ch2 == 'D');
    }
}