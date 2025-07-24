/**
 * Provides solutions for finding a peak element in an array.
 *
 * <h2>Problem: Find Peak Element</h2>
 *
 * <p>A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array {@code nums}, the goal is to find a peak
 * element and return its index. If the array contains multiple peaks, returning
 * the index to any of the peaks is acceptable.
 *
 * <p>A key condition is that we can imagine {@code nums[-1] = nums[n] = -∞}.
 * This means an element at the edge of the array only needs to be greater than
 * its single adjacent neighbor to be considered a peak. This condition also
 * guarantees that a peak element always exists.
 *
 * <p>The solution must run in O(log n) time complexity.
 *
 * <p></p>For more details, see the problem on LeetCode:
 * <a href="https://leetcode.com/problems/find-peak-element/">162. Find Peak Element</a>
 */
package array.peak_element;