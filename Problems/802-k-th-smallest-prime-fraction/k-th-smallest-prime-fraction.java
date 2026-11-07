class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        
        Comparator<int[]> c = (a, b) -> a[0] * b[1] - b[0] * a[1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(c);

        // Push the smallest possible fraction for each numerator
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new int[]{arr[i], arr[n - 1], i, n - 1});
        }

        // Pop k - 1 times
        for (int step = 1; step < k; step++) {
            int[] curr = pq.poll();
            int i = curr[2];
            int j = curr[3];
            
            // Push the next smallest fraction for this specific numerator
            if (j - 1 > i) {
                pq.offer(new int[]{arr[i], arr[j - 1], i, j - 1});
            }
        }
        
        // The k-th smallest is now at the root of the Min-Heap
        int[] res = pq.peek();
        return new int[]{res[0], res[1]};
    }
}