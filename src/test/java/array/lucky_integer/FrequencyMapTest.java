package array.lucky_integer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for the {@link FrequencyMap} class.
 */
class FrequencyMapTest {

    private FrequencyMap frequencyMap;

    @BeforeEach
    void setUp() {
        frequencyMap = new FrequencyMap();
    }

    @Test
    @DisplayName("Should return the largest lucky integer when multiple exist")
    void findLucky_whenMultipleLuckyIntegersExist_shouldReturnLargest() {
        int[] arr = {1, 2, 2, 3, 3, 3};
        assertEquals(3, frequencyMap.findLucky(arr), "The largest lucky integer is 3, as 1 and 3 are both lucky.");
    }

    @Test
    @DisplayName("Should return a single lucky integer when one exists")
    void findLucky_whenOneLuckyIntegerExists_shouldReturnIt() {
        int[] arr = {2, 2, 3, 4};
        assertEquals(2, frequencyMap.findLucky(arr), "The only lucky integer is 2.");
    }

    @Test
    @DisplayName("Should return -1 when no lucky integer exists")
    void findLucky_whenNoLuckyIntegerExists_shouldReturnMinusOne() {
        int[] arr = {1, 2, 2, 3, 3, 2, 1};
        assertEquals(-1, frequencyMap.findLucky(arr), "No number has a frequency equal to its value.");
    }

    @Test
    @DisplayName("Should return -1 for an empty array")
    void findLucky_whenArrayIsEmpty_shouldReturnMinusOne() {
        int[] arr = {};
        assertEquals(-1, frequencyMap.findLucky(arr), "An empty array has no lucky integers.");
    }

    @Test
    @DisplayName("Should handle an array where all elements are the same and form a lucky number")
    void findLucky_whenAllElementsAreSameAndLucky_shouldReturnTheNumber() {
        int[] arr = {4, 4, 4, 4};
        assertEquals(4, frequencyMap.findLucky(arr), "4 appears 4 times, so it is lucky.");
    }

    @Test
    @DisplayName("Should handle an array where all elements are the same but not lucky")
    void findLucky_whenAllElementsAreSameAndNotLucky_shouldReturnMinusOne() {
        int[] arr = {5, 5, 5};
        assertEquals(-1, frequencyMap.findLucky(arr), "5 appears 3 times, so it is not lucky.");
    }

    @Test
    @DisplayName("Should handle a single element array that is lucky")
    void findLucky_whenSingleElementIsLucky_shouldReturnTheNumber() {
        int[] arr = {1};
        assertEquals(1, frequencyMap.findLucky(arr), "1 appears 1 time, so it is lucky.");
    }

    @Test
    @DisplayName("Should handle a single element array that is not lucky")
    void findLucky_whenSingleElementIsNotLucky_shouldReturnMinusOne() {
        int[] arr = {2};
        assertEquals(-1, frequencyMap.findLucky(arr), "2 appears 1 time, so it is not lucky.");
    }

    @Test
    @DisplayName("Should handle a complex case with various numbers")
    void findLucky_withComplexArray_shouldReturnCorrectLargestLucky() {
        int[] arr = {7, 7, 7, 7, 7, 7, 7, 5, 5, 5, 5, 5, 2, 2, 8, 9};
        assertEquals(7, frequencyMap.findLucky(arr), "Both 5 and 7 are lucky, but 7 is the largest.");
    }

    @Test
    @DisplayName("Should ignore a smaller lucky number after a larger one is found")
    void findLucky_shouldNotBeReplacedBySmallerLuckyNumber() {
        // This test explicitly verifies the `num > lucky` part of the condition.
        // The map will contain two lucky numbers: 4 (appears 4 times) and 2 (appears 2 times).
        // The logic must correctly identify 4 as the largest lucky number,
        // even if it processes 2 after 4.
        int[] arr = {4, 4, 4, 4, 2, 2};
        assertEquals(4, frequencyMap.findLucky(arr), "The result should be the largest lucky number (4), not the smaller one (2).");
    }

    @Test
    @DisplayName("Should correctly identify the largest lucky number when a smaller one is also present")
    void findLucky_shouldHandleMultipleLuckyNumbers() {
        // This test ensures that if a smaller lucky number (e.g., 2) is processed
        // after a larger one (e.g., 3), the larger one is correctly retained.
        // This specifically covers the case where `num == count` is true,
        // but `num > lucky` is false.
        int[] arr = {2, 2, 3, 3, 3};
        assertEquals(3, frequencyMap.findLucky(arr), "The largest lucky number should be 3, not 2.");
    }
}