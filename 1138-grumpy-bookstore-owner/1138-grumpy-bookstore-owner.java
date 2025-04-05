class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int extra = 0;
        int n = customers.length;
        int alreadySatisfied = 0;
        int maxCustomers = 0;

        for(int i=0; i<minutes; i++) {
            if(grumpy[i] == 1) extra += customers[i];
        }

        maxCustomers = Math.max(extra, maxCustomers);

        for(int i=minutes; i<n; i++) {
            if(grumpy[i-minutes] == 1) extra -= customers[i-minutes];

            if(grumpy[i] == 1) extra += customers[i];

            maxCustomers = Math.max(extra, maxCustomers);
        }

        for(int i=0; i<n; i++) {
            if(grumpy[i] == 0) alreadySatisfied += customers[i];
        }

        return maxCustomers + alreadySatisfied;
    }
}