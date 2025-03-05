// Last updated: 3/5/2025, 10:41:02 PM
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int last = people.length - 1;
        int start = 0;

        int res = 0;

        while(start <= last) {
            if(people[last] + people[start] <= limit) {
                start++;
            }

            res++;
            last--;
        }

        return res;
    }
}