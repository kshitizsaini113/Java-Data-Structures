package string.original_typed_string_one;

/**
 * Solves the "Find the Original Typed String I" problem using a single iteration.
 */
public class Iteration {

    /**
     * Calculates the total number of possible original strings that could result
     * in the given {@code word} after at most one long-press key action.
     *
     * <p><b>Algorithm Explanation:</b>
     * The total number of possibilities is the sum of two cases:
     * <ol>
     *     <li><b>No long-press:</b> The original string was {@code word} itself. This always accounts for 1 possibility.</li>
     *     <li><b>Exactly one long-press:</b> A shorter original string was typed, and one key was held down to produce a run of identical characters in {@code word}.</li>
     * </ol>
     * A long-press event is only identifiable where there are consecutive identical characters.
     * For each adjacent pair of identical characters {@code word[i] == word[i-1]}, we can hypothesize
     * a unique scenario where a shorter original string was expanded. For example, if the word is "helllo":
     * <ul>
     *     <li>The base case is "helllo" (no long-press). Count = 1.</li>
     *     <li>At index 3 ('l'), {@code word[3] == word[2]}. This implies an original "helo" could have been typed, with the 'l' being long-pressed. Count = 2.</li>
     *     <li>At index 4 ('l'), {@code word[4] == word[3]}. This implies an original "hello" could have been typed, with the second 'l' being long-pressed. Count = 3.</li>
     * </ul>
     * This logic simplifies to: {@code 1 + (the number of times a character is identical to its preceding character)}.
     *
     * <p><b>Time Complexity:</b> O(n), where n is the length of the {@code word}, as we perform a single pass through the string.
     *
     * <p><b>Space Complexity:</b> O(1), as we only use a constant amount of extra space for the counter.
     *
     * @param word The final string displayed on the screen.
     * @return The total number of possible original strings. Returns 0 for a null or empty string.
     */
    public int possibleStringCount(String word) {
        // A null or empty string has no possible original versions.
        if (word == null || word.isEmpty()) {
            return 0;
        }

        // Start with 1 to account for the case where no long-press occurred
        // (i.e., the original string is the word itself).
        int count = 1;

        for (int i = 1; i < word.length(); i++) {
            // Each time a character is a repeat of its predecessor, it represents
            // another possible original string that could have been expanded by a long-press.
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}