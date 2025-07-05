package array.lucky_integer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test suite for the {@link FrequencyArray} class.
 *
 * <p>This suite validates the correctness of the frequency array approach for finding
 * the largest lucky integer, covering various scenarios and edge cases.
 */
class FrequencyArrayTest {

    private FrequencyArray frequencyArray;

    @BeforeEach
    void setUp() {
        frequencyArray = new FrequencyArray();
    }

    @Test
    @DisplayName("Should return the largest lucky integer when multiple exist")
    void findLucky_whenMultipleLuckyIntegersExist_shouldReturnLargest() {
        int[] arr = {1, 2, 2, 3, 3, 3};
        assertEquals(3, frequencyArray.findLucky(arr), "The largest lucky integer is 3, as 1 and 3 are both lucky.");
    }

    @Test
    @DisplayName("Should return a single lucky integer when one exists")
    void findLucky_whenOneLuckyIntegerExists_shouldReturnIt() {
        int[] arr = {2, 2, 3, 4};
        assertEquals(2, frequencyArray.findLucky(arr), "The only lucky integer is 2.");
    }

    @Test
    @DisplayName("Should return -1 when no lucky integer exists")
    void findLucky_whenNoLuckyIntegerExists_shouldReturnMinusOne() {
        int[] arr = {1, 2, 2, 3, 3, 2, 1};
        assertEquals(-1, frequencyArray.findLucky(arr), "No number has a frequency equal to its value.");
    }

    @Test
    @DisplayName("Should return -1 for an empty array")
    void findLucky_whenArrayIsEmpty_shouldReturnMinusOne() {
        int[] arr = {};
        assertEquals(-1, frequencyArray.findLucky(arr), "An empty array has no lucky integers.");
    }

    @Test
    @DisplayName("Should handle an array where all elements are the same and form a lucky number")
    void findLucky_whenAllElementsAreSameAndLucky_shouldReturnTheNumber() {
        int[] arr = {4, 4, 4, 4};
        assertEquals(4, frequencyArray.findLucky(arr), "4 appears 4 times, so it is lucky.");
    }

    @Test
    @DisplayName("Should handle an array where all elements are the same but not lucky")
    void findLucky_whenAllElementsAreSameAndNotLucky_shouldReturnMinusOne() {
        int[] arr = {5, 5, 5};
        assertEquals(-1, frequencyArray.findLucky(arr), "5 appears 3 times, so it is not lucky.");
    }

    @Test
    @DisplayName("Should handle a single element array that is lucky")
    void findLucky_whenSingleElementIsLucky_shouldReturnTheNumber() {
        int[] arr = {1};
        assertEquals(1, frequencyArray.findLucky(arr), "1 appears 1 time, so it is lucky.");
    }

    @Test
    @DisplayName("Should handle a single element array that is not lucky")
    void findLucky_whenSingleElementIsNotLucky_shouldReturnMinusOne() {
        int[] arr = {2};
        assertEquals(-1, frequencyArray.findLucky(arr), "2 appears 1 time, so it is not lucky.");
    }

    @Test
    @DisplayName("Should handle a complex case with various numbers")
    void findLucky_withComplexArray_shouldReturnCorrectLargestLucky() {
        int[] arr = {7, 7, 7, 7, 7, 7, 7, 5, 5, 5, 5, 5, 2, 2, 8, 9};
        assertEquals(7, frequencyArray.findLucky(arr), "Both 5 and 7 are lucky, but 7 is the largest.");
    }

    @Test
    @DisplayName("Should handle the maximum constraint value being lucky")
    void findLucky_withMaximumValueAsLuckyNumber_shouldReturnIt() {
        // Create an array with 500 instances of the number 500.
        int[] arr = new int[500];
        for (int i = 0; i < 500; i++) {
            arr[i] = 500;
        }
        assertEquals(500, frequencyArray.findLucky(arr), "500 appears 500 times and should be a valid lucky number.");
    }
}