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
 * @version 1.0
 * @see <a href="https://leetcode.com/problems/find-lucky-integer-in-an-array/">LeetCode 1394: Find Lucky Integer in an Array</a>
 * @since 1.0
 */
package array.lucky_integer;