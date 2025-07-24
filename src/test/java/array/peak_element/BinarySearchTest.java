package array.peak_element;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the BinarySearch class to find a peak element.
 */
class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    @DisplayName("Test with a simple peak in the middle of the array")
    void testPeakElement_simplePeak() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(2, binarySearch.peakElement(nums), "Should find the peak at index 2");
    }

    @Test
    @DisplayName("Test with a peak at the beginning of the array")
    void testPeakElement_peakAtStart() {
        int[] nums = {5, 4, 3, 2, 1};
        assertEquals(0, binarySearch.peakElement(nums), "Should find the peak at the start");
    }

    @Test
    @DisplayName("Test with a peak at the end of the array")
    void testPeakElement_peakAtEnd() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(4, binarySearch.peakElement(nums), "Should find the peak at the end");
    }

    @Test
    @DisplayName("Test with multiple peaks, should return any valid peak index")
    void testPeakElement_multiplePeaks() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        // Valid peaks are at index 1 (value 2) and index 5 (value 6)
        Set<Integer> validPeakIndices = Set.of(1, 5);
        int result = binarySearch.peakElement(nums);
        assertTrue(validPeakIndices.contains(result), "Result should be one of the valid peak indices");
    }

    @Test
    @DisplayName("Test with a single-element array")
    void testPeakElement_singleElement() {
        int[] nums = {42};
        assertEquals(0, binarySearch.peakElement(nums), "A single element is always a peak");
    }

    @Test
    @DisplayName("Test with a two-element ascending array")
    void testPeakElement_twoElementsAscending() {
        int[] nums = {10, 20};
        assertEquals(1, binarySearch.peakElement(nums), "Peak should be the larger element at index 1");
    }

    @Test
    @DisplayName("Test with a two-element descending array")
    void testPeakElement_twoElementsDescending() {
        int[] nums = {20, 10};
        assertEquals(0, binarySearch.peakElement(nums), "Peak should be the larger element at index 0");
    }

    @Test
    @DisplayName("Test with an array containing a plateau")
    void testPeakElement_withPlateau() {
        int[] nums = {1, 5, 5, 2};
        // The algorithm should find index 1 as a peak because nums[1] >= nums[2]
        assertEquals(1, binarySearch.peakElement(nums), "Should handle plateaus correctly");
    }

    @Test
    @DisplayName("Test with a zig-zag array")
    void testPeakElement_zigZag() {
        int[] nums = {1, 5, 1, 5, 1, 5, 1};
        Set<Integer> validPeakIndices = Set.of(1, 3, 5);
        int result = binarySearch.peakElement(nums);
        assertTrue(validPeakIndices.contains(result), "Result should be a valid peak in the zig-zag array");
    }

    @Test
    @DisplayName("Test with a long, strictly increasing then decreasing array")
    void testPeakElement_longArray() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(7, binarySearch.peakElement(nums), "Should find the peak in a long array");
    }

    @Test
    @DisplayName("Test with null input should throw IllegalArgumentException")
    void testPeakElement_nullInput() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.peakElement(null), "Should throw IllegalArgumentException for null input");
    }

    @Test
    @DisplayName("Test with empty input should throw IllegalArgumentException")
    void testPeakElement_emptyInput() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> binarySearch.peakElement(nums), "Should throw IllegalArgumentException for an empty array");
    }
}