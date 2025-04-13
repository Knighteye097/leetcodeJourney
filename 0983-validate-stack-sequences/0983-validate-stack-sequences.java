class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = pushed.length;

        int left = 0;

        for(int num : pushed) {
            stack.push(num); 

            while(!stack.isEmpty() && left<n && stack.peek() == popped[left]) {
                stack.pop();
                left++;
            }
        }

        return stack.isEmpty();
    }
}