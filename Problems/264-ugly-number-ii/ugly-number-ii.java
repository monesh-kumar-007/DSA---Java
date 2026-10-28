class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        pq.offer(1L);
        seen.add(1L);

        int[] primes = {2,3,5};
        long curr = 1L;

        for(int i = 0; i < n; i++) {
            curr = pq.poll();

            for(int num : primes) {
                long next = curr * num;

                if(seen.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return (int) curr;
    }
}