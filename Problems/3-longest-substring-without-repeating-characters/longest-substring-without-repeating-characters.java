class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);

            while (set.contains(currChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(currChar);
            maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }
}