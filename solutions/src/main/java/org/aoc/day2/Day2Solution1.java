package org.aoc.day2;

import org.slf4j.LoggerFactory;

import java.util.*;
/**
 * <p>
 * Advent of Code Day 2: Gift Shop
 * </p>
 * <p>
 * You enter the gift shop and discover that some invalid product IDs have been added to the database.
 * Your task is to identify these invalid product IDs based on specific criteria.
 * </p>
 *
 * <p>
 * You will read product ID ranges from CLI input, where each range specifies a minimum and maximum ID.
 * Each range is separated by commas, and within each range, IDs can be checked for validity based on a pattern.
 * </p>
 *
 * <p>
 * An ID is considered invalid if it is made solely of a sequence of digits repeated exactly twice.
 * For example, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) are invalid IDs.
 * An ID with leading zeroes, such as 0101, is not valid and should be disregarded.
 * </p>
 *
 * <p>
 * Your job is to find and sum up all the invalid IDs that fall within the given ranges, producing a total value.
 * </p>
 *
 * <p>
 * Input Example:
 * <pre>
 * 11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
 * 1698522-1698528,446443-446449,38593856-38593862,565653-565659,
 * 824824821-824824827,2121212118-2121212124
 * </pre>
 * </p>
 *
 * <p>Usage:</p>
 * <ul>
 *   <li>javac -d out src/main/java/org/aoc/<day>/<className>.java </li>
 *   <li>java -cp out org.aoc.<day>.<className></li>
 *   <li>Paste raw input from AOC.com::/2025/day/<dayNumber>/input</li>
 * </ul>
 * OR run the application from your IDE
 */


public class Day2Solution1 {
    //static {System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");}
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Day2Solution1.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> ranges = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            ranges.addAll(Arrays.asList(line.split(",")));
        }
        scanner.close();
        run(ranges);
        partTwo(ranges);
    }

    // Checks for repeated ID sequence
    static boolean isInvalid(long n) {
        String s = Long.toString(n);
        int len = s.length();

        // Odd numbers cannot be repeated
        if (len % 2 != 0) return false;

        String firstHalf = s.substring(0, len / 2);
        String secondHalf = s.substring(len / 2);

        return firstHalf.equals(secondHalf);
    }


    public static long run(List<String> ranges) {
        long totalSum = 0;

        for (String range : ranges) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]);
            long sum = 0;

            for (long i = start; i <= end; i++) {
                if (isInvalid(i)) sum += i;
            }

            //log.info("Sum for range {}-{}: {}", start, end, sum);
            totalSum += sum;
        }

        System.out.println("Total sum of invalid IDs: " + totalSum);
        return totalSum;
    }
    static boolean isInvalidPartTwo(long n) {
        String s = Long.toString(n);
        int len = s.length();

        for (int seqLen = 1; seqLen <= len / 2; seqLen++) {

            // Sequence length should divide evenly
            if (len % seqLen != 0) continue;


            int repeats = len / seqLen; // amount of repetitions (e.g. len = 6, seqLen = 2, repeats = 6/2 = 3)
            String pattern = s.substring(0, seqLen);
            boolean allMatch = true;

            for (int i = 1; i < repeats; i++) {
                if (!s.substring(i * seqLen, (i + 1) * seqLen).equals(pattern)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) return true;
        }

        return false;
    }

    public static long partTwo(List<String> ranges) {
        long totalSum = 0;

        for (String range : ranges) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]);
            long sum = 0;

            for (long i = start; i <= end; i++) {
                if (isInvalidPartTwo(i)) sum += i;
            }

            //log.info("Sum for range {}-{}: {}", start, end, sum);
            totalSum += sum;
        }

        System.out.println("Total sum of invalid IDs: " + totalSum);
        return totalSum;
    }
}