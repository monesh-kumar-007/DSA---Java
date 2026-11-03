class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        if(n <= 1) {
            return barcodes;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : barcodes) {
            freq.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        int i = 0;
        int[] res = new int[n];

        for(Map.Entry<Integer, Integer> entry : list) {
            int code = entry.getKey();
            int count = entry.getValue();

            while(count > 0) {
                res[i] = code;
                count--;
                i += 2;

                if(i >= n) {
                    i = 1;
                }
            }
        }

        return res;
    }
}