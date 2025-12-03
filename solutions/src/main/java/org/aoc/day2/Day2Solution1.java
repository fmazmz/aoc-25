package org.aoc.day2;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * <p>
 * Advent of Code Day 2: Gift Shop
 * </p>
 * <p>
 * Reads rotations from CLI input (one per line), simulates a circular dial from 0 to 99
 * starting at 50, and counts how many times the dial lands at 0.
 * End input with Ctrl+D (Linux/Mac) or Ctrl+Z + Enter (Windows).
 * </p>
 *
 * <p>Usage:</p>
 * <ul>
 *   <li>javac -d out src/main/java/org/aoc/day1/Day1Solution1.java </li>
 *   <li>java -cp out org.aoc.day1.Day1Solution1</li>
 *   <li>Paste raw input from AOC::2025/day/1/input</li>
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


    static void run(List<String> ranges) {
        long totalSum = 0;

        for (String range : ranges) {
            long start = Long.parseLong(range.split("-")[0]);
            long end = Long.parseLong(range.split("-")[1]);
            long sum = 0;

            for (long i = start; i <= end; i++) {
                if (isInvalid(i)) sum += i;
            }

            log.info("Sum for range {}-{}: {}", start, end, sum);
            totalSum += sum;
        }

        System.out.println("Total sum of invalid IDs: " + totalSum);
    }
}