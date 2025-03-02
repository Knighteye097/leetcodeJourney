// Last updated: 3/2/2025, 10:17:09 PM
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int first = 0;
        int last = n-1;

        while(first < last) {
            maxArea = Math.max(maxArea, (findMin(height[first], height[last]) * (last-first)));

            if(height[first]<height[last]) {
                first++;
            } else {
                last--;
            }
        }

        return maxArea;
    }

    private int findMin(int num1, int num2) {
        if(num1 <= num2) {
            return num1;
        } 
        
        return num2;
    }
}