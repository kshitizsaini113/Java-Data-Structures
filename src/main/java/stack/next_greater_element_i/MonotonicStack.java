package stack.next_greater_element_i;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Solves the "Next Greater Element I" problem using a Monotonic Stack and a HashMap.
 *
 * <p>This approach is highly efficient because it avoids repeated searches. It works in
 * two main phases:
 * <ol>
 *   <li><b>Pre-computation:</b> It iterates through the {@code nums2} array from right
 *       to left, using a monotonic stack to find the next greater element for every
 *       number in {@code nums2}. These results are stored in a map for instant retrieval.</li>
 *   <li><b>Result Generation:</b> It then iterates through {@code nums1} and uses the
 *       pre-computed map to look up the next greater element for each number, building
 *       the final result array.</li>
 * </ol>
 *
 * <p><b>Complexity:</b>
 * <ul>
 *   <li>Time: O(nums1.length + nums2.length), as each element in both arrays is
 *       processed once.</li>
 *   <li>Space: O(nums2.length) to store the map and the stack.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/next-greater-element-i/">LeetCode 496: Next Greater Element I</a>
 */
public class MonotonicStack {

    /**
     * Finds the next greater element in {@code nums2} for each element in {@code nums1}.
     *
     * @param nums1 A subset of {@code nums2} for which to find the next greater elements.
     * @param nums2 The array in which to search for the next greater elements.
     * @return An array of the same length as {@code nums1}, where each element is the
     * next greater element, or -1 if none exists.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store {element -> nextGreaterElement} for nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Monotonic stack to keep track of elements in decreasing order
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. Pre-compute next greater elements for all numbers in nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // The top of the stack is the next greater element. If stack is empty, there is none.
            nextGreaterMap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());

            // Push the current element onto the stack for future comparisons
            stack.push(nums2[i]);
        }

        // 2. Build the result array using the pre-computed map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}