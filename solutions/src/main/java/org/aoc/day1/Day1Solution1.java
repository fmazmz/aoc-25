package org.aoc.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


/**
 * <p>
 * Advent of Code Day 1: Secret Entrance
 * </p>
 * <p>
 * Reads rotations from CLI input (one per line), simulates a circular dial from 0 to 99
 * starting at 50, and counts how many times the dial lands at 0.
 * End input with Ctrl+D (Linux/Mac) or Ctrl+Z + Enter (Windows).
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

public class Day1Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> rotations = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            rotations.add(line);
        }
        scanner.close();
        run(rotations);
    }

    static void run(List<String> rotations) {

        List<String> sequence = new ArrayList<>(rotations);
        int currentIdx = 50;
        int zeros = 0;

        for (String string : sequence) {
            String s = string.substring(0, 1);
            int rotation = Integer.parseInt(string.substring(1));

            // Left rotation
            if (Objects.equals(s, "L")) currentIdx = (currentIdx - rotation) % 100;
                // Right rotation
            else currentIdx = (currentIdx + rotation) % 100;

            // handle negative rotations
            if (currentIdx < 0) currentIdx += 100;

            if (currentIdx == 0) zeros++;
        }
        System.out.println("Password: " + zeros);
    }
}