package array.longest_harmonious_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTest {

    private final SlidingWindow solution = new SlidingWindow();

    @Test
    void testExampleCase() {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int result = solution.findLHS(nums);
        assertEquals(5, result); // longest subsequence: [3,2,2,2,3]
    }

    @Test
    void testNoHarmoniousSubsequence() {
        int[] nums = {1, 1, 1, 1};
        int result = solution.findLHS(nums);
        assertEquals(0, result); // no pair with difference of 1
    }

    @Test
    void testSimpleHarmonious() {
        int[] nums = {1, 2, 2, 1};
        int result = solution.findLHS(nums);
        assertEquals(4, result); // whole array is valid
    }

    @Test
    void testSingleElement() {
        int[] nums = {100};
        int result = solution.findLHS(nums);
        assertEquals(0, result);
    }

    @Test
    void testTwoElementsWithDifferenceOne() {
        int[] nums = {5, 6};
        int result = solution.findLHS(nums);
        assertEquals(2, result);
    }

    @Test
    void testTwoElementsSameValue() {
        int[] nums = {7, 7};
        int result = solution.findLHS(nums);
        assertEquals(0, result);
    }

    @Test
    void testLargeInput() {
        int[] nums = new int[20000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = 1000000000;
        }
        for (int i = 10000; i < 20000; i++) {
            nums[i] = 999999999;
        }
        int result = solution.findLHS(nums);
        assertEquals(20000, result); // All values differ by exactly 1
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-2, -1, -1, -1, -2, -3};
        int result = solution.findLHS(nums);
        assertEquals(5, result); // subsequence with -2 and -1
    }
}
