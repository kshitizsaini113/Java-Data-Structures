package array.check_if_array_is_sorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckSortedTest {

    private final CheckSorted checker = new CheckSorted();

    @Test
    void testNullArray() {
        assertTrue(checker.checkSorted(null));
    }

    @Test
    void testEmptyArray() {
        assertTrue(checker.checkSorted(new int[]{}));
    }

    @Test
    void testSingleElementArray() {
        assertTrue(checker.checkSorted(new int[]{5}));
    }

    @Test
    void testAlreadySortedArray() {
        assertTrue(checker.checkSorted(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testArrayWithDuplicates() {
        assertTrue(checker.checkSorted(new int[]{1, 2, 2, 3, 3}));
    }

    @Test
    void testUnsortedArray() {
        assertFalse(checker.checkSorted(new int[]{3, 1, 4, 2}));
    }

    @Test
    void testDescendingArray() {
        assertFalse(checker.checkSorted(new int[]{5, 4, 3, 2, 1}));
    }
}
