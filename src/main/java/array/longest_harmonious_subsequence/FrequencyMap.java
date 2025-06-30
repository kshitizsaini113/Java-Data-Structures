package array.longest_harmonious_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Solves the Longest Harmonious Subsequence problem using a frequency map (HashMap).
 * <p>
 * A harmonious array is an array where the difference between its maximum value
 * and its minimum value is exactly 1.
 */
public class FrequencyMap {

    /**
     * Finds the length of the longest harmonious subsequence using a two-pass hash map approach.
     * <p>
     * The first pass populates a map with the frequency of each number in the input array.
     * The second pass iterates through the map to find keys {@code x} such that {@code x+1}
     * also exists, and calculates the length of the subsequence formed by them.
     * <p>
     * <b>Time Complexity:</b> O(n), where n is the number of elements in {@code nums}.
     * The algorithm involves two passes: one over the input array (O(n)) and one over
     * the unique keys in the map (O(k), where k <= n). Thus, the complexity is O(n).
     * <p>
     * <b>Space Complexity:</b> O(k), where k is the number of unique elements in
     * {@code nums}. In the worst case (all elements are unique), this is O(n).
     *
     * @param nums The input integer array.
     * @return The length of the longest harmonious subsequence. Returns 0 if no such subsequence exists.
     */
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // First pass: count the frequency of each number.
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        // Second pass: iterate through the numbers present in the array.
        for (var element : frequencyMap.entrySet()) {
            int num = element.getKey();
            // Check if a harmonious partner (num + 1) exists.
            if (frequencyMap.containsKey(num + 1)) {
                // Calculate the length of this harmonious subsequence.
                int currentLength = element.getValue() + frequencyMap.get(num + 1);
                // Update the maximum length found so far.
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}