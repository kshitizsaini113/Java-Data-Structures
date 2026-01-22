package array.largest_elements_in_array;

/**
 * Utility class to find largest and second-largest elements in an array.
 */
public class LargestElement {

    /**
     * Finds the largest element in the given array.
     *
     * @param nums The input array of integers.
     * @return The largest integer in the array.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public int maxElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int max = Integer.MIN_VALUE;
        for (var num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Finds the second-largest element in the given array.
     * Returns -1 if the second-largest element does not exist (e.g., array size < 2 or all elements are equal).
     *
     * @param nums The input array of integers.
     * @return The second-largest integer in the array, or -1 if it doesn't exist.
     */
    public int secondLargestElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (var num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            for (var num : nums) {
                if (num == secondMax) {
                    return secondMax;
                }
            }
            return -1;
        }

        return secondMax;
    }
}
