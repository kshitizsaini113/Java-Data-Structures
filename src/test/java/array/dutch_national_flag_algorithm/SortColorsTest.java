package array.dutch_national_flag_algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test suite for the SortColors class.
 */
class SortColorsTest {

    private SortColors sorter;

    @BeforeEach
    void setUp() {
        sorter = new SortColors();
    }

    @Test
    @DisplayName("Test with a typical mixed array of 0s, 1s, and 2s")
    void testSortColors_withMixedValues() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should sort a mixed array correctly");
    }

    @Test
    @DisplayName("Test with an empty array")
    void testSortColors_withEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle an empty array without error");
    }

    @Test
    @DisplayName("Test with a single-element array")
    void testSortColors_withSingleElementArray() {
        int[] nums = {1};
        int[] expected = {1};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle a single-element array");
    }

    @Test
    @DisplayName("Test with an already sorted array")
    void testSortColors_withAlreadySortedArray() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        int[] expected = {0, 0, 1, 1, 2, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should not change an already sorted array");
    }

    @Test
    @DisplayName("Test with a reverse-sorted array")
    void testSortColors_withReverseSortedArray() {
        int[] nums = {2, 1, 0};
        int[] expected = {0, 1, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should correctly sort a reverse-sorted array");
    }

    @Test
    @DisplayName("Test with an array containing all the same elements (all 1s)")
    void testSortColors_withAllSameElements() {
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle an array of all same elements");
    }

    @Test
    @DisplayName("Test with an array containing all 0s")
    void testSortColors_withAllZeros() {
        int[] nums = {0, 0, 0};
        int[] expected = {0, 0, 0};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle an array of all zeros");
    }

    @Test
    @DisplayName("Test with an array containing all 2s")
    void testSortColors_withAllTwos() {
        int[] nums = {2, 2, 2, 2};
        int[] expected = {2, 2, 2, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle an array of all twos");
    }

    @Test
    @DisplayName("Test with an array containing only 0s and 1s")
    void testSortColors_withOnlyZerosAndOnes() {
        int[] nums = {1, 0, 1, 0, 1};
        int[] expected = {0, 0, 1, 1, 1};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should correctly sort an array with only 0s and 1s");
    }

    @Test
    @DisplayName("Test with an array containing only 1s and 2s")
    void testSortColors_withOnlyOnesAndTwos() {
        int[] nums = {1, 2, 1, 2, 2};
        int[] expected = {1, 1, 2, 2, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should correctly sort an array with only 1s and 2s");
    }

    @Test
    @DisplayName("Test with an array containing only 0s and 2s")
    void testSortColors_withOnlyZerosAndTwos() {
        int[] nums = {2, 0, 2, 0};
        int[] expected = {0, 0, 2, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should correctly sort an array with only 0s and 2s");
    }

    @Test
    @DisplayName("Test with a complex case where a 2 is swapped with a 0")
    void testSortColors_complexSwapCase() {
        // This case tests the `high--` without `mid++` logic.
        // When nums[mid] (2) is swapped with nums[high] (0), the new nums[mid] is 0,
        // which must be processed in the next iteration.
        int[] nums = {2, 1, 0};
        int[] expected = {0, 1, 2};
        sorter.sortColors(nums);
        assertArrayEquals(expected, nums, "Should handle swapping a 2 with a 0 correctly");
    }

    @Test
    @DisplayName("Test with a null array should throw NullPointerException")
    void testSortColors_withNullArray() {
        assertThrows(NullPointerException.class, () -> {
            sorter.sortColors(null);
        }, "Should throw NullPointerException for a null input array");
    }

    @Test
    @DisplayName("Test with an array having other elements should throw IllegalStateException")
    void testSortColors_withUnexpectedArray() {
        int[] nums = {5, 1, 0};
        assertThrows(IllegalStateException.class, () -> {
            sorter.sortColors(nums);
        }, "Should throw IllegalStateException for an unexpected input array");
    }
}