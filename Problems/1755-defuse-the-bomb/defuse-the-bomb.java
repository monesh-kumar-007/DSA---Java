class Solution {
    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] decrypted = new int[n];

        if(k == 0) {
            return decrypted;
        }

        for(int i = 0; i < n; i++) {
            if(k > 0) {
                for(int step = 1; step <= k; step++) 
                    decrypted[i] += code[(i + step) % n];
            } else {
                for(int step = 1; step <= -k; step++) 
                    decrypted[i] += code[(i - step + n) % n];
            }
        }
        return decrypted;
    }

    
}