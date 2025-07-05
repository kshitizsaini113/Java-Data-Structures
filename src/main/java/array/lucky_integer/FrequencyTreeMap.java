package array.lucky_integer;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solves the "Find Lucky Integer" problem using a {@link TreeMap}.
 *
 * <p>This implementation leverages a {@code TreeMap} with a reverse order comparator
 * to store number frequencies. By sorting the numbers in descending order, the search
 * for the lucky integer can be optimized: the first lucky number found during iteration
 * is guaranteed to be the largest one, allowing for an early exit.
 *
 * <p>While this approach is a valid general-purpose solution, it is not the most
 * performant for this problem's specific constraints (numbers 1-500), where a
 * simple frequency array would be faster.
 *
 * @see FrequencyArray Frequency Array for the optimal approach.
 */
public class FrequencyTreeMap {

    /**
     * Finds the largest lucky integer using a TreeMap for automatic sorting.
     *
     * <p>This approach uses a {@link TreeMap} with a reverse order comparator.
     * This keeps the keys sorted from largest to smallest. When iterating, the
     * first lucky number found is guaranteed to be the largest, simplifying the logic.
     *
     * <p><b>Complexity:</b>
     * <ul>
     *   <li>Time: O(N * log U), where N is the number of elements and U is the
     *       number of unique elements. Each {@code put} operation in a TreeMap
     *       is O(log U).
     *   <li>Space: O(U), to store the unique elements in the map.
     * </ul>
     *
     * @param arr The input array of integers.
     * @return The largest lucky integer in the array, or -1 if none exists.
     */
    public int findLucky(int[] arr) {
        // Step 1: Create a frequency map that sorts keys in descending order.
        Map<Integer, Integer> freqMap = new TreeMap<>(Collections.reverseOrder());

        // Build the frequency map. Each `put` takes O(log U) time.
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the first lucky integer.
        // Because the map is sorted from largest to smallest, the first match
        // we find is guaranteed to be the largest lucky number.
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            // If the number (key) equals its frequency (value)...
            if (entry.getKey().equals(entry.getValue())) {
                // ...we've found our answer.
                return entry.getKey();
            }
        }

        // If the loop completes, no lucky number was found.
        return -1;
    }
}