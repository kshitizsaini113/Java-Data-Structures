package array.remove_duplicates_from_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link RemoveDuplicates}.
 */
class RemoveDuplicatesTest {

    private final RemoveDuplicates solution = new RemoveDuplicates();

    @Test
    void testArrayWithDuplicates() {
        int[] nums = {1, 1, 2, 2, 3};
        int k = solution.removeDuplicates(nums);

        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, copyFirstK(nums, k));
    }

    @Test
    void testArrayWithoutDuplicates() {
        int[] nums = {1, 2, 3, 4};
        int k = solution.removeDuplicates(nums);

        assertEquals(4, k);
        assertArrayEquals(new int[]{1, 2, 3, 4}, copyFirstK(nums, k));
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertArrayEquals(new int[]{5}, copyFirstK(nums, k));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int k = solution.removeDuplicates(nums);

        assertEquals(0, k);
    }

    @Test
    void testAllElementsSame() {
        int[] nums = {2, 2, 2, 2};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertArrayEquals(new int[]{2}, copyFirstK(nums, k));
    }

    /**
     * Utility method to copy the first k elements from an array.
     */
    private int[] copyFirstK(int[] nums, int k) {
        int[] result = new int[k];
        System.arraycopy(nums, 0, result, 0, k);
        return result;
    }
}
