class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = position.length;

        for(int i=0; i<n; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        for (int i = 0; i < n / 2; i++) {
        int temp = position[i];
        position[i] = position[n - 1 - i];
        position[n - 1 - i] = temp;
        }

       double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            int pos = position[i];
            int spd = map.get(pos);
            time[i] = (double)(target - pos) / spd;
        }

        int fleet = 0;
        double lastTime = 0.0;

        for (int i = 0; i < n; i++) {
            if (time[i] > lastTime) {
                fleet++;
                lastTime = time[i];
            }
        }

        return fleet;
    }
}