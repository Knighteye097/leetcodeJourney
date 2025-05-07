class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] timeTaken = new double[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<position.length; i++) {
            map.put(position[i], i);
        }

        Arrays.sort(position);

        for(int i=0; i<n/2; i++) {
            int temp = position[i];
            position[i] = position[n-i-1];
            position[n-i-1] = temp;
        }

        for(int i=0; i<n; i++) {
            timeTaken[i] = ((double)target-position[i])/speed[map.get(position[i])];
        }

        int res = 0;
        Deque<Double> stack = new ArrayDeque<>();

        for(double time : timeTaken) {
            if (stack.isEmpty() || time > stack.peek()) {
                res++;
                stack.push(time);
            }
        }

        return res;
    }
}