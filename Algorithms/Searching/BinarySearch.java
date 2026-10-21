    package Algorithms.Searching;

import java.util.Arrays;

public class BinarySearch {
        public static boolean binary(int[] arr, int target) {

            Arrays.sort(arr);

            int left = 0;
            int right = arr.length - 1;

            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(arr[mid] == target) {
                    return true;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }