// Last updated: 2/22/2025, 10:04:49 PM
class Solution {
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int balance = 0;

        int swaps = 0;

        int itr = 0;
        int secondItr = n-1;

        while(itr<secondItr) {
            if(arr[itr] == '[') {
                balance++;
            } else {
                balance--;
            }

            if(balance<0) {

                while(arr[secondItr] != '[') {
                    secondItr--;
                }

                swaps++;
                balance += 2;
                secondItr--;
            }

            itr++;
        }

        return swaps;
    }
}