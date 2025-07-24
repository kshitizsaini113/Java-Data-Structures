/**
 * Provides implementations and explanations for Lower Bound and Upper Bound algorithms.
 *
 * <h2>Lower Bound and Upper Bound in Java</h2>
 *
 * <p>Lower Bound and Upper Bound are concepts derived from binary search, commonly
 * used in algorithms involving sorted arrays. They help find elements or their
 * potential insertion positions efficiently. These concepts are well-known
 * from the C++ Standard Template Library (STL) functions {@code std::lower_bound}
 * and {@code std::upper_bound}.
 *
 * <h3>Lower Bound</h3>
 *
 * <p>The <b>lower bound</b> algorithm finds the index of the <em>first element</em> in a
 * sorted array that is <b>greater than or equal to</b> a given value {@code x}.
 * <ul>
 *   <li>If {@code x} exists in the array, it returns the index of its first occurrence.</li>
 *   <li>If {@code x} does not exist, it returns the index where {@code x} would be
 *       inserted to maintain the sorted order.</li>
 *   <li>If all elements in the array are less than {@code x}, it returns the length of the array.</li>
 * </ul>
 * For example, in the array {@code [10, 20, 30, 30, 40, 50]}:
 * <ul>
 *     <li>The lower bound of {@code 30} is index 2.</li>
 *     <li>The lower bound of {@code 35} (a non-existent element) is index 4.</li>
 * </ul>
 *
 * <h3>Upper Bound</h3>
 *
 * <p>The <b>upper bound</b> algorithm finds the index of the <em>first element</em> in a
 * sorted array that is <b>strictly greater than</b> a given value {@code x}.
 * <ul>
 *   <li>It always returns an index pointing to an element that is larger than {@code x}.</li>
 *   <li>If all elements are less than or equal to {@code x}, it returns the length of the array.</li>
 * </ul>
 * For example, in the array {@code [10, 20, 30, 30, 40, 50]}:
 * <ul>
 *     <li>The upper bound of {@code 30} is index 4 (pointing to the element {@code 40}).</li>
 *     <li>The upper bound of {@code 50} is index 6 (the length of the array).</li>
 * </ul>
 *
 * <h3>LeetCode Application: Find First and Last Position of Element</h3>
 *
 * <p>A direct application of these concepts is LeetCode problem 34.
 * <blockquote>
 * Given an array of integers {@code nums} sorted in non-decreasing order, find the starting and ending
 * position of a given {@code target} value. If {@code target} is not found in the array, return {@code [-1, -1]}.
 * You must write an algorithm with O(log n) runtime complexity.
 * </blockquote>
 * This problem can be solved efficiently by finding the lower and upper bounds of the target value.
 * <ul>
 *     <li>The <b>starting position</b> is the {@code lower_bound(target)}.</li>
 *     <li>The <b>ending position</b> is {@code upper_bound(target) - 1}.</li>
 * </ul>
 * If the lower bound index is out of bounds or the element at that index does not match the target,
 * then the target does not exist in the array, and {@code [-1, -1]} should be returned.
 *
 * <p>For more details, see the problem on LeetCode:
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34. Find First and Last Position of Element in Sorted Array</a>
 *
 * <h3>Availability in Java</h3>
 *
 * <p>While C++ provides these functions directly, Java's standard library offers
 * building blocks.
 *
 * <h4>{@code java.util.Arrays.binarySearch()}</h4>
 *
 * <p>The {@code Arrays.binarySearch()} method can be used to find the <b>lower bound</b> (also known as the insertion point).
 * <ul>
 *   <li>If the key is found, it returns its index. Note that if there are duplicates, it does not guarantee which one it will find.</li>
 *   <li>If the key is not found, it returns {@code (-(insertion point) - 1)}.</li>
 * </ul>
 * The insertion point can be calculated from a negative return value {@code i} as {@code -i - 1}.
 * To reliably find the lower bound for an element that might have duplicates, a custom binary search implementation is often clearer.
 *
 * <p>There is no direct equivalent for <b>upper bound</b> in the standard library, so it
 * typically requires a custom binary search implementation. This package provides
 * such implementations for clarity and direct use.
 *
 * @see java.util.Arrays#binarySearch(int[], int)
 */
package array.lower_bound_upper_bound;