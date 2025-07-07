/**
 * This package contains a solution for the LeetCode problem:
 * "1353. Maximum Number of Events That Can Be Attended".
 *
 * <p>Problem Statement:
 * You are given an array of events where {@code events[i] = [startDayi, endDayi]}.
 * Every event {@code i} starts at {@code startDayi} and ends at {@code endDayi}.
 *
 * <p>You can attend an event {@code i} on any day {@code d} where
 * {@code startDayi <= d <= endDayi}. You can only attend one event at any given day {@code d}.
 *
 * <p>The goal is to return the maximum number of events you can attend.
 *
 * <p><b>Constraints:</b>
 * <ul>
 *   <li>{@code 1 <= events.length <= 10^5}</li>
 *   <li>{@code events[i].length == 2}</li>
 *   <li>{@code 1 <= startDayi <= endDayi <= 10^5}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/">
 * 1353. Maximum Number of Events That Can Be Attended</a>
 */
package priorityqueue.maximum_events_that_can_be_attended;