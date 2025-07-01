package string.original_typed_string_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link Iteration} class.
 */
class IterationTest {

    private final Iteration iteration = new Iteration();

    @Test
    @DisplayName("Should return 0 for a null string")
    void testPossibleStringCount_withNullString() {
        assertEquals(0, iteration.possibleStringCount(null), "A null string should result in 0 possibilities.");
    }

    @Test
    @DisplayName("Should return 0 for an empty string")
    void testPossibleStringCount_withEmptyString() {
        assertEquals(0, iteration.possibleStringCount(""), "An empty string should result in 0 possibilities.");
    }

    @Test
    @DisplayName("Should return 1 for a single character string")
    void testPossibleStringCount_withSingleCharacter() {
        assertEquals(1, iteration.possibleStringCount("a"), "A single character string has only one possibility.");
    }

    @Test
    @DisplayName("Should return 1 when no long-press is possible")
    void testPossibleStringCount_withNoLongPress() {
        assertEquals(1, iteration.possibleStringCount("abcde"), "A string with no adjacent duplicates has only one possibility.");
    }

    @Test
    @DisplayName("Should handle a single long-press in the middle")
    void testPossibleStringCount_withSingleLongPress() {
        // Possibilities: "hello" (no long-press) and "helo" (long-press 'l')
        assertEquals(2, iteration.possibleStringCount("hello"));
    }

    @Test
    @DisplayName("Should handle multiple long-presses on the same character")
    void testPossibleStringCount_withMultipleLongPressesOnSameChar() {
        // Possibilities: "helllo", "hello", "helo"
        assertEquals(3, iteration.possibleStringCount("helllo"));
    }

    @Test
    @DisplayName("Should handle multiple long-presses on different characters")
    void testPossibleStringCount_withMultipleLongPressesOnDifferentChars() {
        // Possibilities: "heelloo", "heloo", "heeloo", "heello"
        assertEquals(4, iteration.possibleStringCount("heelloo"));
    }

    @Test
    @DisplayName("Should handle a string with all identical characters")
    void testPossibleStringCount_withAllSameCharacters() {
        // Possibilities: "aaaa", "aaa", "aa", "a"
        assertEquals(4, iteration.possibleStringCount("aaaa"));
    }

    @Test
    @DisplayName("Should handle a long-press at the beginning of the string")
    void testPossibleStringCount_withLongPressAtStart() {
        // Possibilities: "aabc", "abc"
        assertEquals(2, iteration.possibleStringCount("aabc"));
    }

    @Test
    @DisplayName("Should handle a long-press at the end of the string")
    void testPossibleStringCount_withLongPressAtEnd() {
        // Possibilities: "abcc", "abc"
        assertEquals(2, iteration.possibleStringCount("abcc"));
    }
}