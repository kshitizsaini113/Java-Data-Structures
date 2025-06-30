package array.longest_harmonious_subsequence;

import java.util.Arrays;

/**
 * Solves the Longest Harmonious Subsequence problem using a sliding window approach.
 * <p>
 * A harmonious array is an array where the difference between its maximum value
 * and its minimum value is exactly 1.
 */
public class SlidingWindow {

    /**
     * Finds the length of the longest harmonious subsequence in an integer array.
     * <p>
     * This method first sorts the array, which allows for an efficient sliding
     * window (two-pointer) approach. The window expands from the right and
     * shrinks from the left to find the longest valid subsequence where the
     * difference between the maximum and minimum element is exactly 1.
     * <p>
     * <b>Time Complexity:</b> O(n log n), where n is the number of elements in {@code nums}.
     * The complexity is dominated by the initial sorting of the array. The subsequent
     * sliding window scan is O(n).
     * <p>
     * <b>Space Complexity:</b> O(log n) or O(1). The space used by the sorting
     * algorithm in Java for primitives is typically O(log n) for the recursion stack.
     * If sorting is considered in-place, the space complexity is O(1) as we only use
     * a few extra variables.
     *
     * @param nums The input integer array.
     * @return The length of the longest harmonious subsequence. Returns 0 if no such subsequence exists.
     */
    public int findLHS(int[] nums) {
        // A null or empty array cannot have a harmonious subsequence.
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // First, sort the array to group similar numbers together.
        // This is essential for the sliding window approach to work correctly.
        Arrays.sort(nums);

        // 'index' represents the start (left pointer) of the sliding window.
        int index = 0;
        int maxLength = 0;

        // 'i' represents the end (right pointer) of the sliding window.
        for (int i = 0; i < nums.length; i++) {
            // While the difference between the end and start of the window is greater than 1,
            // shrink the window from the left by moving the 'index' pointer to the right.
            while (nums[i] - nums[index] > 1) {
                index++;
            }

            // If the difference between the end and start of the window is exactly 1,
            // we have found a harmonious subsequence.
            if (nums[i] - nums[index] == 1) {
                // Calculate the length of the current harmonious subsequence and update
                // maxLength if the current one is longer.
                maxLength = Math.max(maxLength, i - index + 1);
            }
        }
        return maxLength;
    }
}