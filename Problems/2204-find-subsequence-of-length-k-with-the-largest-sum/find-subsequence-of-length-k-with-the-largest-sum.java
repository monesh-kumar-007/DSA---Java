class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Min-Heap : Inserting each element(value) with its resp. index and sorting it based on value in asc.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});

            if(pq.size() > k) {
                pq.poll();
            }
        }

        // Now, sorting it with the index to maintain the order...
        List<int[]> picked = new ArrayList<>(pq);
        picked.sort((a, b) -> Integer.compare(a[1], b[1]));


        // Finally, storing only the values into the array (order maintained!!!)...
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = picked.get(i)[0];
        }

        return result;

    }
}