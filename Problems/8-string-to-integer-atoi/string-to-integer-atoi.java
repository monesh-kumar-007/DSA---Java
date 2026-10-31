class Solution {
    public int myAtoi(String s) {
        int sign = 1, result = 0, i = 0;
        int n = s.length();
        
        //whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while(i < n && Character.isDigit(s.charAt(i))){
            int digit =  s.charAt(i) - '0';

            //Checking if it is overflowing....
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return (int) (result * sign);
    }
    
}