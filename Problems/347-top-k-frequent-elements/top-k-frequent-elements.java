class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        if(n == 1) {
            return nums;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Comparator<Integer> c = (a, b) -> freq.get(a) - freq.get(b);

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for(int num : freq.keySet()) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] =  pq.poll();
        }

        return result;
    }
}