package stack.next_greater_element;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test suite for the {@link MonotonicStack} class.
 */
class MonotonicStackTest {

    @Test
    @DisplayName("Should find the next greater element in a general case array")
    void findNextGreaterElement_generalCase() {
        // Arrange
        int[] array = {2, 1, 5, 6, 2, 3};
        int[] expected = {5, 5, 6, -1, 3, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "Should correctly find next greater elements");
    }

    @Test
    @DisplayName("Should return -1 for all elements in a strictly decreasing array")
    void findNextGreaterElement_strictlyDecreasingArray() {
        // Arrange
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {-1, -1, -1, -1, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "All elements should have -1 as next greater");
    }

    @Test
    @DisplayName("Should find the correct next greater element in a strictly increasing array")
    void findNextGreaterElement_strictlyIncreasingArray() {
        // Arrange
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "Each element's next greater should be its right neighbor");
    }

    @Test
    @DisplayName("Should handle an array with duplicate values")
    void findNextGreaterElement_withDuplicates() {
        // Arrange
        int[] array = {4, 5, 2, 2, 5};
        int[] expected = {5, -1, 5, 5, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "Should handle duplicates correctly");
    }

    @Test
    @DisplayName("Should handle an array with duplicate values")
    void findNextGreaterElement_withDuplicates_multiple() {
        // Arrange
        int[] array = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int[] expected = {12, -1, 6, 5, 2, 5, 6, 4, 2, 4, 6, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "Should handle duplicates correctly");
    }

    @Test
    @DisplayName("Should handle an array where all elements are the same")
    void findNextGreaterElement_allSameElements() {
        // Arrange
        int[] array = {7, 7, 7, 7};
        int[] expected = {-1, -1, -1, -1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "All elements should be -1 when all are identical");
    }

    @Test
    @DisplayName("Should handle a single-element array")
    void findNextGreaterElement_singleElementArray() {
        // Arrange
        int[] array = {100};
        int[] expected = {-1};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "A single element has no next greater element");
    }

    @Test
    @DisplayName("Should handle an empty array without errors")
    void findNextGreaterElement_emptyArray() {
        // Arrange
        int[] array = {};
        int[] expected = {};
        MonotonicStack monotonicStack = new MonotonicStack(array);

        // Act
        monotonicStack.findNextGreaterElement();

        // Assert
        assertArrayEquals(expected, monotonicStack.answer, "An empty input should result in an empty output");
    }
}