/**
 * Provides an implementation for the "Find Pairs With a Certain Sum" problem.
 *
 * <p>The problem requires designing a data structure that manages two integer arrays,
 * {@code nums1} and {@code nums2}, and supports two types of operations:
 * <ol>
 *   <li><b>Add:</b> Update an element in {@code nums2} by adding a positive value to it.</li>
 *   <li><b>Count:</b> Count the number of pairs {@code (i, j)} such that
 *       {@code nums1[i] + nums2[j]} equals a given total.</li>
 * </ol>
 *
 * <h3>Core Implementation Strategy</h3>
 *
 * <p>A naive approach to the {@code count} operation would be to iterate through both
 * arrays for every query, resulting in an O(N * M) time complexity, which is too slow.
 *
 * <p>A much more efficient strategy is to pre-process one of the arrays into a frequency
 * map (e.g., a {@code HashMap}). Since {@code nums2} is the array that gets modified, it is
 * the ideal candidate for this map. By storing the counts of each number in {@code nums2},
 * the {@code count} operation can be optimized significantly.
 *
 * <p>The logic is as follows:
 * <ul>
 *   <li><b>Initialization:</b> Store {@code nums1} as is. Create a frequency map from
 *       {@code nums2} to count occurrences of each number.</li>
 *   <li><b>{@code count(total)}:</b> Iterate through the static {@code nums1} array. For each
 *       number {@code n1} in {@code nums1}, calculate the required complement {@code target = total - n1}.
 *       Look up how many times {@code target} appears in the {@code nums2} frequency map and
 *       add that count to the total. This reduces the complexity of a count query to O(length of nums1).</li>
 *   <li><b>{@code add(index, val)}:</b> When a value in {@code nums2} is updated, the frequency
 *       map must also be updated. Decrement the count of the old value ({@code nums2[index]})
 *       and increment the count of the new value ({@code nums2[index] + val}). This keeps the
 *       map in sync with the array.</li>
 * </ul>
 *
 * @version 1.0
 * @see <a href="https://leetcode.com/problems/finding-pairs-with-a-certain-sum">LeetCode 1865: Find Pairs With a Certain Sum</a>
 * @since 1.0
 */
package array.pairs_with_certian_sum;