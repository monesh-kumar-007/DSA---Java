class Solution {

    public static void expand(char[] chars, int left, int right, int[] result){

        while (left >= 0 && right < chars.length && chars[left] == chars[right]){
            left--;
            right++;
        }

        int currLen = right - left - 1;
        int maxLen = result[1] - result[0] + 1;

        if(currLen >= maxLen){
            result[0] = left + 1;
            result[1] = right - 1;
        }
    }
 
    public String longestPalindrome(String s) {
        int[] result = new int[]{0,0};
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){

            //Odd palindrome    
            expand(chars, i, i, result);

            //Even palindrome
            expand(chars, i, i+1, result);
        } 
        return s.substring(result[0], result[1] + 1);
    }
}
