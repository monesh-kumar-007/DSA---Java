class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Integer> c = (a, b) -> b - a; //Map-Heap so that we can remove larger elements...
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for(int[] rows : matrix) {
            for(int e : rows) {
                pq.offer(e);
                
                //Removing excessive element greater than k..
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }
        //Returning kth smallest element....
        return pq.peek();
    }
}