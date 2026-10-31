class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for(int[] rows : matrix) {
            for(int e : rows) {
                pq.offer(e);

                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}