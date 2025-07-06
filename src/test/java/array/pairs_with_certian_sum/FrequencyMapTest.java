package array.pairs_with_certian_sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for the {@link FrequencyMap} class.
 */
class FrequencyMapTest {

    @Test
    @DisplayName("Should correctly handle the provided LeetCode example scenario")
    void shouldPassLeetCodeScenario() {
        // Input:
        // ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
        // [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
        // Expected Output:
        // [null, 8, null, 2, 1, null, null, 11]

        // Initialize the class
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        FrequencyMap findSumPairs = new FrequencyMap(nums1, nums2);

        // count(7) -> Expected: 8
        // Pairs: (2,5), (2,5), (2,5), (2,5), (2,5), (2,5) from nums1[2,3,4] and nums2[2,4] -> 3*2=6
        // Pairs: (3,4), (3,4) from nums1[5] and nums2[1,5] -> 1*2=2. Total = 8.
        assertEquals(8, findSumPairs.count(7), "Initial count for total 7 should be 8");

        // add(3, 2) -> nums2 becomes [1, 4, 5, 4, 5, 4]
        findSumPairs.add(3, 2);

        // count(8) -> Expected: 2
        // Pairs: (3,5), (3,5) from nums1[5] and nums2[2,4] -> 1*2=2. Total = 2.
        assertEquals(2, findSumPairs.count(8), "Count for total 8 after first add should be 2");

        // count(4) -> Expected: 1
        // Pair: (3,1) from nums1[5] and nums2[0]. Total = 1.
        assertEquals(1, findSumPairs.count(4), "Count for total 4 should be 1");

        // add(0, 1) -> nums2 becomes [2, 4, 5, 4, 5, 4]
        findSumPairs.add(0, 1);
        // add(1, 1) -> nums2 becomes [2, 5, 5, 4, 5, 4]
        findSumPairs.add(1, 1);

        // count(7) -> Expected: 11
        // Pairs: (2,5), (2,5), (2,5) from nums1[2,3,4] and nums2[1,2,4] -> 3*3=9
        // Pairs: (3,4), (3,4) from nums1[5] and nums2[3,5] -> 1*2=2. Total = 11.
        assertEquals(11, findSumPairs.count(7), "Count for total 7 after final adds should be 11");
    }

    @Test
    @DisplayName("Should return 0 when no pairs sum to the target")
    void shouldReturnZeroWhenNoPairsMatch() {
        int[] nums1 = {10, 20, 30};
        int[] nums2 = {1, 2, 3};
        FrequencyMap findSumPairs = new FrequencyMap(nums1, nums2);

        assertEquals(0, findSumPairs.count(100), "Should return 0 for a total that cannot be formed");
        assertEquals(0, findSumPairs.count(5), "Should return 0 for a total that is too small");
    }

    @Test
    @DisplayName("Should correctly update counts after an add operation")
    void shouldUpdateCountsAfterAdd() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 1, 1};
        FrequencyMap findSumPairs = new FrequencyMap(nums1, nums2);

        // Initially, 3 pairs sum to 2: (1,1), (1,1), (1,1)
        assertEquals(3, findSumPairs.count(2), "Initial count for total 2 should be 3");

        // Add 1 to nums2[0], making it [2, 1, 1]
        findSumPairs.add(0, 1);

        // Now, 2 pairs sum to 2: (1,1), (1,1)
        assertEquals(2, findSumPairs.count(2), "Count for total 2 should decrease to 2 after add");
        // And 1 pair sums to 4: (2,2), (3, 1), (3, 1)
        assertEquals(3, findSumPairs.count(4), "Count for total 4 should become 1 after add");
    }

    @Test
    @DisplayName("Should handle arrays with duplicate numbers correctly")
    void shouldHandleDuplicatesInBothArrays() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {3, 3};
        FrequencyMap findSumPairs = new FrequencyMap(nums1, nums2);

        // Each of the 3 '2's in nums1 can be paired with each of the 2 '3's in nums2
        assertEquals(6, findSumPairs.count(5), "Should be 3 * 2 = 6 pairs that sum to 5");
    }
}