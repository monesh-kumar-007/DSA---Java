class Solution {
    public int lastStoneWeight(int[] stones) {

        Comparator<Integer> c = (a, b) -> b - a; //for max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                int newWeight = y - x;
                pq.offer(newWeight);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}