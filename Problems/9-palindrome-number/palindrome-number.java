class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x%10 == 0))
            return false;
        
        int temp = x, rev = 0;

        while (temp > rev){
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }

        return temp == rev || temp == rev / 10;

    }
}