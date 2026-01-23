package array.rotate_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test class for {@link RotateArray}.
 */
class RotateArrayTest {

    private final RotateArray rotateArray = new RotateArray();

    @Test
    void testRotateByNormalK() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    void testRotateByZero() {
        int[] nums = {1, 2, 3};
        rotateArray.rotate(nums, 0);
        assertArrayEquals(new int[]{1, 2, 3}, nums);
    }

    @Test
    void testRotateByArrayLength() {
        int[] nums = {1, 2, 3, 4};
        rotateArray.rotate(nums, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nums);
    }

    @Test
    void testRotateByMoreThanArrayLength() {
        int[] nums = {1, 2, 3};
        rotateArray.rotate(nums, 5);
        assertArrayEquals(new int[]{2, 3, 1}, nums);
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {10};
        rotateArray.rotate(nums, 3);
        assertArrayEquals(new int[]{10}, nums);
    }
}
