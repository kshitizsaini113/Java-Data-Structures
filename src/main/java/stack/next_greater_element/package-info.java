/**
 * Provides solutions for the "Next Greater Element" problem using a Monotonic Stack.
 *
 * <p>The "Next Greater Element" problem involves finding the first element to the
 * right of a given element in an array that is strictly greater. If no such
 * element exists, a default value (e.g., -1) is used.
 *
 * <h3>Core Implementation Strategy: Monotonic Stack</h3>
 *
 * <p>This package utilizes a <strong>Monotonic Stack</strong>, a highly efficient
 * data structure for this category of problems. A monotonic stack maintains its
 * elements in a sorted order (either increasing or decreasing).
 *
 * <p>The general algorithm is as follows:
 * <ol>
 *   <li>Iterate through the input array, typically from right to left.</li>
 *   <li>For each element, pop elements from the stack that are less than or
 *       equal to the current element. This ensures the stack's monotonic property
 *       is maintained.</li>
 *   <li>The element now at the top of the stack is the "next greater element" for
 *       the current array element. If the stack is empty, no greater element exists.</li>
 *   <li>Push the current element onto the stack.</li>
 * </ol>
 *
 * <p>This approach guarantees that each element is pushed and popped at most once,
 * resulting in an optimal time complexity of O(N).
 *
 * @version 1.0
 * @see stack.next_greater_element.MonotonicStack
 * @since 1.0
 */
package stack.next_greater_element;