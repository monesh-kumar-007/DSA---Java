package Algorithms.Searching;

public class LinearSearch {
    public static boolean  linear(int[] nums, int target) {
        for(int i : nums){
            if(i == target){
                return true;
            }
        }
        return false;
    }
}