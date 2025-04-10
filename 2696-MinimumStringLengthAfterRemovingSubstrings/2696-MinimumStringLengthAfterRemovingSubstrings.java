// Last updated: 4/10/2025, 11:21:20 PM
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++) {
            char ch = 'X';
            if(!stack.empty()) ch = stack.peek();
            
            stack.push(arr[i]);
            if(isConditionMet(ch, arr[i])){
                stack.pop();
                stack.pop();
            }
        }

        return stack.size();
    }

    public boolean isConditionMet(char ch1, char ch2) {
        return (ch1 == 'A' && ch2 == 'B') || (ch1 == 'C' && ch2 == 'D');
    }
}