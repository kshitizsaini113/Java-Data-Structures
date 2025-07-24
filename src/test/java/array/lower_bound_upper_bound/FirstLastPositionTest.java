package array.lower_bound_upper_bound;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test suite for the FirstLastPosition class.
 */
class FirstLastPositionTest {

    private FirstLastPosition finder;

    @BeforeEach
    void setUp() {
        finder = new FirstLastPosition();
    }

    @Test
    @DisplayName("Test with target present multiple times in the middle")
    void testSearchRangeTargetInMiddle() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with target not found in the array")
    void testSearchRangeTargetNotFound() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with an empty array")
    void testSearchRangeEmptyArray() {
        int[] nums = {};
        int target = 0;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with a null array")
    void testSearchRangeNullArray() {
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(null, 5));
    }

    @Test
    @DisplayName("Test with a single element array, target found")
    void testSearchRangeSingleElementFound() {
        int[] nums = {5};
        int target = 5;
        int[] expected = {0, 0};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with a single element array, target not found")
    void testSearchRangeSingleElementNotFound() {
        int[] nums = {5};
        int target = 3;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with target at the beginning of the array")
    void testSearchRangeTargetAtStart() {
        int[] nums = {2, 2, 3, 4, 5, 6};
        int target = 2;
        int[] expected = {0, 1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with target at the end of the array")
    void testSearchRangeTargetAtEnd() {
        int[] nums = {1, 2, 3, 4, 5, 5};
        int target = 5;
        int[] expected = {4, 5};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test where all elements are the target")
    void testSearchRangeAllElementsAreTarget() {
        int[] nums = {7, 7, 7, 7, 7};
        int target = 7;
        int[] expected = {0, 4};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with target smaller than all elements")
    void testSearchRangeTargetIsTooSmall() {
        int[] nums = {10, 20, 30, 40};
        int target = 5;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with target larger than all elements")
    void testSearchRangeTargetIsTooLarge() {
        int[] nums = {10, 20, 30, 40};
        int target = 50;
        int[] expected = {-1, -1};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }

    @Test
    @DisplayName("Test with a single occurrence of the target")
    void testSearchRangeSingleOccurrence() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int[] expected = {2, 2};
        assertArrayEquals(expected, finder.searchRange(nums, target));
    }
}