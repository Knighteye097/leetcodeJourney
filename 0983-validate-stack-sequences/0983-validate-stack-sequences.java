class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();

        int poppedIndex = 0;

        for(int num : pushed) {
            stack.push(num); 

            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }

        return stack.isEmpty();
    }
}