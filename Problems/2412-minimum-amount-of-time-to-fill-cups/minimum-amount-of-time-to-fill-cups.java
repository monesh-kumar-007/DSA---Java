class Solution {
    public int fillCups(int[] amount) {
        
        //Gready Method...
        int sum = 0;
        int max = 0;

        for(int amt : amount) {
            max = Math.max(max, amt);
            sum += amt;
        }

        return Math.max(max, (sum + 1) / 2);

        //Sorting Method
        // int seconds = 0;
        
        // while(true) {
        //     Arrays.sort(amount); //min, mid, max

        //     if(amount[1] == 0) {
        //         break;
        //     }

        //     amount[1]--;
        //     amount[2]--;
        //     seconds++;
        // }

        // seconds += amount[2];

        // return seconds;
    }
}