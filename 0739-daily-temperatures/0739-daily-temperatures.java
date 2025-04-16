class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = arr.length;
        int[] res = new int[n];

        for(int right = n-1; right>=0; right--) {
            while(!stack.isEmpty() && arr[right] >= arr[stack.peek()]){
                stack.pop();
            }

            res[right] = stack.isEmpty() ? 0 : stack.peek()-right;

            stack.push(right);
        }

        return res;
    }
}