package array.lower_bound_upper_bound;

/**
 * Implements a solution for LeetCode problem 34: "Find First and Last Position of
 * Element in Sorted Array".
 *
 * <p>This class uses two modified binary search methods, {@code lowerBound} and
 * {@code upperBound}, to find the starting and ending indices of a target value
 * in a sorted array.
 *
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 */
public class FirstLastPosition {

    /**
     * Finds the starting and ending positions of a given target value in a sorted array.
     *
     * <p>This method orchestrates two binary searches: one to find the leftmost
     * occurrence (lower bound) and another to find the rightmost occurrence
     * (upper bound) of the target.
     *
     * @param nums   A non-decreasingly sorted array of integers.
     * @param target The value to search for.
     * @return An array of two integers {@code [start, end]} representing the
     *     first and last indices of the target. If the target is not found,
     *     it returns {@code [-1, -1]}.
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = lowerBound(nums, target);
        // If lowerBound doesn't find the target, we can skip the second search.
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = upperBound(nums, target);
        return new int[]{first, last};
    }

    /**
     * Finds the leftmost index of a target value using binary search.
     *
     * <p>This search is modified to continue searching the left half of the array
     * even after finding a match, ensuring it locates the very first occurrence.
     *
     * @param nums   The sorted array to search.
     * @param target The value to find.
     * @return The index of the first occurrence of the target, or -1 if not found.
     */
    private int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents potential overflow
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                answer = mid; // Found a potential answer, try to find an earlier one
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    /**
     * Finds the rightmost index of a target value using binary search.
     *
     * <p>This search is modified to continue searching the right half of the array
     * even after finding a match, ensuring it locates the very last occurrence.
     *
     * @param nums   The sorted array to search.
     * @param target The value to find.
     * @return The index of the last occurrence of the target, or -1 if not found.
     */
    private int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents potential overflow
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] == target) {
                answer = mid; // Found a potential answer, try to find a later one
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}