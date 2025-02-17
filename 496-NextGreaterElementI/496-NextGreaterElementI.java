class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> rightGreaterList = getRightGreaterList(nums2);
        Collections.reverse(rightGreaterList);
        HashMap<Integer, Integer> resMap = new HashMap<>();

        for(int i=0; i<nums2.length; i++) {
            resMap.put(nums2[i], rightGreaterList.get(i));
        }

        int[] res = new int[nums1.length];

        for(int i=0; i<nums1.length; i++) {
            res[i] = resMap.get(nums1[i]);
        }

        return res;
    }

    private ArrayList<Integer> getRightGreaterList(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;

        for(int i=length-1; i>=0; i--) {
            while(!stack.empty() && stack.peek()<nums[i]){
                stack.pop();
            }

            if(stack.empty()){
                res.add(-1);
            } else {
                res.add(stack.peek());
            }

            stack.push(nums[i]);
        }

        return res;
    }
}