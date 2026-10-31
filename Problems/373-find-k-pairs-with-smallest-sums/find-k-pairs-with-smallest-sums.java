class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        Comparator<int[]> c = (a, b) -> {
            int sumA = a[0] + a[1];
            int sumB = b[0] + b[1];

            return Integer.compare(sumA, sumB);
        };  //Max Heap so that we can get smallest sum pairs by removing larger sum pairs

        PriorityQueue<int[]> pq = new PriorityQueue<>(c);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            result.add(List.of(pair[0], pair[1]));

            int nextIdx = pair[2] + 1;
            if (nextIdx < nums2.length) {
                pq.offer(new int[] {pair[0], nums2[nextIdx], nextIdx});
            }
        }

        return result;
    }
}