class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        for (int row = 0; row < rows; row++) {
            int soldiers = countSoldiers(mat[row]);
            pq.offer(new int[] { soldiers, row });

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[1]; //returns two elements [soldiers, i]
        }

        return result;
    }

    public int countSoldiers(int[] row) {
        int low = 0, high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}