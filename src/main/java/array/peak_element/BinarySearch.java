package array.peak_element;

/**
 * Implements a solution to find a peak element using binary search.
 */
public class BinarySearch {

    /**
     * Finds a peak element in an array using a modified binary search algorithm.
     *
     * <p>The O(log n) time complexity requirement is met by applying binary search.
     * The algorithm works by comparing the middle element {@code nums[mid]} with
     * its right neighbor {@code nums[mid + 1]}.
     * <ul>
     *   <li>If {@code nums[mid] < nums[mid + 1]}, it implies that the array is
     *       "climbing" upwards. A peak must exist on the right side, so we
     *       discard the left half by setting {@code low = mid + 1}.</li>
     *   <li>If {@code nums[mid] >= nums[mid + 1]}, it implies that {@code nums[mid]}
     *       is either a peak itself or is on a "downward" slope. In this case,
     *       a peak is guaranteed to be in the left half (including {@code mid}),
     *       so we discard the right half by setting {@code high = mid}.</li>
     * </ul>
     * The loop continues until {@code low} and {@code high} converge, at which
     * point they identify the index of a peak element. This approach elegantly
     * handles all cases, including peaks at the array boundaries, due to the
     * problem's assumption that elements outside the array are negative infinity.
     *
     * @param nums The 0-indexed integer array to search.
     * @return The index of any peak element.
     */
    public int peakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            // Returning -1 or throwing an exception are valid strategies.
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }

        int low = 0;
        int high = nums.length - 1;

        // Binary search until the search space is reduced to a single element.
        while (low < high) {
            // Prevent potential integer overflow
            int mid = low + (high - low) / 2;

            // If the middle element is less than its right neighbor, a peak
            // must be in the right half of the array.
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Otherwise, the peak is in the left half, including mid itself.
                high = mid;
            }
        }

        // When the loop terminates, low == high, pointing to a peak element.
        return low;
    }
}