/**
 * Provides solutions for the "Find the Original Typed String I" problem (LeetCode 3330).
 * <p>
 * The problem describes a scenario where a user types a string but may
 * accidentally press a key for too long, resulting in a character being typed
 * multiple times. This long-press action is known to have occurred <strong>at most once</strong>.
 * <p>
 * Given the final string displayed on the screen, the goal is to determine the
 * total number of possible original strings the user might have intended to type.
 * <p>
 * This package contains an implementation for this problem:
 * <ul>
 *     <li>{@link string.original_typed_string_one.Iteration}: An O(n) time, O(1) space solution that iterates through the string to count valid possibilities.</li>
 * </ul>
 *
 * @version 1.0
 * @see <a href="https://leetcode.com/problems/find-the-original-typed-string-i/">LeetCode 3330: Find the Original Typed String I</a>
 * @since 1.0
 */
package string.original_typed_string_one;