class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;

        if(k==0) {
            return new int[n];
        }

        int[] tempArr = new int[2*n];

        for(int i=0; i<n; i++) {
            tempArr[i]  = code[i];
            tempArr[i+n] = code[i];
        }

        if(k<0) {
            for(int i=n-1; i>=0; i--) {
                int sum = 0;
                int idx = (i+n) - 1;
                int itr = 0;

                while(itr > k) {
                    sum += tempArr[idx--];
                    itr--;
                }

                code[i] = sum;
            }
        }

        else {
            for(int i=0; i<n; i++) {
                int sum = 0;
                int idx = i+1;
                int itr = 0;
                while(itr<k){
                    sum += tempArr[idx++];
                    itr++;
                }

                code[i] = sum;
            }
        }

        return code;
    }
}