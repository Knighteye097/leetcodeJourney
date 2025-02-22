// Last updated: 2/22/2025, 10:00:27 PM
class Solution {
    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int openingBrackets = 0;
        int closingBrackets = 0;

        int swaps = 0;

        int itr = 0;
        int secondItr = n-1;

        while(itr<secondItr) {
            if(arr[itr] == '[') {
                openingBrackets++;
            } else {
                closingBrackets++;
            }

            if(closingBrackets>openingBrackets) {

                while(arr[secondItr] != '[') {
                    secondItr--;
                }

                char temp = arr[itr];
                arr[itr] = arr[secondItr];
                arr[secondItr] = temp;

                swaps++;
                openingBrackets++;
                closingBrackets--;
                secondItr--;
            }

            itr++;
        }

        return swaps;
    }
}