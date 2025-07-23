/**
 * Provides an implementation of the Dutch National Flag algorithm.
 *
 * <h2>Dutch National Flag Algorithm</h2>
 *
 * <p>The Dutch National Flag algorithm, also known as 3-way partitioning, is an
 * efficient, in-place sorting algorithm for an array containing three distinct
 * values. It was designed by Edsger W. Dijkstra. The algorithm's goal is to
 * rearrange the elements into three groups based on their value.
 *
 * <p>The core idea is to maintain four sections within the array using three
 * pointers: {@code low}, {@code mid}, and {@code high}:
 * <ol>
 *     <li><b>Region 1 (0 to low-1):</b> Contains all elements with value 0.</li>
 *     <li><b>Region 2 (low to mid-1):</b> Contains all elements with value 1.</li>
 *     <li><b>Region 3 (mid to high):</b> The unprocessed, unknown region.</li>
 *     <li><b>Region 4 (high+1 to n-1):</b> Contains all elements with value 2.</li>
 * </ol>
 * The algorithm iterates with the {@code mid} pointer as long as it is less than
 * or equal to the {@code high} pointer, processing the element at {@code arr[mid]}:
 * <ul>
 *     <li>If {@code arr[mid]} is 0, it's swapped with the element at {@code arr[low]}.
 *         Both {@code low} and {@code mid} pointers are then incremented.</li>
 *     <li>If {@code arr[mid]} is 1, it's in the correct place, so only the {@code mid}
 *         pointer is incremented.</li>
 *     <li>If {@code arr[mid]} is 2, it's swapped with the element at {@code arr[high]}.
 *         The {@code high} pointer is then decremented. The {@code mid} pointer is
 *         not incremented because the new element at {@code mid} needs to be processed.</li>
 * </ul>
 * This process continues until the {@code mid} pointer crosses the {@code high} pointer,
 * resulting in a sorted array with O(N) time complexity and O(1) space complexity.
 *
 * <h3>LeetCode Problem: Sort Colors</h3>
 *
 * <p>A classic application of this algorithm is the "Sort Colors" problem on LeetCode.
 * The problem statement is as follows:
 * <blockquote>
 * Given an array {@code nums} with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in the
 * order red, white, and blue. We will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue, respectively. You must solve this problem
 * without using the library's sort function.
 * </blockquote>
 * This problem maps directly to the Dutch National Flag algorithm, where:
 * <ul>
 *     <li>Red = 0</li>
 *     <li>White = 1</li>
 *     <li>Blue = 2</li>
 * </ul>
 * For more details, see the problem on LeetCode:
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Dutch_national_flag_problem">Dutch national flag problem on Wikipedia</a>
 */
package array.dutch_national_flag_algorithm;