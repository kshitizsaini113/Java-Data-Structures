package stack.next_greater_element;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implements a solution to the "Next Greater Element" problem using a Monotonic Stack.
 *
 * <p>A monotonic stack is a stack whose elements are always in a sorted order
 * (either increasing or decreasing). This data structure is highly efficient for
 * problems involving finding the next or previous greater/smaller element in an array.
 *
 * <p>This implementation finds the next greater element for each element in an array
 * by iterating from right to left and maintaining a monotonically decreasing stack.
 *
 * <p><b>Complexity:</b>
 * <ul>
 *   <li>Time: O(N), where N is the number of elements in the array. Each element is
 *       pushed and popped from the stack at most once.</li>
 *   <li>Space: O(N), for storing the stack and the answer array.</li>
 * </ul>
 */
public class MonotonicStack {
    public final int[] answer; // Public for easy access in test cases
    private final int[] array;

    /**
     * Initializes the data structure with the input array.
     *
     * @param array The input array for which to find the next greater elements.
     */
    public MonotonicStack(int[] array) {
        this.array = array;
        this.answer = new int[array.length];
    }

    /**
     * Populates the {@code answer} array with the next greater element for each
     * element in the input array.
     *
     * <p>The algorithm iterates through the input array from right to left. A stack
     * is used to keep track of elements that could be the "next greater" for
     * elements to their left.
     *
     * <p>For each element {@code array[i]}:
     * <ol>
     *   <li>While the stack is not empty and the element at the top of the stack is
     *       less than or equal to {@code array[i]}, pop from the stack. This removes
     *       elements that can never be the next greater element for anything to the left.</li>
     *   <li>After popping, if the stack is empty, it means there is no greater element
     *       to the right. Otherwise, the element at the top of the stack is the
     *       next greater element.</li>
     *   <li>Push the current element {@code array[i]} onto the stack to be a potential
     *       next greater element for items to its left.</li>
     * </ol>
     */
    public void findNextGreaterElement() {
        // Using Deque is the recommended modern approach for stack implementations.
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = array.length - 1; i >= 0; i--) {
            // Pop elements from the stack that are smaller than or equal to the current element.
            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            // If the stack is empty, no greater element exists to the right.
            // Otherwise, the top of the stack is the next greater element.
            answer[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push the current element onto the stack for future comparisons.
            stack.push(array[i]);
        }
    }
}