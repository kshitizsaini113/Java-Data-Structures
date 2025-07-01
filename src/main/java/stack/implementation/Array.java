package stack.implementation;

import java.util.EmptyStackException;

/**
 * An implementation of a fixed-size stack data structure using an array.
 *
 * <p>This class provides the fundamental stack operations (push, pop, peek)
 * and follows the Last-In, First-Out (LIFO) principle. Once created, the
 * capacity of the stack cannot be changed.
 */
public class Array {

    private final int[] arr;
    private int top;

    /**
     * Constructs a new stack with the specified maximum size.
     *
     * <p><b>Complexity:</b>
     * <ul>
     * <li>Time: O(N) where N is the size, due to array allocation.
     * <li>Space: O(N) to store the stack elements.
     * </ul>
     *
     * @param size The maximum number of elements the stack can hold.
     */
    public Array(int size) {
        arr = new int[size];
        top = -1;
    }

    /**
     * Pushes an element onto the top of this stack.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @param value The element to be pushed onto the stack.
     * @throws StackOverflowError if the stack is full.
     */
    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full. Cannot push element.");
        }
        arr[++top] = value;
    }

    /**
     * Removes the element at the top of this stack and returns that element.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @return The element at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // The element is not actually removed, just made inaccessible.
        // The next push will overwrite it.
        return arr[top--];
    }

    /**
     * Looks at the element at the top of this stack without removing it.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @return The element at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    /**
     * Tests if this stack is empty.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @return {@code true} if and only if this stack contains no items;
     * {@code false} otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Tests if this stack is full.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @return {@code true} if the stack has reached its maximum capacity;
     * {@code false} otherwise.
     */
    public boolean isFull() {
        return top == arr.length - 1;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * <p><b>Complexity:</b> O(1) time and O(1) space.
     *
     * @return The number of elements currently in the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays the contents of the stack from top to bottom.
     * This method is primarily for debugging purposes.
     *
     * <p><b>Complexity:</b> O(N) time, where N is the current number of elements
     * in the stack. O(1) space.
     */
    public void display() {
        System.out.print("Stack (top to bottom): [ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}