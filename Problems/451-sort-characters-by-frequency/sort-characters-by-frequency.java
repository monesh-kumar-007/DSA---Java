class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()) {
            freq.merge(ch, 1, Integer::sum);
        }

        //Max-Heap -> sorted by freq. in desceding order...
        Comparator<Character> c = (ch1, ch2) -> {
            return freq.get(ch2) - freq.get(ch1);
        };

        PriorityQueue<Character> pq = new PriorityQueue<>(c);

        //Offer all unique chars... Since we have only 62 unique chars... O(N)
        pq.addAll(freq.keySet());


        StringBuffer sb = new StringBuffer(s.length());

        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int count = freq.get(ch);

            for(int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}