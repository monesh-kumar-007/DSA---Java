class Solution {
    public String[] findRelativeRanks(int[] scores) {
        
        int n = scores.length;

        // Max-Heap to get ranks in des. order
        Comparator<int[]> c = (a, b) -> Integer.compare(b[1], a[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(c);

        //Offering index and ith score to pq
        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{i, scores[i]});
        }

        String[] result = new String[n];
        int rank = 0;  //Tracking the rank order and assigning

        while(!pq.isEmpty()) {
            int[] score = pq.poll();
            rank++;

            if(rank == 1) {
                result[score[0]] = "Gold Medal";
            } else if (rank == 2) {
                result[score[0]] = "Silver Medal";
            } else if (rank == 3) {
                result[score[0]] = "Bronze Medal";
            } else {
                result[score[0]] = String.valueOf(rank);
            }
        }

        return result;
    }
}