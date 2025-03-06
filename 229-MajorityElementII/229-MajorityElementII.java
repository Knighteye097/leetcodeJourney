// Last updated: 3/6/2025, 9:53:34 PM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Using Boyer-Moore Voting Algorithm

        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;

        for(int num : nums) {
            if(count1 ==0 && num != candidate2) {
                candidate1 = num;
            } else if(count2 == 0 && num != candidate1) {
                candidate2 = num;
            }

            if(candidate1 == num) {
                count1++;
            } else if(candidate2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> res = new ArrayList<>();

        if(count1 > nums.length/3) {
            res.add(candidate1);
        }

        if(count2 > nums.length/3) {
            res.add(candidate2);
        }

        return res;
    }
}