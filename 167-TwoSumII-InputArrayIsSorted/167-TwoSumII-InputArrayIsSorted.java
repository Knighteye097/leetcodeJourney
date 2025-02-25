class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length-1;

        int[] res = new int[2];
 
        while(first < last) {
            int sum = numbers[first] + numbers[last];

            if(target == sum) {
                res[0] = first+1;
                res[1] = last+1;
                return res;
            } else if(target < sum) {
                last--;
            } else {
                first++;
            }
        }

        return res;
    }
}