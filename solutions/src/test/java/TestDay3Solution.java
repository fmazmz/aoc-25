import org.aoc.day3.Day3Solution1;
import org.junit.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Testcontainers
public class TestDay3Solution {

    /**
     * <p>Tests the solution for Part 1 of Day 3: Lobby.</p>
     * <p>
     * This test verifies that the calculation of the maximum voltage from
     * pairs of batteries in each bank is correct.
     * Specifically, it checks that the total output joltage obtained
     * from activating batteries in the input banks matches the expected sum.
     * </p>
     *
     * <p>Invalid IDs are defined as numbers formed by digit sequences
     * that can be split into two equal halves. For example, '1212'
     * is invalid because it can be broken down into '12' and '12'.
     * Only numbers with even lengths made from repeated halves count
     * as invalid.
     * </p>
     *
     * <p>Example Input:</p>
     * <pre>
     * 987654321111111
     * 811111111111119
     * 234234234234278
     * 818181911112111
     * </pre>
     *
     * <p>Expected Output:</p>
     * <pre>357</pre>
     */
    @Test
    public void testPartOne() {
        List<String> input = new ArrayList<>();
        input.add("987654321111111");
        input.add("811111111111119");
        input.add("234234234234278");
        input.add("818181911112111");

        int expected = 357;
        int totalOutputJoltage = Day3Solution1.calculateTotalOutputJoltage(input);

        assertEquals(expected, totalOutputJoltage);
    }
}
