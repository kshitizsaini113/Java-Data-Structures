/**
 * Provides solutions for the "Longest Harmonious Subsequence" problem (LeetCode 594).
 *
 * <p>As defined in the problem, a harmonious array is an array where the difference
 * between its maximum value and its minimum value is <strong>exactly 1</strong>.
 * The goal is to find the length of the longest such subsequence from a given
 * integer array.
 *
 * <p>A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements.
 *
 * <p>This package contains multiple implementations demonstrating different
 * algorithmic trade-offs:
 * <ul>
 *     <li>{@link array.longest_harmonious_subsequence.SlidingWindow}: An O(n log n) time, O(1) space solution.</li>
 *     <li>{@link array.longest_harmonious_subsequence.FrequencyMap}: An O(n) time, O(k) space solution.</li>
 * </ul>
 *
 * @version 1.0
 * @see <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">LeetCode 594: Longest Harmonious Subsequence</a>
 * @since 1.0
 */
package array.longest_harmonious_subsequence;