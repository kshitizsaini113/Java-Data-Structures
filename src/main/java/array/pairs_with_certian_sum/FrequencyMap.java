package array.pairs_with_certian_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Implements a data structure to find pairs with a certain sum from two arrays.
 *
 * <p>This class is optimized for frequent {@code count} queries. It achieves this by
 * pre-processing {@code nums2} into a frequency map. This allows the {@code count}
 * operation to run in O(N) time (where N is the length of {@code nums1}), and the
 * {@code add} operation to run in O(1) time.
 */
public class FrequencyMap {
    private final int[] nums1;
    private final int[] nums2;
    private final Map<Integer, Integer> freqMap;

    /**
     * Initializes the data structure with two integer arrays.
     *
     * <p>The constructor stores references to the arrays and builds a frequency map
     * from {@code nums2} to enable fast lookups.
     *
     * <p><b>Complexity:</b> O(M), where M is the length of {@code nums2}, due to
     * building the frequency map.
     *
     * @param nums1 The first integer array, which remains static.
     * @param nums2 The second integer array, which can be modified.
     */
    public FrequencyMap(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new HashMap<>();
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    /**
     * Adds a value to an element in {@code nums2} and updates the frequency map.
     *
     * <p>This operation first decrements the frequency of the old value at the given
     * index. If the frequency becomes zero, the entry is removed from the map. It then
     * updates the array element and increments the frequency of the new value.
     *
     * <p><b>Complexity:</b> O(1) on average for HashMap operations.
     *
     * @param index The index in {@code nums2} to modify.
     * @param val   The positive integer value to add.
     */
    public void add(int index, int val) {
        // First, decrement the count of the old number.
        int oldVal = nums2[index];
        freqMap.computeIfPresent(oldVal, (key, count) -> (count == 1) ? null : count - 1);

        // Update the number in the array.
        nums2[index] += val;

        // Then, increment the count of the new number.
        int newVal = nums2[index];
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }

    /**
     * Counts the number of pairs (i, j) such that nums1[i] + nums2[j] == total.
     *
     * <p>This method iterates through the static {@code nums1} array. For each element
     * {@code n1}, it calculates the required complement ({@code total - n1}) and looks
     * up its frequency in the map of {@code nums2}.
     *
     * <p><b>Complexity:</b> O(N), where N is the length of {@code nums1}.
     *
     * @param total The target sum to find.
     * @return The total number of pairs that sum to {@code total}.
     */
    public int count(int total) {
        int result = 0;
        for (int num : nums1) {
            // For each number in nums1, find how many complements exist in nums2.
            result += freqMap.getOrDefault(total - num, 0);
        }
        return result;
    }
}