package array.lucky_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Solves the "Find Lucky Integer" problem using a HashMap to count frequencies.
 *
 * <p>This approach first iterates through the array to build a frequency map of all
 * numbers, then iterates through the map to find the largest number whose value
 * matches its frequency.
 */
public class FrequencyMap {

    /**
     * Finds the largest lucky integer in an array.
     *
     * <p>A lucky integer is an integer that has a frequency in the array equal to its value.
     * This method uses a two-pass approach:
     * <ol>
     *   <li>Build a frequency map of all numbers in the input array.</li>
     *   <li>Iterate through the map to find the largest key that equals its value.</li>
     * </ol>
     *
     * <p><b>Complexity:</b>
     * <ul>
     *   <li>Time: O(N), where N is the number of elements in {@code arr}. The first loop
     *       takes O(N), and the second loop takes O(U), where U is the number of unique
     *       elements (U &le; N).
     *   <li>Space: O(U), to store the unique elements in the frequency map.
     * </ul>
     *
     * @param arr The input array of integers. Constraints: 1 &le; arr.length &le; 500,
     *            1 &le; arr[i] &le; 500.
     * @return The largest lucky integer in the array, or -1 if none exists.
     */
    public int findLucky(int[] arr) {
        // Step 1: Create a frequency map to count occurrences of each number.
        // The key is the number from the array, and the value is its frequency.
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            // For each number, increment its count in the map.
            // getOrDefault handles the case where the number is seen for the first time.
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the largest lucky integer.
        // Initialize the result to -1, which will be returned if no lucky integer is found.
        int lucky = -1;

        // Iterate through each entry (number and its count) in the frequency map.
        for (var entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            // A number is "lucky" if its value is equal to its frequency.
            // We also check if this lucky number is greater than the one we've already found.
            if (num == count && num > lucky) {
                // If it is, update our result to this new, larger lucky number.
                lucky = num;
            }
        }

        // Return the largest lucky number found, or -1 if none existed.
        return lucky;
    }
}