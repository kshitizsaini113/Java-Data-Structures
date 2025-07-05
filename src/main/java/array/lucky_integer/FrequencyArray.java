package array.lucky_integer;

/**
 * Solves the "Find Lucky Integer" problem using a highly optimized frequency array.
 *
 * <p>This approach leverages the problem's constraint that all numbers are within a
 * small, positive range (1 to 500). It uses a simple array as a direct-access
 * frequency map, which is significantly more performant and memory-efficient than
 * using a {@code HashMap} or {@code TreeMap} for this specific scenario.
 */
public class FrequencyArray {

    /**
     * Finds the largest lucky integer using a frequency array.
     *
     * <p>The logic iterates backwards from the maximum possible value. The first
     * lucky number encountered is guaranteed to be the largest, allowing for an
     * early exit.
     *
     * <p><b>Complexity:</b>
     * <ul>
     *   <li>Time: O(N + M), where N is the length of {@code arr} and M is the
     *       maximum possible value (500). This is effectively O(N).
     *   <li>Space: O(M), which is constant space O(1) as M is fixed.
     * </ul>
     *
     * @param arr The input array of integers.
     * @return The largest lucky integer in the array, or -1 if none exists.
     */
    public int findLucky(int[] arr) {
        // Per the constraints, arr[i] is between 1 and 500.
        // We create an array of size 501 to use indices 1 through 500.
        int[] frequencies = new int[501];

        // First pass: count the frequency of each number.
        // This is an O(N) operation.
        for (int num : arr) {
            // We can safely do this because of the constraint 1 <= num <= 500.
            frequencies[num]++;
        }

        // Second pass: check for a lucky number, starting from the largest possible.
        // This is an O(M) operation.
        for (int i = 500; i >= 1; i--) {
            // If the number (i) is equal to its frequency (frequencies[i])...
            if (frequencies[i] == i) {
                // ...we've found the largest lucky number, so we can return immediately.
                return i;
            }
        }

        // If the loop completes, no lucky number was found.
        return -1;
    }
}