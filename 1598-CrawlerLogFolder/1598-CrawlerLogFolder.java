// Last updated: 4/3/2025, 11:37:04 AM
class Solution {
    public int minOperations(String[] logs) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for(String str : logs) {
            if(!str.equalsIgnoreCase("./") && !str.equalsIgnoreCase("../")) {
                stack.push(i++);
            } else if(str.equalsIgnoreCase("../") && !stack.isEmpty()) {
                stack.pop();
                i--;
            }
        }

        return stack.isEmpty() ? 0 : stack.size();
    }
}