package stack.implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;


class ArrayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Array stack;

    @BeforeEach
    void setUp() {
        // Create a new stack with a capacity of 5 before each test
        stack = new Array(5);
        // Redirect System.out to our stream capture
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // Restore the original System.out stream
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("A new stack should be empty")
    void newStackIsEmpty() {
        assertTrue(stack.isEmpty(), "A newly created stack should be empty.");
        assertEquals(0, stack.size(), "A newly created stack should have a size of 0.");
        assertFalse(stack.isFull(), "A newly created stack should not be full.");
    }

    @Test
    @DisplayName("Pushing an element should increase size and allow peeking")
    void pushAndPeek() {
        stack.push(10);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek(), "Peek should return the last element pushed.");

        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek(), "Peek should be updated after a new push.");
    }

    @Test
    @DisplayName("Popping an element should return it and decrease size (LIFO)")
    void popFollowsLifo() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(3, stack.size());

        assertEquals(30, stack.pop(), "Pop should return the last element added (30).");
        assertEquals(2, stack.size(), "Size should decrease after pop.");

        assertEquals(20, stack.pop(), "Pop should return the next element (20).");
        assertEquals(1, stack.size());

        assertEquals(10, stack.pop(), "Pop should return the final element (10).");
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty(), "Stack should be empty after all elements are popped.");
    }

    @Test
    @DisplayName("Peeking into an empty stack should throw EmptyStackException")
    void peekOnEmptyStackThrowsException() {
        assertTrue(stack.isEmpty());
        assertThrows(EmptyStackException.class, () -> stack.peek(), "Peeking into an empty stack must throw EmptyStackException.");
    }

    @Test
    @DisplayName("Popping from an empty stack should throw EmptyStackException")
    void popOnEmptyStackThrowsException() {
        assertTrue(stack.isEmpty());
        assertThrows(EmptyStackException.class, () -> stack.pop(), "Popping from an empty stack must throw EmptyStackException.");
    }

    @Test
    @DisplayName("Pushing to a full stack should throw StackOverflowError")
    void pushOnFullStackThrowsException() {
        // Fill the stack to its capacity
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.isFull(), "Stack should be full after pushing 5 elements.");
        assertEquals(5, stack.size());

        // Assert that the next push throws the expected error
        assertThrows(StackOverflowError.class, () -> stack.push(6), "Pushing to a full stack must throw StackOverflowError.");
    }

    @Test
    @DisplayName("isFull should be true only at maximum capacity")
    void isFull() {
        Array smallStack = new Array(2);
        assertFalse(smallStack.isFull());

        smallStack.push(1);
        assertFalse(smallStack.isFull());

        smallStack.push(2);
        assertTrue(smallStack.isFull());
    }

    @Test
    @DisplayName("Constructor with negative capacity should throw NegativeArraySizeException")
    void constructorWithNegativeCapacityThrowsException() {
        assertThrows(NegativeArraySizeException.class, () -> new Array(-1), "Constructor should not allow a negative size.");
    }

    @Test
    @DisplayName("display() on an empty stack should print correctly")
    void displayOnEmptyStack() {
        stack.display();
        String expectedOutput = "Stack (top to bottom): [ ]" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("display() on a populated stack should print elements top-to-bottom")
    void displayOnPopulatedStack() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        // Note the LIFO order in the output (30 is on top)
        String expectedOutput = "Stack (top to bottom): [ 30 20 10 ]" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}