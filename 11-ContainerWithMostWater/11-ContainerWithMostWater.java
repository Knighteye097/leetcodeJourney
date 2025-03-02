class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int first = 0;
        int last = n-1;

        while(first < last) {
            int currLength = Math.min(height[first], height[last]);
            int currBreadth = (last-first);

            System.out.println(currLength + " " + currBreadth);
            int currArea = currLength * currBreadth;

            maxArea = Math.max(maxArea, currArea);

            if(height[first]<height[last]) {
                first++;
            } else if(height[first] > height[last]){
                last--;
            } else {
                first++;
                last--;
            }
        }

        return maxArea;
    }
}