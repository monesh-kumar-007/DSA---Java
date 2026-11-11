class Solution {
    public int fillCups(int[] amount) {
        int sum = 0;
        int max = 0;

        for(int amt : amount) {
            max = Math.max(max, amt);
            sum += amt;
        }

        return Math.max(max, (sum + 1) / 2);
    }
}