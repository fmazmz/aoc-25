import org.aoc.day2.Day2Solution1;
import org.junit.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Testcontainers
public class TestDay2Solution {


    /**
     * <p>Tests Part 1 solution.</p>
     * <p>
     * Verifies that the sum of invalid IDs (numbers with repeated halves)
     * in the provided ranges matches the expected value.
     *</p>
     *
     * <p>rules: only numbers with even length and repeated halves are invalid.</p>
     *
     */
    @Test
    public void testPartOne() {
        List<String> input = new ArrayList<>();
        input.add("11-22");
        input.add("95-115");

        // Capture the sum by calling run directly
        long totalSum = Day2Solution1.run(input);

        // 111 not included as its odd - part one requirement
        long expectedSum = 11 + 22 + 99;
        assertEquals(expectedSum, totalSum);
    }


    /**
     * <p>
     * Tests Part 2 solution.
     * </p>
     * <p>
     * Verifies that the sum of invalid IDs (numbers with any repeated sequence)
     * in the provided ranges matches the expected value.
     * </p>
     *
     *<p>rules: any number consisting of a repeated sequence at least twice is invalid.</p>
     */
    @Test
    public void testPartTwo() {
        List<String> input = new ArrayList<>();
        input.add("11-22");
        input.add("95-115");
        input.add("565653-565659");

        long totalSum = Day2Solution1.partTwo(input);

        // Include odd numbers
        long expectedSum = 11 + 22 + 99 + 111 + 565656;
        assertEquals(expectedSum, totalSum);
    }
}
