package array.longest_harmonious_subsequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTest {

    private final SlidingWindow solution = new SlidingWindow();

    @Test
    @DisplayName("Should return 5 for the main example case")
    void testExampleCase() {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(5, result, "The longest subsequence is [3,2,2,2,3]");
    }

    @Test
    @DisplayName("Should return 0 when no harmonious subsequence exists")
    void testNoHarmoniousSubsequence() {
        int[] nums = {1, 1, 1, 1};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(0, result, "No pair has a difference of 1");
    }

    @Test
    @DisplayName("Should return 4 for a simple harmonious array")
    void testSimpleHarmonious() {
        int[] nums = {1, 2, 2, 1};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(4, result, "The entire array is a valid subsequence");
    }

    @Test
    @DisplayName("Should return 0 for a null array")
    void testNullArray() {
        int result = solution.findLargestHarmoniousSubsequence(null);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 for an empty array")
    void testEmptyArray() {
        int[] nums = {};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 0 for an array with a single element")
    void testSingleElement() {
        int[] nums = {100};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should return 2 for two elements with a difference of one")
    void testTwoElementsWithDifferenceOne() {
        int[] nums = {5, 6};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Should return 0 for two identical elements")
    void testTwoElementsSameValue() {
        int[] nums = {7, 7};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Should handle large inputs correctly")
    void testLargeInput() {
        int[] nums = new int[20000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = 1000000000;
        }
        for (int i = 10000; i < 20000; i++) {
            nums[i] = 999999999;
        }
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(20000, result, "All values should form one large harmonious subsequence");
    }

    @Test
    @DisplayName("Should handle negative numbers correctly")
    void testNegativeNumbers() {
        int[] nums = {-2, -1, -1, -1, -2, -3};
        int result = solution.findLargestHarmoniousSubsequence(nums);
        assertEquals(5, result, "The subsequence with -2 and -1 should be found");
    }
}