class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>
        ((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            
            pq.add(new int[] { entry.getValue(), entry.getKey() });

            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll()[1];
        }

        return res;
    }
}