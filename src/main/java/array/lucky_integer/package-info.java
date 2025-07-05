/**
 * Provides solutions for the "Find Lucky Integer in an Array" problem.
 *
 * <p>The problem is defined as follows: Given an array of integers {@code arr},
 * a "lucky integer" is an integer whose frequency in the array is equal to its value.
 *
 * <p>The goal of the implementations in this package is to find and return the
 * largest lucky integer from the input array. If no such integer exists, the
 * implementations will return -1.
 *
 * <p>For example, in the array {@code [2, 2, 3, 4]}, the number 2 is a lucky
 * integer because it appears 2 times. In {@code [1, 2, 2, 3, 3, 3]}, both 1 and 3
 * are lucky integers, and the correct return value would be 3, as it is the largest.
 *
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>{@code 1 <= arr.length <= 500}</li>
 *   <li>{@code 1 <= arr[i] <= 500}</li>
 * </ul>
 *
 * <h3>Implementation Approaches:</h3>
 *
 * <p>This package provides multiple solutions, each demonstrating different trade-offs:
 * <ul>
 *   <li><b>{@link array.lucky_integer.FrequencyArray FrequencyArray}</b>: The most optimal
 *       solution given the problem's constraints. It uses a simple {@code int[]} as a
 *       direct-access frequency map, offering O(N) time and O(1) space complexity.</li>
 *   <li><b>{@link array.lucky_integer.FrequencyMap FrequencyMap} (using HashMap)</b>: A flexible,
 *       general-purpose solution that works for any range of input numbers. It provides
 *       O(N) time complexity but has higher memory overhead than the array approach.</li>
 *   <li><b>{@link array.lucky_integer.FrequencyTreeMap FrequencyTreeMap}</b>: An approach that uses a
 *       sorted map ({@code TreeMap}) to simplify finding the largest lucky number. The
 *       first lucky number found is guaranteed to be the answer, at the cost of a
 *       slightly higher O(N * log U) time complexity.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/find-lucky-integer-in-an-array/">LeetCode 1394: Find Lucky Integer in an Array</a>
 * @since 2.0
 * @version 1.0
 */
package array.lucky_integer;