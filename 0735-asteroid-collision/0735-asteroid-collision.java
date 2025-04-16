class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        boolean isDestroyed = false;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int asteroid : asteroids) {
            isDestroyed = false;
            while(!stack.isEmpty() && asteroid < 0 && stack.peek()>0){
                if(stack.peek() < -asteroid) {
                    stack.pop();
                } else if(stack.peek() == -asteroid) {
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    isDestroyed = true;
                    break;
                }
            }

            if(!isDestroyed){
                stack.push(asteroid);
            }
        }

        int[] res = new int[stack.size()];

        for(int i=res.length-1; i>=0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
