// Last updated: 4/3/2025, 1:12:25 PM
class KthLargest {

    int size;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        

        this.minHeap = new PriorityQueue<>();

        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(this.minHeap.size() < this.size) {
            this.minHeap.offer(val);
        } else {
            if(this.minHeap.peek() < val) {
                this.minHeap.poll();
                this.minHeap.offer(val);
            }
        }

        return this.minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */