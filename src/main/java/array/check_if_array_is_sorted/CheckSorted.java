package array.check_if_array_is_sorted;

/**
 * Utility class that provides a method to check
 * whether an integer array is sorted in non-decreasing (ascending) order.
 */
public class CheckSorted {

    /**
     * Checks whether the given array is sorted in ascending order.
     *
     * <p>An array is considered sorted if:
     * <ul>
     *   <li>It is {@code null}</li>
     *   <li>It has zero or one element</li>
     *   <li>Every element is less than or equal to the next element</li>
     * </ul>
     *
     * @param nums the array of integers to check
     * @return {@code true} if the array is sorted or null; {@code false} otherwise
     */
    public boolean checkSorted(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}