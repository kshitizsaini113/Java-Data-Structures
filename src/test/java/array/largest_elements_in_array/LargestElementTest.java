package array.largest_elements_in_array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestElementTest {

    private final LargestElement solution = new LargestElement();

    // Test cases for maxElement()

    @Test
    @DisplayName("maxElement should find the largest element in a positive integer array")
    void testMaxElementPositiveNumbers() {
        int[] nums = {1, 8, 3, 10, 4};
        assertEquals(10, solution.maxElement(nums));
    }

    @Test
    @DisplayName("maxElement should find the largest element in a negative integer array")
    void testMaxElementNegativeNumbers() {
        int[] nums = {-5, -2, -10, -1};
        assertEquals(-1, solution.maxElement(nums));
    }

    @Test
    @DisplayName("maxElement should find the largest element in an array with mixed positive and negative numbers")
    void testMaxElementMixedNumbers() {
        int[] nums = {-10, 5, 0, -2, 8};
        assertEquals(8, solution.maxElement(nums));
    }

    @Test
    @DisplayName("maxElement should return the element itself for a single-element array")
    void testMaxElementSingleElement() {
        int[] nums = {42};
        assertEquals(42, solution.maxElement(nums));
    }

    @Test
    @DisplayName("maxElement should handle an array containing Integer.MIN_VALUE")
    void testMaxElementWithMinValue() {
        int[] nums = {-1, -5, Integer.MIN_VALUE};
        assertEquals(-1, solution.maxElement(nums));
    }

    @Test
    @DisplayName("maxElement should throw IllegalArgumentException for a null array")
    void testMaxElementNullArray() {
        assertThrows(IllegalArgumentException.class, () -> solution.maxElement(null));
    }

    @Test
    @DisplayName("maxElement should throw IllegalArgumentException for an empty array")
    void testMaxElementEmptyArray() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> solution.maxElement(nums));
    }

    // Test cases for secondLargestElement()

    @Test
    @DisplayName("secondLargestElement should find the second-largest element in a standard case")
    void testSecondLargestElementStandardCase() {
        int[] nums = {1, 8, 3, 10, 4};
        assertEquals(8, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("secondLargestElement should return -1 if all elements are the same")
    void testSecondLargestElementAllElementsSame() {
        int[] nums = {5, 5, 5, 5};
        assertEquals(-1, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("secondLargestElement should handle an array with two distinct elements")
    void testSecondLargestElementTwoElements() {
        int[] nums = {10, 5};
        assertEquals(5, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("secondLargestElement should handle negative numbers correctly")
    void testSecondLargestElementNegativeNumbers() {
        int[] nums = {-5, -2, -10, -1};
        assertEquals(-2, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("secondLargestElement should return -1 for an array with fewer than two elements")
    void testSecondLargestElementLessThanTwoElements() {
        int[] nums = {10};
        assertEquals(-1, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("secondLargestElement should return -1 for a null array")
    void testSecondLargestElementNullArray() {
        assertEquals(-1, solution.secondLargestElement(null));
    }

    @Test
    @DisplayName("secondLargestElement should return -1 for an empty array")
    void testSecondLargestElementEmptyArray() {
        int[] nums = {};
        assertEquals(-1, solution.secondLargestElement(nums));
    }

    @Test
    @DisplayName("Failing Case: secondLargestElement should handle an array where the second-largest element is Integer.MIN_VALUE")
    void testSecondLargestElementFailingCaseWithMinValue() {
        // This test exposes a flaw in the logic. The current implementation returns -1
        // because it uses Integer.MIN_VALUE as a sentinel for "not found", but it can
        // also be a valid second-largest number.
        int[] nums = {10, Integer.MIN_VALUE};
        assertEquals(Integer.MIN_VALUE, solution.secondLargestElement(nums),
                "The method fails to correctly identify Integer.MIN_VALUE as the second-largest element.");
    }
}
