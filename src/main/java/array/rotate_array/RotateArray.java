package array.rotate_array;

/**
 * Utility class to rotate an integer array to the right by a given number of steps.
 *
 * <p>The rotation is performed in-place using the array reversal technique,
 * achieving O(n) time complexity and O(1) extra space.</p>
 */
public class RotateArray {

    /**
     * Rotates the given array to the right by {@code k} steps.
     *
     * <p>If {@code k} is greater than the array length, it is reduced using
     * the modulo operation.</p>
     *
     * @param nums the array to be rotated
     * @param k the number of steps to rotate the array to the right;
     *          must be non-negative
     * @throws ArithmeticException if the array is empty
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    /**
     * Reverses the elements of the array between the given indices.
     *
     * @param nums the array whose elements are to be reversed
     * @param startIdx the starting index of the range (inclusive)
     * @param lastIdx the ending index of the range (inclusive)
     */
    private void reverse(int[] nums, int startIdx, int lastIdx) {
        while (startIdx < lastIdx) {
            int temp = nums[startIdx];
            nums[startIdx] = nums[lastIdx];
            nums[lastIdx] = temp;
            startIdx++;
            lastIdx--;
        }
    }
}
