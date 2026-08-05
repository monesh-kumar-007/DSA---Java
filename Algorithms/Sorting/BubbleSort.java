package Algorithms.Sorting;

public class BubbleSort {
    public static int[] bubble(int[] nums){
        int size = nums.length;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int n : nums){
                System.out.print(n + " ");
            }
            System.out.println();
        return nums;
    }
}
