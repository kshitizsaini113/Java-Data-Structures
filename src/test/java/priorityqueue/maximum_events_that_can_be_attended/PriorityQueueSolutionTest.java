package priorityqueue.maximum_events_that_can_be_attended;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the {@link PriorityQueueSolution} class.
 */
class PriorityQueueSolutionTest {

    private PriorityQueueSolution solution;

    @BeforeEach
    void setUp() {
        solution = new PriorityQueueSolution();
    }

    @Test
    void testLeetCodeExample1() {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}};
        assertEquals(3, solution.maxEvents(events), "Should be able to attend all three sequential events.");
    }

    @Test
    void testLeetCodeExample2() {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        assertEquals(4, solution.maxEvents(events), "Should attend all four events by careful scheduling.");
    }

    @Test
    void testComplexOverlap() {
        int[][] events = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        // Day 1: Attend {1,1}
        // Day 2: Attend {2,2}
        // Day 3: Attend {1,4} (available since day 1)
        // Day 4: Attend {3,4} or {4,4}
        assertEquals(4, solution.maxEvents(events), "Should correctly handle complex overlapping events.");
    }

    @Test
    void testNoOverlapEvents() {
        int[][] events = {{1, 2}, {4, 5}, {7, 8}};
        assertEquals(3, solution.maxEvents(events), "Should attend all events when there is no overlap.");
    }

    @Test
    void testFullOverlapOnSingleDay() {
        int[][] events = {{1, 1}, {1, 1}, {1, 1}};
        assertEquals(1, solution.maxEvents(events), "Should only attend one event if all are on the same day.");
    }

    @Test
    void testIdenticalLongEvents() {
        int[][] events = {{1, 5}, {1, 5}, {1, 5}};
        // Day 1: Attend one {1,5}
        // Day 2: Attend another {1,5}
        // Day 3: Attend the last {1,5}
        assertEquals(3, solution.maxEvents(events), "Should attend one of the identical events on each available day.");
    }

    @Test
    void testEdgeCaseEmptyEvents() {
        int[][] events = {};
        assertEquals(0, solution.maxEvents(events), "Should return 0 for an empty array of events.");
    }

    @Test
    void testEdgeCaseSingleEvent() {
        int[][] events = {{10, 12}};
        assertEquals(1, solution.maxEvents(events), "Should attend the single available event.");
    }

    @Test
    void testEventsThatStartLate() {
        int[][] events = {{100, 100}, {100, 101}};
        // Day 100: Attend {100, 100}
        // Day 101: Attend {100, 101}
        assertEquals(2, solution.maxEvents(events), "Should handle events that start on a late day.");
    }

    @Test
    void testGreedyChoiceIsOptimal() {
        // On day 2, events {1,2} and {2,3} are available.
        // The greedy choice is to attend {1,2} because it ends sooner.
        // Day 1: Attend {1,1}
        // Day 2: Attend {1,2} (ends today)
        // Day 3: Attend {2,3}
        // Day 4: Attend {3,4}
        int[][] events = {{1, 2}, {1, 1}, {2, 3}, {3, 4}};
        assertEquals(4, solution.maxEvents(events), "Should make the correct greedy choice to maximize events.");
    }
}