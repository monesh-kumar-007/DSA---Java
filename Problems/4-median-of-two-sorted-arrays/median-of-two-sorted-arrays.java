class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int[] merged = new int[n];

        int i = 0, j = 0, k = 0;

        // Walk through both arrays and pick the smaller element
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Fill in remaining elements
        while (i < n1) {
            merged[k++] = nums1[i++];
        }

        while (j < n2) {
            merged[k++] = nums2[j++];
        }

        // Median Logic
        if (n % 2 != 0) {
            return merged[n / 2];
        }
        return (merged[n / 2] + merged[n / 2 - 1]) / 2.0;
    }
}