class Solution {
    public int maxProduct(int[] nums) {

        // if (nums.length == 2) {
        //     return (nums[0] - 1) * (nums[1] - 1);
        // }

        // Comparator<Integer> c = (a, b) -> {
        //     return a - b;
        // };

        // PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        // for (int num : nums) {

        //     pq.offer(num);

        //     if (pq.size() > 2) {
        //         pq.poll();
        //     }
        // }

        // int res = 1;
        // while (!pq.isEmpty()) {
        //     res *= pq.poll() - 1;
        // }

        // return res;

        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}