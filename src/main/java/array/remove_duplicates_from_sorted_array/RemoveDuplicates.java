package array.remove_duplicates_from_sorted_array;

/**
 * Provides a method to remove duplicate elements from a sorted integer array
 * in-place such that each unique element appears only once.
 *
 * <p>The method preserves the relative order of elements and returns the
 * number of unique elements. The first {@code k} positions of the array
 * will contain the unique elements in sorted order.</p>
 *
 * <p>Constraints:
 * <ul>
 *   <li>The input array must be sorted in non-decreasing order.</li>
 *   <li>The operation is performed in-place with O(1) extra space.</li>
 * </ul>
 * </p>
 */
public class RemoveDuplicates {

    /**
     * Removes duplicates from a sorted integer array in-place.
     *
     * <p>After execution:
     * <ul>
     *   <li>The first {@code k} elements of {@code nums} contain unique values.</li>
     *   <li>The remaining elements beyond index {@code k - 1} are unspecified.</li>
     * </ul>
     * </p>
     *
     * @param nums a sorted array of integers in non-decreasing order
     * @return the number of unique elements in the array
     * @throws NullPointerException if {@code nums} is {@code null}
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return ++idx;
    }
}
