// Last updated: 3/28/2025, 11:55:14 PM
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = findValidIndex(arr, x);
        int left = right-1;

        while(k-->0) {
            if(left < 0) {
                right++;
            } else if(right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)) {
                left--;
            } else {
                right++;
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i=left+1; i<right; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    private int findValidIndex(int[] arr, int target) {
        int low = 0, high = arr.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return low;
    }
}