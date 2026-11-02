class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //COunt frequencies for each word
        Map<String, Integer> freq = new HashMap<>();

        //Merge counts the freq. of a word, more concise than getOrDefault...
        for(String word : words) {
            freq.merge(word, 1, Integer::sum);
        }

        //Comparing two words with their freq., -> Min-Heap 
        //if not, comparing it by their lexico... -> Max-Heap
        Comparator<String> c = (w1, w2) -> {
            int freq1 = freq.get(w1);
            int freq2 = freq.get(w2);

            if(freq1 != freq2) {
                return Integer.compare(freq1, freq2);
            }
            return w2.compareTo(w1);
        };

        PriorityQueue<String> pq = new PriorityQueue<>(c);

        for(String word : freq.keySet()) {
            pq.offer(word);
            
            //Having only the size of k in pq..
            if(pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        Collections.reverse(result);

        return result;
    }
}