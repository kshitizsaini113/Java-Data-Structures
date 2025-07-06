/**
 * Provides a solution for the "Next Greater Element I" problem.
 *
 * <p>The problem is defined as follows: Given two distinct integer arrays, {@code nums1} and
 * {@code nums2}, where {@code nums1} is a subset of {@code nums2}, find the next greater
 * element in {@code nums2} for each element in {@code nums1}. The "next greater element"
 * of a number {@code x} is the first number to its right in the same array that is
 * larger than {@code x}. If no such element exists, the answer is -1.
 *
 * <h3>Core Implementation Strategy</h3>
 *
 * <p>A naive approach of searching for each element of {@code nums1} in {@code nums2} and then
 * searching for its next greater element would be inefficient, leading to a complexity of
 * roughly O(N*M).
 *
 * <p>A much more optimal, two-pass approach is used here:
 * <ol>
 *   <li><b>Pre-computation:</b> First, we process the larger array, {@code nums2}, to find the
 *       next greater element for <em>every</em> number within it. This is efficiently
 *       achieved using a <strong>Monotonic Stack</strong>. The results are stored in a
 *       {@code HashMap} mapping each number to its next greater element.</li>
 *   <li><b>Querying:</b> Second, we iterate through the smaller array, {@code nums1}. For each
 *       number, we perform a quick O(1) lookup in the pre-computed map to find its
 *       corresponding next greater element.</li>
 * </ol>
 *
 * <p>This strategy reduces the overall time complexity to O(nums1.length + nums2.length),
 * as each array is traversed only once.
 *
 * @version 1.0
 * @see <a href="https://leetcode.com/problems/next-greater-element-i/">LeetCode 496: Next Greater Element I</a>
 * @since 1.0
 */
package stack.next_greater_element_i;