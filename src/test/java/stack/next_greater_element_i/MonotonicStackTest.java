package stack.next_greater_element_i;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test suite for the {@link MonotonicStack} class.
 */
class MonotonicStackTest {

    private final MonotonicStack monotonicStack = new MonotonicStack();

    @Test
    @DisplayName("Should pass the primary LeetCode example")
    void testLeetCodeExample1() {
        // Arrange
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] expected = {-1, 3, -1};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "Should find the correct next greater elements");
    }

    @Test
    @DisplayName("Should pass the second LeetCode example")
    void testLeetCodeExample2() {
        // Arrange
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] expected = {3, -1};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "Should handle cases where the element is at the end");
    }

    @Test
    @DisplayName("Should return -1 for all elements when nums2 is strictly decreasing")
    void testStrictlyDecreasingArray() {
        // Arrange
        int[] nums1 = {5, 3, 1};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] expected = {-1, -1, -1};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "All results should be -1 for a decreasing array");
    }

    @Test
    @DisplayName("Should find the adjacent element when nums2 is strictly increasing")
    void testStrictlyIncreasingArray() {
        // Arrange
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 4, 5};
        int[] expected = {2, 3, 4, 5};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "Next greater element should be the next one in sequence");
    }

    @Test
    @DisplayName("Should work correctly when nums1 is a permutation of nums2")
    void testWhenNums1IsPermutationOfNums2() {
        // Arrange
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {1, 3, 5, 2, 4};
        int[] expected = {3, 5, -1, 4, -1};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "Should handle the case where nums1 and nums2 are the same");
    }

    @Test
    @DisplayName("Should handle a more complex, mixed scenario")
    void testComplexScenario() {
        // Arrange
        int[] nums1 = {13, 7, 6, 12};
        int[] nums2 = {1, 3, 7, 4, 6, 9, 13, 12, 11};
        // NGE map for nums2: {1:3, 3:7, 7:9, 4:6, 6:9, 9:13, 13:-1, 12:-1, 11:-1}
        int[] expected = {-1, 9, 9, -1};

        // Act
        int[] result = monotonicStack.nextGreaterElement(nums1, nums2);

        // Assert
        assertArrayEquals(expected, result, "Should correctly process a complex sequence");
    }
}