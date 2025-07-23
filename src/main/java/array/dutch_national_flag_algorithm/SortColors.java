package array.dutch_national_flag_algorithm;

/**
 * Implements the solution for the LeetCode problem "Sort Colors".
 *
 * <p>This class uses the Dutch National Flag algorithm to sort an array containing
 * only the integers 0, 1, and 2.
 *
 * @see <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 */
public class SortColors {

    /**
     * Sorts an array containing 0s, 1s, and 2s in-place using the
     * Dutch National Flag algorithm.
     *
     * <p>The array is partitioned into three sections in a single pass:
     * <ul>
     *   <li>Elements equal to 0 (red) are moved to the beginning.</li>
     *   <li>Elements equal to 1 (white) remain in the middle.</li>
     *   <li>Elements equal to 2 (blue) are moved to the end.</li>
     * </ul>
     * This is achieved with O(N) time complexity and O(1) space complexity.
     *
     * @param nums The array of integers (containing only 0, 1, or 2) to be sorted.
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // The loop must continue as long as the middle pointer has not passed the high pointer.
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // If the element is 0, swap it with the element at the low pointer.
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // If the element is 1, it's in the correct place. Move to the next element.
                    mid++;
                    break;
                case 2:
                    // If the element is 2, swap it with the element at the high pointer.
                    swap(nums, mid, high);
                    // Decrement high, but do not increment mid, because the new element at mid-
                    // needs to be processed.
                    high--;
                    break;
                default:
                    throw new IllegalStateException("Element not expected");
            }
        }
    }

    /**
     * Helper method to swap two elements in an array.
     *
     * @param nums The array in which to swap elements.
     * @param i    The index of the first element.
     * @param j    The index of the second element.
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}