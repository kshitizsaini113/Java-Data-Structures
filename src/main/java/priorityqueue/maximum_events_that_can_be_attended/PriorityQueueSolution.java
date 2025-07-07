package priorityqueue.maximum_events_that_can_be_attended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solves the "Maximum Number of Events That Can Be Attended" problem using a greedy approach
 * with a min-priority queue.
 *
 * <p>The core idea is to iterate through each day and, on any given day, attend the available
 * event that will end the soonest. This greedy choice ensures that we leave future days open
 * for events that last longer.
 *
 * <p><b>Algorithm:</b>
 * <ol>
 *   <li>Sort the events by their start day. This allows us to process events chronologically.</li>
 *   <li>Initialize a min-priority queue to store the end days of events that are currently available to attend.</li>
 *   <li>Iterate through the days from the first possible start day to the last possible end day.</li>
 *   <li>On each day, add all events that start on that day to the priority queue. The queue will store their end days.</li>
 *   <li>Remove any events from the queue that have already ended (i.e., their end day is before the current day).</li>
 *   <li>If there are any events in the queue, attend one. We greedily pick the one that finishes earliest
 *   (the top of the min-queue), increase our attended events count, and move to the next day.</li>
 * </ol>
 *
 * <p><b>Complexity Analysis:</b>
 * <ul>
 *   <li>Time Complexity: O(N log N), dominated by the initial sort of the events. The while loop processes each event
 *   and day once, and each priority queue operation is O(log K), where K is the number of active events.
 *   <li>Space Complexity: O(N) in the worst case, where the priority queue could hold all events if they all start on the same day.
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/">1353. Maximum Number of Events That Can Be Attended</a>
 */
public class PriorityQueueSolution {

    /**
     * Calculates the maximum number of events that can be attended.
     *
     * @param events A 2D array where {@code events[i] = [startDay, endDay]}.
     * @return The maximum number of events that can be attended.
     */
    public int maxEvents(int[][] events) {
        // Sort events by their start day to process them in order.
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // A min-priority queue to store the end days of events that are currently available.
        // The greedy choice is to always attend the event that finishes earliest.
        Queue<Integer> queue = new PriorityQueue<>();

        int day = 0;          // Current day
        int index = 0;        // Pointer for the events array
        int result = 0;       // Total number of events attended
        int numberOfEvents = events.length;

        // The main loop continues as long as there are events to process or events in the queue to attend.
        while (index < numberOfEvents || !queue.isEmpty()) {
            // If the queue is empty, we can fast-forward time to the start day of the next available event.
            if (queue.isEmpty()) {
                day = events[index][0];
            }

            // Add all events that start on the current day to the priority queue.
            while (index < numberOfEvents && events[index][0] == day) {
                queue.offer(events[index][1]);
                index++;
            }

            // Attend the event that ends the soonest.
            queue.poll();
            result++;
            day++; // Move to the next day.

            // Clean up the queue by removing events that have already ended.
            // An event with endDay < current day cannot be attended.
            while (!queue.isEmpty() && queue.peek() < day) {
                queue.poll();
            }
        }
        return result;
    }
}